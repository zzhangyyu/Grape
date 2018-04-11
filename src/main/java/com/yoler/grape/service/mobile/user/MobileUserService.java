package com.yoler.grape.service.mobile.user;

import com.yoler.grape.request.mobile.SignInReq;
import com.yoler.grape.request.mobile.SignUpReq;
import com.yoler.grape.request.mobile.UserFavouritePatientReq;

import java.util.Map;

public interface MobileUserService {
    /**
     * mobile用户注册
     *
     * @param req
     * @return
     */
    Map<String, Object> signUp(SignUpReq req);

    /**
     * mobile用户登录
     *
     * @param req
     * @return
     */
    Map<String, Object> signIn(SignInReq req);

    /**
     * 获取mobile用户收藏病历
     *
     * @param req
     * @return
     */
    Map<String, Object> getUserFavouritePatient(UserFavouritePatientReq req);

}
