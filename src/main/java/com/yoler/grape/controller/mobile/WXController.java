package com.yoler.grape.controller.mobile;

import com.yoler.grape.service.mobile.user.WXService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *微信controller
 */
@RestController
@RequestMapping(value = "/wx/")
public class WXController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WXService wxService;

    @RequestMapping(value = "code2Session", method = RequestMethod.POST)
    public String code2Session(@RequestBody String jsCode) {
        logger.debug("code2Session req is :" + jsCode);
        String result = wxService.code2Session(jsCode);
        logger.debug("code2Session resp is :" + result);
        return result;
    }
}
