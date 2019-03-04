package com.yoler.grape.service.browser.patient;

import com.yoler.grape.vo.browser.BrowserPatientBriefInfoVo;

import java.util.List;
import java.util.Map;

public interface PatientService {

    void saveToImportConsilia(List<List<String>> toImportDatas);

    List<BrowserPatientBriefInfoVo> getBrowserPatientBriefInfo(int pageIdx, int recordPerPage);

    Map<String, Object> getBrowserMounthDatas();
}
