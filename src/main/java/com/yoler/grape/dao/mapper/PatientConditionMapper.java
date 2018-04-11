package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.mobile.ConsiliaDateDirVo;
import com.yoler.grape.vo.mobile.ConsiliaDetailVo;
import com.yoler.grape.vo.mobile.ConsiliaPatientDirVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis-病历Mapper
 */
public interface PatientConditionMapper {
    List<ConsiliaDateDirVo> getConsiliaDateDir(Map<String, Object> queryMap);

    List<ConsiliaPatientDirVo> getConsiliaPatientDir(Map<String, Object> queryMap);

    ConsiliaDetailVo getConsiliaDetail(Map queryMap);
}
