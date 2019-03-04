package com.yoler.grape.dao.mapper;

import com.yoler.grape.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * mybatis-用户Mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User, Integer> {

    User getUserByName(Map queryMap);

    User getUserByOpenid(String openid);

    void updateUserByOpenid(User user);

}
