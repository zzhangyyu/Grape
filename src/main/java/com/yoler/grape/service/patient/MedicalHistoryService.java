package com.yoler.grape.service.patient;

import com.yoler.grape.entity.PatientInfo;

import java.util.List;

public interface MedicalHistoryService {
    List<PatientInfo> getPatientList();
}
