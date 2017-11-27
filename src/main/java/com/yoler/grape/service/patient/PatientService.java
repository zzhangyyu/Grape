package com.yoler.grape.service.patient;

import com.yoler.grape.request.*;

import java.util.Map;

public interface PatientService {
    Map<String, Object> getConsiliaDateDir(ConsiliaDateDirReq req);

    Map<String, Object> getConsiliaDateIntro(ConsiliaDateIntroReq req);

    Map<String, Object> getConsiliaPatientDir(ConsiliaPatientDirReq req);

    Map<String, Object> getConsiliaPatientIntro(ConsiliaPatientIntroReq req);

    Map<String, Object> getConsiliaDetail(ConsiliaDetailReq req);
}
