package com.yoler.grape.service.patient;

import java.util.Map;

public interface PatientInfoService {
    Map<String, Object> getPatientByDate();

    Map<String, Object> getPatientByName(String patientName);
}
