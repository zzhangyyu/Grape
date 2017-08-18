package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.PatientByDateVo;
import com.yoler.grape.vo.PatientByNameVo;

import java.util.List;

/**
 * mybatis-病人基本信息
 */
public interface PatientInfoMapper {
    List<PatientByDateVo> getPatientByDate();

    List<PatientByNameVo> getPatientByName(String patientName);
}
