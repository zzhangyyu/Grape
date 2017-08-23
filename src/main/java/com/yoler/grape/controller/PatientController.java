package com.yoler.grape.controller;

import com.yoler.grape.request.PatientByDateReq;
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
    String getPatientByDate(@RequestBody String reqJson) {
        logger.debug("getPatientByDate req is :" + reqJson);
        PatientByDateReq req = GsonUtil.jsonToObject(reqJson, PatientByDateReq.class);
        Map<String, Object> resultMap = patientInfoService.getPatientByDate(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getPatientByDate resp is :" + result);
        return result;
    }

    @RequestMapping(value = "getPatientByName", method = RequestMethod.POST)
    public @ResponseBody
    String getPatientByName(@RequestBody String reqJson) {
        Map<String, Object> result = patientInfoService.getPatientByName(reqJson);
        logger.debug(GsonUtil.objectToJson(result));
        return GsonUtil.objectToJson(result);
    }

    @RequestMapping(value = "getPatientCondition", method = RequestMethod.POST)
    public @ResponseBody
    String getPatientCondition(@RequestBody String reqJson) {
        logger.debug("getPatientCondition req is :" + reqJson);
        Map<String, Object> resultMap = patientInfoService.getPatientCondition();
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getPatientCondition resp is :" + result);
        return result;
    }
}
