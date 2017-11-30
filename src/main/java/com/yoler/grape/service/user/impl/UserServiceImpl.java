package com.yoler.grape.service.user.impl;

import com.yoler.grape.dao.mapper.UserFavouriteMapper;
import com.yoler.grape.request.UserFavouritePatientReq;
import com.yoler.grape.service.user.UserService;
import com.yoler.grape.vo.UserFavouritePatientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserFavouriteMapper userFavouriteMapper;

    @Override
    public Map<String, Object> getUserFavouritePatient(UserFavouritePatientReq req) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userId", req.getContent().getUserId());
        List<UserFavouritePatientVo> userFavouritePatientVos = userFavouriteMapper.getUserFavouritePatient(queryMap);
        result.put("content", userFavouritePatientVos);
        result.put("status", "200");
        return result;
    }
}
