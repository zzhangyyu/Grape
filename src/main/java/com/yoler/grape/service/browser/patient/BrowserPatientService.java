package com.yoler.grape.service.browser.patient;


import com.yoler.grape.request.browser.BrowserPatientBriefInfo;

import java.util.List;

public interface BrowserPatientService {

    void importPatientInfo();

    List<BrowserPatientBriefInfo> getBrowserPatientBriefInfo();
}
