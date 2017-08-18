package com.yoler.grape.controller;

import com.yoler.grape.service.patient.PatientInfoService;
import com.yoler.grape.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by zhangyu on 2017/6/28.
 */
@Controller
@RequestMapping(value = "/")
public class PatientController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PatientInfoService patientInfoService;

    @RequestMapping(value = "getPatientByDate", method = RequestMethod.POST)
    public @ResponseBody
    String getPatientByDate() {
        Map<String, Object> result = patientInfoService.getPatientByDate();
        logger.debug(GsonUtil.objectToJson(result));
        return GsonUtil.objectToJson(result);
    }

    @RequestMapping(value = "getPatientByName", method = RequestMethod.POST)
    public @ResponseBody
    String getPatientByName(@RequestBody String json) {
        Map<String, Object> result = patientInfoService.getPatientByName(json);
        logger.debug(GsonUtil.objectToJson(result));
        return GsonUtil.objectToJson(result);
    }

    @RequestMapping(value = "getPatientCondition", method = RequestMethod.POST)
    public @ResponseBody
    String getPatientCondition() {
        return null;
    }
}
