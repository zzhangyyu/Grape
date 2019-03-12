package com.yoler.grape.controller.browser;

import com.yoler.grape.util.DateFormatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by zhangyu on 2019/3/10 12:50
 */
@Controller("browserUserController")
@RequestMapping(value = "/console/")
public class UserController {

    @RequestMapping(value = "registerResult", method = RequestMethod.POST)
    public String registerResult(HttpServletRequest request) {
        String visitDate = request.getParameter("visitDate");
        String patientName = request.getParameter("patientName");
        String patientSex = request.getParameter("patientSex");
        String patientAge = request.getParameter("patientAge");
        String patientPhone = request.getParameter("patientPhone");
        String patientIntro = request.getParameter("patientIntro");
        String isFirst = request.getParameter("isFirst");
        System.out.println("----------------" + visitDate);
        System.out.println("----------------" + patientName);
        System.out.println("----------------" + patientSex);
        System.out.println("----------------" + patientAge);
        System.out.println("----------------" + patientPhone);
        System.out.println("----------------" + patientIntro);
        System.out.println("----------------" + isFirst);
        return "registerSuccess";
    }

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

}
