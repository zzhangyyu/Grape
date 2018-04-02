package com.yoler.grape.dao.mapper;

import com.yoler.grape.entity.User;

import java.util.Map;

/**
 * mybatis-用户Mapper
 */
public interface UserMapper extends BaseMapper<User, Integer> {

    User getUserByName(Map queryMap);

}
