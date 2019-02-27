package com.yoler.grape.service.mobile.user.impl;

import com.yoler.grape.dao.mapper.UserFavouriteMapper;
import com.yoler.grape.dao.mapper.UserMapper;
import com.yoler.grape.entity.User;
import com.yoler.grape.request.mobile.SignInReq;
import com.yoler.grape.request.mobile.SignUpReq;
import com.yoler.grape.request.mobile.UserFavouritePatientReq;
import com.yoler.grape.service.mobile.user.MobileUserService;
import com.yoler.grape.util.RegexUtils;
import com.yoler.grape.vo.mobile.UserFavouritePatientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("mobileUserServiceImpl")
public class MobileUserServiceImpl implements MobileUserService {

    @Autowired
    UserFavouriteMapper userFavouriteMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> signUp(SignUpReq req) {
        Map<String, Object> result = new HashMap<>();
        String avatarUrl = req.getContent().getAvatarUrl();
        String wxOpenid = req.getContent().getWxOpenId();
        String nickName = req.getContent().getNickName();
        User user = new User();
        user.setAvatar(avatarUrl);
        user.setWxOpenid(wxOpenid);
        user.setUserName(nickName);
        user.setCreateTime(new Date());
        User existUser = userMapper.getUserByOpenid(wxOpenid);
        if (existUser == null) {
            userMapper.insert(user);
        } else {
            if (!avatarUrl.equals(existUser.getAvatar()) || !nickName.equals(existUser.getUserName())) {
                userMapper.updateUserByOpenid(user);
            }
        }
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> signIn(SignInReq req) {
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
        } else if (isUserValid(inputUserName, inputPassword)) {
            content.put("msg", "登录成功");
            result.put("content", content);
            result.put("status", "200");
        }
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
        User user = userMapper.getUserByName(queryMap);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断用户是否合法
     *
     * @param inputUserName
     * @param inputPassword
     * @return
     */
    private boolean isUserValid(String inputUserName, String inputPassword) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("userName", inputUserName);
        User user = userMapper.getUserByName(queryMap);
        if (user == null) {
            return false;
        }
        if (inputUserName.equals(user.getUserName()) && inputPassword.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

}
