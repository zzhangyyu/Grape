package com.yoler.grape.controller;

import com.yoler.grape.request.UserFavouritePatientReq;
import com.yoler.grape.service.user.UserService;
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
@RequestMapping(value = "/user/")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @RequestMapping(value = "getUserFavouritePatient", method = RequestMethod.POST)
    public @ResponseBody
    String getUserFavouritePatient(@RequestBody String reqJson) {
        logger.debug("getUserFavouritePatient req is :" + reqJson);
        UserFavouritePatientReq req = GsonUtil.jsonToObject(reqJson, UserFavouritePatientReq.class);
        Map<String, Object> resultMap = userService.getUserFavouritePatient(req);
        String result = GsonUtil.objectToJson(resultMap);
        logger.debug("getUserFavouritePatient resp is :" + result);
        return result;
    }

}
