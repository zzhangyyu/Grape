package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.PatientConditionVo;

import java.util.Map;

/**
 * mybatis-病历Mapper
 */
public interface PatientConditionMapper {
    PatientConditionVo getPatientCondition(Map queryMap);
}
