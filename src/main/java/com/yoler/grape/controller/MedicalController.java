package com.yoler.grape.controller;

import com.yoler.grape.entity.PatientInfo;
import com.yoler.grape.service.patient.MedicalHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhangyu on 2017/6/28.
 */
@Controller
@RequestMapping(value = "/")
public class MedicalController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MedicalHistoryService medicalHistoryService;

    @RequestMapping(value = "getMedicalHistory", method = RequestMethod.POST)
    public @ResponseBody
    String getMedicalHistory() {
        List<PatientInfo> patients = medicalHistoryService.getPatientList();
        return patients.toString();
    }
}