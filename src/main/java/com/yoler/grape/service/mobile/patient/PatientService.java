package com.yoler.grape.service.mobile.patient;

import com.yoler.grape.request.mobile.*;

import java.util.Map;

public interface PatientService {
    Map<String, Object> getConsiliaDateDir(ConsiliaDateDirReq req);

    Map<String, Object> getConsiliaDateIntro(ConsiliaDateIntroReq req);

    Map<String, Object> getConsiliaNameDir(ConsiliaNameDirReq req);

    Map<String, Object> getConsiliaNameIntro(ConsiliaNameIntroReq req);

    Map<String, Object> getConsiliaDetail(ConsiliaDetailReq req);
}
