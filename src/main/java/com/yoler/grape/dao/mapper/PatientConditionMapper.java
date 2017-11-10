package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.DateDirVo;
import com.yoler.grape.vo.PatientConditionVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis-病历Mapper
 */
public interface PatientConditionMapper {
    List<DateDirVo> getDateDir();

    PatientConditionVo getPatientCondition(Map queryMap);
}
