package com.yoler.grape.service.browser.patient.impl;

import cn.hutool.core.bean.BeanUtil;
import com.yoler.grape.dao.mapper.RegisterGuJingboMapper;
import com.yoler.grape.entity.RegisterGuJingbo;
import com.yoler.grape.service.browser.patient.RegisterGuJingboService;
import com.yoler.grape.util.DateFormatUtil;
import com.yoler.grape.util.StringUtil;
import com.yoler.grape.vo.browser.BrowserIntentionDateAndWeekVo;
import com.yoler.grape.vo.browser.BrowserRegisterDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by zhangyu on 2019/3/13 10:34
 */
@Service("browserRegisterGuJingboServiceImpl")
public class RegisterGuJingboServiceImpl implements RegisterGuJingboService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String leftParentheses = "（";
    private static final String rightParentheses = "）";

    @Autowired
    RegisterGuJingboMapper registerGuJingboMapper;

    @Override
    public Map<String, Object> register4GuJingbo(String intentionDateAndWeek, String patientName, String patientSex, String patientAge, String patientPhone, String patientIntro, String firstFlag) {
        Map<String, Object> result = new HashMap<>();
        String validateResult = validateParameter(intentionDateAndWeek, patientName, patientSex, patientAge, patientPhone, patientIntro, firstFlag);
        if (!StringUtil.isEmpty(validateResult)) {
            result.put("status", "501");
            result.put("errorMsg", validateResult);
            return result;
        }
        try {
            List<String> intentionDateAndWeekList = formatIntentionDateAndWeek(intentionDateAndWeek);
            if (isRepeatRegister(intentionDateAndWeekList.get(0), intentionDateAndWeekList.get(1), patientName)) {
                result.put("status", "200");
                return result;
            }
            if (isOverLimitCount(intentionDateAndWeekList.get(0), intentionDateAndWeekList.get(1))) {
                result.put("status", "502");
                result.put("errorMsg", "本" + intentionDateAndWeekList.get(1) + "已预约满号，请选择其它日期或与医生联系");
                return result;
            }
            RegisterGuJingbo registerGuJingbo = new RegisterGuJingbo();
            registerGuJingbo.setIntentionDate(DateFormatUtil.parseDateTime(intentionDateAndWeekList.get(0)));
            registerGuJingbo.setIntentionWeek(intentionDateAndWeekList.get(1));
            registerGuJingbo.setPatientName(patientName);
            registerGuJingbo.setPatientSex(patientSex);
            registerGuJingbo.setPatientAge(patientAge);
            registerGuJingbo.setPatientPhone(patientPhone);
            registerGuJingbo.setPatientIntro(patientIntro);
            registerGuJingbo.setFirstFlag(firstFlag);
            registerGuJingbo.setCreateDate(new Date());
            registerGuJingbo.setUpdateDate(new Date());
            registerGuJingboMapper.insert(registerGuJingbo);
            result.put("status", "200");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result.put("status", "500");
            result.put("errorMsg", "发生未知异常，挂号失败");
            return result;
        }
        return result;
    }

    @Override
    public Map<String, Object> getIntentionDateAndWeek() {
        Map<String, Object> result = new HashMap<>();
        List<BrowserIntentionDateAndWeekVo> intentionDateAndWeekVos = registerGuJingboMapper.getIntentionDateAndWeek();
        result.put("content", intentionDateAndWeekVos);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getRegisterDetail(String intentionDate) {
        Map<String, Object> result = new HashMap<>();
        List<RegisterGuJingbo> registerDetailList = registerGuJingboMapper.getRegisterDetail(DateFormatUtil.parseDateTime(intentionDate));
        List<BrowserRegisterDetailVo> browserRegisterDetailVoList = new ArrayList<>();
        for (RegisterGuJingbo registerGuJingbo : registerDetailList) {
            BrowserRegisterDetailVo browserRegisterDetailVo = new BrowserRegisterDetailVo();
            BeanUtil.copyProperties(registerGuJingbo, browserRegisterDetailVo);
            browserRegisterDetailVo.setIntentionDate(DateFormatUtil.formatDate(registerGuJingbo.getIntentionDate()));
            if ("1".equals(registerGuJingbo.getPatientSex())) {
                browserRegisterDetailVo.setPatientSex("男");
            } else if ("2".equals(registerGuJingbo.getPatientSex())) {
                browserRegisterDetailVo.setPatientSex("女");
            }
            if ("1".equals(registerGuJingbo.getFirstFlag())) {
                browserRegisterDetailVo.setFirstFlag("初诊");
            } else if ("2".equals(registerGuJingbo.getFirstFlag())) {
                browserRegisterDetailVo.setFirstFlag("复诊");
            }
            browserRegisterDetailVoList.add(browserRegisterDetailVo);
        }
        result.put("content", browserRegisterDetailVoList);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> registerSignIn(String account, String password) {
        Map<String, Object> result = new HashMap<>();
        if (account.equals("gu") && password.equals("888888")) {
            result.put("status", "200");
        } else {
            result.put("status", "500");
            result.put("errorMsg", "用户名或密码错误");
        }
        return result;
    }

    private String validateParameter(String intentionDateAndWeek, String patientName, String patientSex, String patientAge, String patientPhone, String patientIntro, String firstFlag) {
        if (StringUtil.isEmpty(intentionDateAndWeek)) {
            return "请选择就诊日期";
        }
        if (StringUtil.isEmpty(patientName)) {
            return "请填写姓名";
        }
        if (StringUtil.isEmpty(patientPhone)) {
            return "请填写手机号";
        }
        if (StringUtil.isEmpty(patientSex)) {
            return "请选择性别";
        }
        if (StringUtil.isEmpty(firstFlag)) {
            return "请选择初诊&复诊";
        }
        if (intentionDateAndWeek.indexOf(leftParentheses) < 0 || intentionDateAndWeek.indexOf(rightParentheses) < 0) {
            return "就诊日期格式错误";
        }
        return null;
    }

    /**
     * 格式化意向就诊日期和周
     *
     * @param intentionDateAndWeek
     * @return
     */
    private List<String> formatIntentionDateAndWeek(String intentionDateAndWeek) {
        List<String> result = new ArrayList<>();
        int leftParenthesesIndex = intentionDateAndWeek.indexOf(leftParentheses);
        int rightParenthesesInde = intentionDateAndWeek.indexOf(rightParentheses);
        String intentionDate = intentionDateAndWeek.substring(0, leftParenthesesIndex);
        String intentionWeek = intentionDateAndWeek.substring(leftParenthesesIndex + 1, rightParenthesesInde);
        result.add(intentionDate);
        result.add(intentionWeek);
        return result;
    }

    private boolean isRepeatRegister(String intentionDate, String intentionWeek, String patientName) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("intentionDate", intentionDate);
        queryMap.put("intentionWeek", intentionWeek);
        queryMap.put("patientName", patientName);
        int registerCnt = registerGuJingboMapper.getRegisterCntByNameAndDate(queryMap);
        if (registerCnt > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isOverLimitCount(String intentionDate, String intentionWeek) {
        final int thursdayLimit = 15;
        final int sundayLimit = 25;
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("intentionDate", intentionDate);
        queryMap.put("intentionWeek", intentionWeek);
        int registeredCount = registerGuJingboMapper.getRegisterCntByDate(queryMap);
        if ("周四".equals(intentionWeek)) {
            if (registeredCount >= thursdayLimit) {
                return true;
            } else {
                return false;
            }
        } else if ("周日".equals(intentionWeek)) {
            if (registeredCount >= sundayLimit) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
