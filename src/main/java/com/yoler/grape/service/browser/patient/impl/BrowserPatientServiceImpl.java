package com.yoler.grape.service.browser.patient.impl;

import com.yoler.grape.dao.mapper.PatientConditionMapper;
import com.yoler.grape.service.browser.patient.BrowserPatientService;
import com.yoler.grape.vo.browser.BrowserPatientBriefInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("browserPatientServiceImpl")
public class BrowserPatientServiceImpl implements BrowserPatientService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    PatientConditionMapper patientConditionMapper;

    @Override
    public void importPatientInfo() {

    }

    @Override
    public List<BrowserPatientBriefInfoVo> getBrowserPatientBriefInfo(int pageIdx, int recordPerPage) {
        List<BrowserPatientBriefInfoVo> result = new ArrayList<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("offset", (pageIdx - 1) * recordPerPage);
        queryMap.put("recordPerPage", recordPerPage);
        try {
            result = patientConditionMapper.getBrowserPatientBriefInfo(queryMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}
