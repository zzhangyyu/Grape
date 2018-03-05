package com.yoler.grape.service.user.impl;

import com.yoler.grape.dao.mapper.UserFavouriteMapper;
import com.yoler.grape.dao.mapper.UserMapper;
import com.yoler.grape.entity.User;
import com.yoler.grape.request.SignInReq;
import com.yoler.grape.request.SignUpReq;
import com.yoler.grape.request.UserFavouritePatientReq;
import com.yoler.grape.service.user.UserService;
import com.yoler.grape.util.RegexUtils;
import com.yoler.grape.vo.UserFavouritePatientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    UserFavouriteMapper userFavouriteMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> signUp(SignUpReq req) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> content = new HashMap<>();
        String inputUserName = req.getContent().getUserName();
        String inputPassword = req.getContent().getPassword();
        if (!RegexUtils.checkEngNum_(inputUserName)) {
            content.put("msg", "用户名不合规");
            result.put("content", content);
            result.put("status", "501");
        } else if (!RegexUtils.checkEngNum_(inputPassword)) {
            content.put("msg", "密码不合规");
            result.put("content", content);
            result.put("status", "502");
        } else if (isUserNameExist(inputUserName)) {
            content.put("msg", "已存在的用户名");
            result.put("content", content);
            result.put("status", "503");
        } else {
            User user = new User();
            user.setUserName(inputUserName);
            user.setPassword(inputPassword);
            user.setCreateTime(new Date());
            userMapper.insert(user);
            content.put("userId", user.getId() + "");
            result.put("status", "200");
        }
        return result;
    }

    @Override
    public Map<String, Object> signIn(SignInReq req) {
        Map<String, Object> result = new HashMap<>();
        return result;
    }

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

    /**
     * 判断用户名是否已经存在
     *
     * @param userName
     * @return
     */
    private boolean isUserNameExist(String userName) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userName", userName);
        int userNameCnt = userMapper.getUserNameCnt(queryMap);
        if (userNameCnt == 0) {
            return false;
        } else {
            return true;
        }
    }
}
