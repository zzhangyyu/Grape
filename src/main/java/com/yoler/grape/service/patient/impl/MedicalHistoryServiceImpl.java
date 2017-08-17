package com.yoler.grape.service.patient.impl;

import com.yoler.grape.dao.mapper.PatientInfoMapper;
import com.yoler.grape.entity.PatientInfo;
import com.yoler.grape.service.patient.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("medicalHistoryService")
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    @Autowired
    private PatientInfoMapper patientMapper;

    @Override
    public List<PatientInfo> getPatientList() {
        return patientMapper.getPatientList();
    }
}
