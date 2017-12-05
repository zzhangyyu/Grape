package com.yoler.grape.service.user;

import com.yoler.grape.request.SignInReq;
import com.yoler.grape.request.SignUpReq;
import com.yoler.grape.request.UserFavouritePatientReq;

import java.util.Map;

public interface UserService {
    Map<String, Object> signUp(SignUpReq req);

    Map<String, Object> signIn(SignInReq req);

    Map<String, Object> getUserFavouritePatient(UserFavouritePatientReq req);

}
