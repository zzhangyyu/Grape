package com.yoler.grape.service.user;

import com.yoler.grape.request.SignInReq;
import com.yoler.grape.request.SignUpReq;
import com.yoler.grape.request.UserFavouritePatientReq;

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
