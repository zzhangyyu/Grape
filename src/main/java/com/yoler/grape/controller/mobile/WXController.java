package com.yoler.grape.controller.mobile;

import com.yoler.grape.service.mobile.user.WXService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信controller
 */
@Api(tags = "WX", description = "微信相关接口")
@RestController
@RequestMapping(value = "/wx/")
public class WXController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WXService wxService;

    @ApiOperation(value = "微信登录凭证校验", notes = "微信登录凭证校验")
    @ApiImplicitParam(name = "jsCode", value = "微信用户登录凭证", dataType = "String", required = true)
    @PostMapping(value = "code2Session")
    public String code2Session(@RequestBody String jsCode) {
        logger.debug("code2Session req is :" + jsCode);
        String result = wxService.code2Session(jsCode);
        logger.debug("code2Session resp is :" + result);
        return result;
    }
}
