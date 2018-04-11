package com.yoler.grape.controller.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/console/")
public class HomeController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private String loginPage = "modules/loginPage.jsp";
    private String homePage = "modules/homePage.jsp";

    @RequestMapping(value = "loginPage", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return loginPage;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String userName, @RequestParam String password, Model model, HttpServletRequest request) {
        String result = "232323";
        if (result != null) {
            request.getSession().setAttribute("resoList", "");
            request.getSession().setAttribute("name", userName);
            request.getSession().setAttribute("loginUser", result);
            request.getSession().setAttribute("province", "");
            return homePage;
        } else {
            model.addAttribute("userName", userName);
            model.addAttribute("password", password);
            model.addAttribute("errorMsg", "用户名或者密码错误,请重新输入");
            return "../../index.jsp";
        }
    }
}
