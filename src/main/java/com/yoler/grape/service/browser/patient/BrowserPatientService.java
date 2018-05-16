package com.yoler.grape.service.browser.patient;


import com.yoler.grape.vo.browser.BrowserPatientBriefInfoVo;

import java.util.List;

public interface BrowserPatientService {

    void importPatientInfo();

    List<BrowserPatientBriefInfoVo> getBrowserPatientBriefInfo();
}
