package com.yoler.grape.service.browser.patient.impl;

import com.yoler.grape.dao.mapper.PatientConditionMapper;
import com.yoler.grape.dao.mapper.PatientInfoMapper;
import com.yoler.grape.dao.mapper.PrescriptionMapper;
import com.yoler.grape.entity.PatientCondition;
import com.yoler.grape.entity.PatientInfo;
import com.yoler.grape.entity.Prescription;
import com.yoler.grape.service.browser.patient.PatientService;
import com.yoler.grape.util.DateFormatUtil;
import com.yoler.grape.util.StringUtil;
import com.yoler.grape.vo.browser.BrowserMounthDatasVo;
import com.yoler.grape.vo.browser.BrowserPatientBriefInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("browserPatientServiceImpl")
public class PatientServiceImpl implements PatientService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    PatientConditionMapper patientConditionMapper;

    @Autowired
    PatientInfoMapper patientInfoMapper;

    @Autowired
    PrescriptionMapper prescriptionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveToImportConsilia(List<List<String>> toImportDatas) throws Exception {
        for (int i = 1; i < toImportDatas.size(); i++) {
            List<String> rowDatas = toImportDatas.get(i);
            logger.debug(rowDatas.size() + "");
            if (rowDatas.size() == 16) {
                String patientName = rowDatas.get(0);
                String patientSex = rowDatas.get(1);
                String patientAge = rowDatas.get(2);
                String patientBirthday = rowDatas.get(3);
                String patientZodiac = rowDatas.get(4);
                String patientIntroducer = rowDatas.get(5);
                String visitingDate = rowDatas.get(6);
                String addCondition = rowDatas.get(7);
                String pulse = rowDatas.get(8);
                String tongue = rowDatas.get(9);
                String prescriptionDetail = rowDatas.get(10);
                String prescriptionMethod = rowDatas.get(11);
                String prescriptionDuration = rowDatas.get(12);
                String advice = rowDatas.get(13);
                String analysis = rowDatas.get(14);
                String zhaoSirSay = rowDatas.get(15);
                int patientInfoId = insertPatientInfo(patientName, patientSex, patientAge, patientBirthday, patientZodiac, patientIntroducer);
                int patientConditionId = insertPatientCondition(patientInfoId, visitingDate, pulse, tongue, addCondition, analysis);
                insertPrescription(patientConditionId, null, prescriptionDetail, prescriptionMethod, prescriptionDuration, advice, zhaoSirSay);
            }
        }


    }

    @Override
    public List<BrowserPatientBriefInfoVo> getBrowserPatientBriefInfo(int pageIdx, int recordPerPage) {
        List<BrowserPatientBriefInfoVo> result = new ArrayList<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("offset", (pageIdx - 1) * recordPerPage);
        queryMap.put("recordPerPage", recordPerPage);
        try {
            result = patientConditionMapper.getBrowserPatientBriefInfo(queryMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Map<String, Object> getBrowserMounthDatas() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        List<BrowserMounthDatasVo> browserMounthDatas = patientConditionMapper.getBrowserMounthDatas(queryMap);
        result.put("content", browserMounthDatas);
        result.put("status", "200");
        return result;
    }

    /**
     * 插入病人信息
     *
     * @param patientName
     * @param patientSex
     * @param patientAge
     * @param patientBirthday
     * @param patientZodiac
     * @param patientIntroducer
     * @return
     */
    private int insertPatientInfo(String patientName, String patientSex, String patientAge, String patientBirthday, String patientZodiac, String patientIntroducer) {
        int patientInfoId;
        PatientInfo patientInfo = patientInfoMapper.getPatientInfoByName(patientName);
        if (patientInfo == null) {
            patientInfo = new PatientInfo();
            patientInfo.setName(patientName);
            patientInfo.setSex(patientSex);
            patientInfo.setAge(StringUtil.isEmpty(patientAge.trim()) ? 0 : (int) Double.parseDouble(patientAge));
            patientInfo.setBirthday(patientBirthday);
            patientInfo.setZodiac(patientZodiac);
            patientInfo.setIntroducer(patientIntroducer);
            patientInfoMapper.insert(patientInfo);
            patientInfoId = patientInfo.getId();
        } else {
            patientInfoId = patientInfo.getId();
        }
        return patientInfoId;
    }

    private int insertPatientCondition(int patientInfoId, String visitingDate, String pulse, String tongue, String addCondition, String analysis) throws Exception {
        PatientCondition patientCondition = new PatientCondition();
        patientCondition.setPatientInfoId(patientInfoId);
        if (StringUtil.isEmpty(visitingDate)) {
            throw new Exception("就诊日期为空");
        } else {
            patientCondition.setVisitingDate(DateFormatUtil.parseDateTime(visitingDate));
        }
        patientCondition.setPulse(pulse);
        patientCondition.setTongue(tongue);
        patientCondition.setAddCondition(addCondition);
        patientCondition.setAnalysis(analysis);
        patientConditionMapper.insert(patientCondition);
        return patientCondition.getId();
    }

    private void insertPrescription(int patientConditionId, String prescriptionName, String prescriptionDetail, String prescriptionMethod, String prescriptionDuration, String advice, String zhaoSirSay) {
        Prescription prescription = new Prescription();
        prescription.setDoctorId(0);
        prescription.setPatientConditionId(patientConditionId);
        prescription.setPrescriptionName(prescriptionName);
        prescription.setPrescriptionDetail(prescriptionDetail);
        prescription.setPrescriptionMethod(prescriptionMethod);
        prescription.setPrescriptionDuration(prescriptionDuration);
        prescription.setAdvice(advice);
        prescription.setZhaoSirSay(zhaoSirSay);
        prescriptionMapper.insert(prescription);
    }
}
