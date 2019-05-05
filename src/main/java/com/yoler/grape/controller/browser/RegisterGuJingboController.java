package com.yoler.grape.controller.browser;

import com.yoler.grape.service.browser.patient.RegisterGuJingboService;
import com.yoler.grape.util.DateFormatUtil;
import com.yoler.grape.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by zhangyu on 2019/3/10 12:50
 */
@Controller("browserUserController")
@RequestMapping(value = "/console/")
public class RegisterGuJingboController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RegisterGuJingboService registerService;

    /**
     * 病人挂号页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model) {
        String thisWeekTuesdayDate = DateFormatUtil.getThisWeek(new Date(), 1) + "（周二）";
        String thisWeekThursdayDate = DateFormatUtil.getThisWeek(new Date(), 3) + "（周四）";
        String thisWeekSundayDate = DateFormatUtil.getThisWeek(new Date(), 6) + "（周日）";
        model.addAttribute("thisWeekTuesdayDate", thisWeekTuesdayDate);
        model.addAttribute("thisWeekThursdayDate", thisWeekThursdayDate);
        model.addAttribute("thisWeekSundayDate", thisWeekSundayDate);
        return "register";
    }

    /**
     * 处理病人挂号请求,返回处理结果页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "registerResult", method = RequestMethod.POST)
    public String registerResult(Model model,HttpServletRequest request) {
        String intentionDate = request.getParameter("intentionDate");
        String patientName = request.getParameter("patientName");
        String patientSex = request.getParameter("patientSex");
        String patientAge = request.getParameter("patientAge");
        String patientPhone = request.getParameter("patientPhone");
        String patientIntro = request.getParameter("patientIntro");
        String firstFlag = request.getParameter("firstFlag");
        try {
            Map<String, Object> result = registerService.register4GuJingbo(intentionDate, patientName, patientSex, patientAge, patientPhone, patientIntro, firstFlag);
            if ("200".equals(result.get("status"))) {
                return "registerSuccess";
            } else {
                model.addAttribute("errorMsg", result.get("errorMsg"));
                return "registerError";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            model.addAttribute("errorMsg", "挂号失败，请重试！");
            return "registerError";
        }
    }

    /**
     * 大夫登录页面
     *
     * @return
     */
    @RequestMapping(value = "registerSignIn", method = RequestMethod.GET)
    public String registerSignIn() {
        return "registerSignIn";
    }

    /**
     * 处理大夫登录请求，并返回处理结果，成功时展示挂号详情页面
     *
     * @param model
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "registerList", method = RequestMethod.POST)
    public String registerList(Model model, @RequestParam String account, @RequestParam String password) {
        Map<String, Object> registerSignInResult = registerService.registerSignIn(account, password);
        String status = (String) registerSignInResult.get("status");
        String errorMsg = (String) registerSignInResult.get("errorMsg");
        if ("200".equals(status)) {
            Map<String, Object> queryResult = registerService.getIntentionDateAndWeek();
            model.addAttribute("intentionDateAndWeekList", queryResult.get("content"));
            return "registerList";
        } else if ("500".equals(status)) {
            model.addAttribute("errorMsg", errorMsg);
            return "registerSignIn";
        } else {
            model.addAttribute("errorMsg", "服务器错误");
            return "registerSignIn";
        }
    }

    /**
     * 根据挂号日期查询挂号详情
     *
     * @param intentionDate
     * @return
     */
    @PostMapping(value = "getRegisterDetail")
    public @ResponseBody
    String getRegisterDetail(@RequestBody String intentionDate) {
        Map<String, Object> resultMap = registerService.getRegisterDetail(intentionDate);
        String result = GsonUtil.objectToJson(resultMap);
        return result;
    }

}
