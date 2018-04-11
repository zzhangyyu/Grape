package com.yoler.grape.service.browser.user;

import java.util.Map;

public interface BrowserUserService {

    /**
     * Browser用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    Map<String, Object> signIn(String userName, String password);
}
