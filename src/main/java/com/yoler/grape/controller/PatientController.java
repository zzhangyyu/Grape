package com.yoler.grape.controller;

import com.yoler.grape.request.ConsiliaDateDirReq;
import com.yoler.grape.request.ConsiliaDateIntroReq;
import com.yoler.grape.request.ConsiliaDetailReq;
import com.yoler.grape.service.patient.PatientService;
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
    PatientService patientService;

    @RequestMapping(value = "getConsiliaDateDir", method = RequestMethod.POST)
    public @ResponseBody
    String getDateDir(@RequestBody String reqJson) {
        logger.debug("getConsiliaDateDir req is :" + reqJson);
        ConsiliaDateDirReq req = GsonUtil.jsonToObject(reqJson, ConsiliaDateDirReq.class);
        Map<String, Object> resultMap = patientService.getConsiliaDateDir(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getConsiliaDateDir resp is :" + result);
        return result;
    }

    @RequestMapping(value = "getConsiliaDateIntro", method = RequestMethod.POST)
    public @ResponseBody
    String getPatientByDate(@RequestBody String reqJson) {
        logger.debug("getConsiliaDateIntro req is :" + reqJson);
        ConsiliaDateIntroReq req = GsonUtil.jsonToObject(reqJson, ConsiliaDateIntroReq.class);
        Map<String, Object> resultMap = patientService.getConsiliaDateIntro(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getConsiliaDateIntro resp is :" + result);
        return result;
    }

    @RequestMapping(value = "getConsiliaPatientIntro", method = RequestMethod.POST)
    public @ResponseBody
    String getPatientByName(@RequestBody String reqJson) {
        Map<String, Object> resultMap = patientService.getConsiliaPatientIntro(reqJson);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getConsiliaPatientIntro resp is :" + result);
        return result;
    }

    @RequestMapping(value = "getConsiliaDetail", method = RequestMethod.POST)
    public @ResponseBody
    String getPatientCondition(@RequestBody String reqJson) {
        logger.debug("getConsiliaDetail req is :" + reqJson);
        ConsiliaDetailReq req = GsonUtil.jsonToObject(reqJson, ConsiliaDetailReq.class);
        Map<String, Object> resultMap = patientService.getConsiliaDetail(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getConsiliaDetail resp is :" + result);
        return result;
    }
}
