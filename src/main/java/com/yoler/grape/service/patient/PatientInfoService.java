package com.yoler.grape.service.patient;

import com.yoler.grape.request.PatientByDateReq;

import java.util.Map;

public interface PatientInfoService {
    Map<String, Object> getPatientByDate(PatientByDateReq req);

    Map<String, Object> getPatientByName(String patientName);

    Map<String, Object> getPatientCondition();
}
