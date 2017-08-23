package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.PatientByDateVo;
import com.yoler.grape.vo.PatientByNameVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis-病人基本信息Mapper
 */
public interface PatientInfoMapper {
    List<PatientByDateVo> getPatientByDate(Map queryMap);

    List<PatientByNameVo> getPatientByName(String patientName);
}
