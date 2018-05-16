package com.yoler.grape.service.browser.patient.impl;

import com.yoler.grape.dao.mapper.PatientConditionMapper;
import com.yoler.grape.service.browser.patient.BrowserPatientService;
import com.yoler.grape.vo.browser.BrowserPatientBriefInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("browserPatientServiceImpl")
public class BrowserPatientServiceImpl implements BrowserPatientService {

    @Autowired
    PatientConditionMapper patientConditionMapper;

    @Override
    public void importPatientInfo() {

    }

    @Override
    public List<BrowserPatientBriefInfoVo> getBrowserPatientBriefInfo() {
        List<BrowserPatientBriefInfoVo> result = new ArrayList<>();
        Map<String, Object> queryMap = new HashMap<>();
        result = patientConditionMapper.getBrowserPatientBriefInfo(queryMap);
        return result;
    }
}
