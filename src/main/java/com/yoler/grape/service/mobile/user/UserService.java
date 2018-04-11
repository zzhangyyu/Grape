package com.yoler.grape.service.mobile.user;

import com.yoler.grape.request.mobile.SignInReq;
import com.yoler.grape.request.mobile.SignUpReq;
import com.yoler.grape.request.mobile.UserFavouritePatientReq;

import java.util.Map;

public interface UserService {
    /**
     * 注册
     *
     * @param req
     * @return
     */
    Map<String, Object> signUp(SignUpReq req);

    /**
     * 登录
     *
     * @param req
     * @return
     */
    Map<String, Object> signIn(SignInReq req);

    /**
     * 获取用户收藏病历
     *
     * @param req
     * @return
     */
    Map<String, Object> getUserFavouritePatient(UserFavouritePatientReq req);

}
