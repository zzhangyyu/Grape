package com.yoler.grape.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhangyu on 2017/6/28.
 */
@Controller
public class Medical {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "getMedicalHistory", method = RequestMethod.POST)
    public String getMedicalHistory() {
        return "login";
    }
}
