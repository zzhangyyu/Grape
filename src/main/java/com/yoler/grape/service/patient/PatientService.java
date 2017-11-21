package com.yoler.grape.service.patient;

import com.yoler.grape.request.ConsiliaDateDirReq;
import com.yoler.grape.request.ConsiliaDateIntroReq;
import com.yoler.grape.request.ConsiliaDetailReq;

import java.util.Map;

public interface PatientService {
    Map<String, Object> getConsiliaDateDir(ConsiliaDateDirReq req);

    Map<String, Object> getConsiliaDateIntro(ConsiliaDateIntroReq req);

    Map<String, Object> getConsiliaPatientIntro(String patientName);

    Map<String, Object> getConsiliaDetail(ConsiliaDetailReq req);
}
