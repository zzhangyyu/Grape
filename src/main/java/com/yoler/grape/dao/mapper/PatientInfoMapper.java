package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.mobile.ConsiliaDateIntroVo;
import com.yoler.grape.vo.mobile.ConsiliaNameIntroVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis-病人基本信息Mapper
 */
public interface PatientInfoMapper {
    List<ConsiliaDateIntroVo> getConsiliaDateIntro(Map queryMap);

    List<ConsiliaNameIntroVo> getConsiliaNameIntro(Map queryMap);
}
