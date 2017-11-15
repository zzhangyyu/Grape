package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.ConsiliaDateDirVo;
import com.yoler.grape.vo.PatientConditionVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis-病历Mapper
 */
public interface PatientConditionMapper {
    List<ConsiliaDateDirVo> getConsiliaDateDir();

    PatientConditionVo getPatientCondition(Map queryMap);
}
