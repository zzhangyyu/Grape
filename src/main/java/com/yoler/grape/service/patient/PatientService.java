package com.yoler.grape.service.patient;

import com.yoler.grape.request.DateDirReq;
import com.yoler.grape.request.PatientByDateReq;

import java.util.Map;

public interface PatientService {
    Map<String, Object> getDateDir(DateDirReq req);

    Map<String, Object> getPatientByDate(PatientByDateReq req);

    Map<String, Object> getPatientByName(String patientName);

    Map<String, Object> getPatientCondition();
}
