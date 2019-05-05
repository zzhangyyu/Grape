package com.yoler.grape.aop;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yoler.grape.dao.mapper.UserMapper;
import com.yoler.grape.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyu on 2019/3/21 14:28
 */
@Aspect
@Component
public class HidePatientInfo {

//    @Autowired
//    UserMapper userMapper;
//
//    @Pointcut("execution(public * com.yoler.grape.controller.*.*.*(..)), !execution(* com.cslc.playlot.app.extra.controller.TicketErrorController.ticketPicUpload(..))")
//    public void hidePatientInfo() {
//    }
//
//    @Before("hidePatientInfo()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        String openid = formatJson(joinPoint).get("phone").getAsString();
//        User user = userMapper.getUserByOpenid(openid);
//        if (user == null) {
//            throw new Exception("无权访问此系统");
//        }
//    }
//
//    private JsonObject formatJson(JoinPoint joinPoint) {
//        String reqStr = "{}";
//        Object[] objects = joinPoint.getArgs();
//        if (objects.length > 0) {
//            reqStr = (String) joinPoint.getArgs()[0];
//        }
//        JsonObject reqStrJO = new JsonParser().parse(reqStr).getAsJsonObject();
//        return reqStrJO;
//    }

}
