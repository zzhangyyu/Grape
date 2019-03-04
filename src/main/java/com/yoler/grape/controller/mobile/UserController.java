package com.yoler.grape.controller.mobile;

import com.yoler.grape.request.mobile.SignInReq;
import com.yoler.grape.request.mobile.SignUpReq;
import com.yoler.grape.request.mobile.UserFavouritePatientReq;
import com.yoler.grape.service.mobile.user.MobileUserService;
import com.yoler.grape.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by zhangyu on 2017/6/28.
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MobileUserService mobileUserService;

    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public String signIn(@RequestBody String reqJson) {
        logger.debug("signIn req is :" + reqJson);
        SignInReq req = GsonUtil.jsonToObject(reqJson, SignInReq.class);
        Map<String, Object> resultMap = mobileUserService.signIn(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("signIn resp is :" + result);
        return result;
    }

    @RequestMapping(value = "signUp", method = RequestMethod.POST)
    public String signUp(@RequestBody String reqJson) {
        logger.debug("signUp req is :" + reqJson);
        SignUpReq req = GsonUtil.jsonToObject(reqJson, SignUpReq.class);
        Map<String, Object> resultMap = mobileUserService.signUp(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("signUp resp is :" + result);
        return result;
    }

    @RequestMapping(value = "getUserFavouritePatient", method = RequestMethod.POST)
    public String getUserFavouritePatient(@RequestBody String reqJson) {
        logger.debug("getUserFavouritePatient req is :" + reqJson);
        UserFavouritePatientReq req = GsonUtil.jsonToObject(reqJson, UserFavouritePatientReq.class);
        Map<String, Object> resultMap = mobileUserService.getUserFavouritePatient(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getUserFavouritePatient resp is :" + result);
        return result;
    }

}
