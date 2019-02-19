package com.yoler.grape.service.mobile.user.impl;

import cn.hutool.http.HttpUtil;
import com.yoler.grape.service.mobile.user.WXService;
import org.springframework.stereotype.Service;

@Service("wxServiceImpl")
public class WXServiceImpl implements WXService {

    private String appid = "wx5fab2978a483ec56";
    private String secret = "61055d69ed89071e3511730c2ace8531";

    @Override
    public String code2Session(String jsCode) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=authorization_code";
        String result = HttpUtil.get(url);
        return result;
    }
}
