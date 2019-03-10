package com.yoler.grape.controller.mobile;

import com.yoler.grape.request.mobile.*;
import com.yoler.grape.service.mobile.patient.PatientService;
import com.yoler.grape.util.GsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by zhangyu on 2017/6/28.
 */
@Api(tags = "Patient", description = "病人相关接口")
@RestController
@RequestMapping(value = "/patient/")
public class PatientController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PatientService patientService;

    @ApiOperation(value = "按日期获取病历列表", notes = "按日期获取病历列表，按日期倒序排列")
    @ApiImplicitParam(name = "reqJson", value = "请求json", dataType = "String", required = true)
    @PostMapping(value = "getConsiliaDateDir")
    public String getConsiliaDateDir(@RequestBody String reqJson) {
        logger.debug("getConsiliaDateDir req is :" + reqJson);
        ConsiliaDateDirReq req = GsonUtil.jsonToObject(reqJson, ConsiliaDateDirReq.class);
        Map<String, Object> resultMap = patientService.getConsiliaDateDir(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getConsiliaDateDir resp is :" + result);
        return result;
    }

    @ApiOperation(value = "获取指定日期的病历列表", notes = "获取指定日期的病历列表")
    @ApiImplicitParam(name = "reqJson", value = "请求json", dataType = "String", required = true)
    @PostMapping(value = "getConsiliaDateIntro")
    public String getConsiliaDateIntro(@RequestBody String reqJson) {
        logger.debug("getConsiliaDateIntro req is :" + reqJson);
        ConsiliaDateIntroReq req = GsonUtil.jsonToObject(reqJson, ConsiliaDateIntroReq.class);
        Map<String, Object> resultMap = patientService.getConsiliaDateIntro(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getConsiliaDateIntro resp is :" + result);
        return result;
    }

    @ApiOperation(value = "按姓名获取的病历列表", notes = "按姓名获取的病历列表，并按拼音首字母排序")
    @ApiImplicitParam(name = "reqJson", value = "请求json", dataType = "String", required = true)
    @PostMapping(value = "getConsiliaNameDir")
    public String getConsiliaNameDir(@RequestBody String reqJson) {
        logger.debug("getConsiliaNameDir req is :" + reqJson);
        ConsiliaNameDirReq req = GsonUtil.jsonToObject(reqJson, ConsiliaNameDirReq.class);
        Map<String, Object> resultMap = patientService.getConsiliaNameDir(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getConsiliaNameDir resp is :" + result);
        return result;
    }

    @ApiOperation(value = "指定姓名，获取该病人的病历列表", notes = "指定姓名，获取该病人的病历列表")
    @ApiImplicitParam(name = "reqJson", value = "请求json", dataType = "String", required = true)
    @PostMapping(value = "getConsiliaNameIntro")
    public String getConsiliaNameIntro(@RequestBody String reqJson) {
        logger.debug("getConsiliaNameIntro req is :" + reqJson);
        ConsiliaNameIntroReq req = GsonUtil.jsonToObject(reqJson, ConsiliaNameIntroReq.class);
        Map<String, Object> resultMap = patientService.getConsiliaNameIntro(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getConsiliaNameIntro resp is :" + result);
        return result;
    }

    @ApiOperation(value = "获取病历详情", notes = "获取病历详情")
    @ApiImplicitParam(name = "reqJson", value = "请求json", dataType = "String", required = true)
    @PostMapping(value = "getConsiliaDetail")
    public String getConsiliaDetail(@RequestBody String reqJson) {
        logger.debug("getConsiliaDetail req is :" + reqJson);
        ConsiliaDetailReq req = GsonUtil.jsonToObject(reqJson, ConsiliaDetailReq.class);
        Map<String, Object> resultMap = patientService.getConsiliaDetail(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getConsiliaDetail resp is :" + result);
        return result;
    }
}
