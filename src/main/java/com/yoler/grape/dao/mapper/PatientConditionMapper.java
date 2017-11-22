package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.ConsiliaDateDirVo;
import com.yoler.grape.vo.ConsiliaDetailVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis-病历Mapper
 */
public interface PatientConditionMapper {
    List<ConsiliaDateDirVo> getConsiliaDateDir(Map<String, Object> queryMap);

    ConsiliaDetailVo getConsiliaDetail(Map queryMap);
}
