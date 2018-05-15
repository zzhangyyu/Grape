package com.yoler.grape.service.browser.patient.impl;

import com.yoler.grape.request.browser.BrowserPatientBriefInfo;
import com.yoler.grape.service.browser.patient.BrowserPatientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("browserPatientServiceImpl")
public class BrowserPatientServiceImpl implements BrowserPatientService {
    @Override
    public void importPatientInfo() {

    }

    @Override
    public List<BrowserPatientBriefInfo> getBrowserPatientBriefInfo() {
        List<BrowserPatientBriefInfo> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BrowserPatientBriefInfo temp = new BrowserPatientBriefInfo();
            temp.setPatientName("1");
            temp.setPatientSex("男");
            temp.setPatientAge("22");
            result.add(temp);
        }
        return result;
    }
}
