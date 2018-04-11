package com.yoler.grape.service.browser.user.impl;

import com.yoler.grape.service.browser.user.BrowserUserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("browserUserServiceImpl")
public class BrowserUserServiceImpl implements BrowserUserService {

    @Override
    public Map<String, Object> signIn(String userName, String password) {
        Map<String, Object> result = new HashMap<>();
        if (userName.equals("admin") && password.equals("admin")) {
            result.put("status", "200");
        } else {
            result.put("status", "500");
        }
        return result;
    }
}
