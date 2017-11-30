package com.yoler.grape.service.user;

import com.yoler.grape.request.UserFavouritePatientReq;

import java.util.Map;

public interface UserService {
    Map<String, Object> getUserFavouritePatient(UserFavouritePatientReq req);

}
