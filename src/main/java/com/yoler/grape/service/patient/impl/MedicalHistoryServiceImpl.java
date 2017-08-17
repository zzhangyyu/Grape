package com.yoler.grape.service.patient.impl;

import com.yoler.grape.dao.mapper.PatientMapper;
import com.yoler.grape.entity.Patient;
import com.yoler.grape.service.patient.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("medicalHistoryService")
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public List<Patient> getPatientList() {
        return patientMapper.getPatientList();
    }
}
