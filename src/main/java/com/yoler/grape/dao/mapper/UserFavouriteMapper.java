package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.UserFavouritePatientVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis-用户收藏Mapper
 */
public interface UserFavouriteMapper {

    List<UserFavouritePatientVo> getUserFavouritePatient(Map queryMap);

}
