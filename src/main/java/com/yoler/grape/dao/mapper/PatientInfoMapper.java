package com.yoler.grape.dao.mapper;

import com.yoler.grape.entity.PatientInfo;
import com.yoler.grape.vo.mobile.ConsiliaDateIntroVo;
import com.yoler.grape.vo.mobile.ConsiliaNameIntroVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * mybatis-病人基本信息Mapper
 */
public interface PatientInfoMapper extends BaseMapper<PatientInfo, Integer> {
    List<ConsiliaDateIntroVo> getConsiliaDateIntro(Map queryMap);

    List<ConsiliaNameIntroVo> getConsiliaNameIntro(Map queryMap);

    PatientInfo getPatientInfoByName(String patientName);
}
