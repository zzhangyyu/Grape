package com.yoler.grape.controller.browser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangyu on 2019/3/10 12:50
 */
@Controller("browserUserController")
@RequestMapping(value = "/console/")
public class UserController {

    @RequestMapping(value = "registerResult", method = RequestMethod.POST)
    public String registerResult(HttpServletRequest request) {
        String patientName = request.getParameter("patientName");
        String patientSex = request.getParameter("patientSex");
        String patientAge = request.getParameter("patientAge");
        String patientPhone = request.getParameter("patientPhone");
        String patientWeiXin = request.getParameter("patientWeiXin");
        String isFirst = request.getParameter("isFirst");
        System.out.println("----------------" + patientName);
        System.out.println("----------------" + patientSex);
        System.out.println("----------------" + patientAge);
        System.out.println("----------------" + patientPhone);
        System.out.println("----------------" + patientWeiXin);
        System.out.println("----------------" + isFirst);
        return "registerSuccess";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

}
