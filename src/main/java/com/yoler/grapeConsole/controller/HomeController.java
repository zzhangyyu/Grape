package com.yoler.grapeConsole.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/console/")
public class HomeController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private String homePage = "modules/home.html";

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model) {
        return homePage;
    }
}
