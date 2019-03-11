package com.yoler.grape.controller.browser;

import com.yoler.grape.service.browser.patient.PatientService;
import com.yoler.grape.service.browser.user.UserService;
import com.yoler.grape.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 管理端通用controller
 */
@Controller("browserOverviewController")
@RequestMapping(value = "/console/")
public class OverviewController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @Autowired
    PatientService patientService;

    /**
     * 总览页
     *
     * @return
     */
    @RequestMapping(value = "overViewPage", method = RequestMethod.GET)
    public String overView() {
        return "overview";
    }

    @RequestMapping(value = "getMounthDatas", method = RequestMethod.POST)
    public @ResponseBody
    String getMounthDatas() {
        Map<String, Object> resultMap = patientService.getBrowserMounthDatas();
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug(result);
        return result;
    }
}
