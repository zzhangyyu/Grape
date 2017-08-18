package com.yoler.grape.service.patient.impl;

import com.yoler.grape.dao.mapper.PatientInfoMapper;
import com.yoler.grape.response.PI4PatientByDateResp;
import com.yoler.grape.service.patient.PatientInfoService;
import com.yoler.grape.vo.PatientByDateVo;
import com.yoler.grape.vo.PatientByNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("patientInfoServiceImpl")
public class PatientInfoServiceImpl implements PatientInfoService {
    @Autowired
    private PatientInfoMapper patientMapper;

    @Override
    public Map<String, Object> getPatientByDate() {
        Map<String, Object> result = new HashMap<>();
        Map<String, List<PI4PatientByDateResp>> groupMap = new HashMap<>();
        List<PatientByDateVo> patientByDateVos = patientMapper.getPatientByDate();
        for (PatientByDateVo patientByDateVo : patientByDateVos) {
            String key = patientByDateVo.getVisitingTime();
            List<PI4PatientByDateResp> pi4PatientByDateRespList = groupMap.get(key);
            if (pi4PatientByDateRespList == null) {
                pi4PatientByDateRespList = new ArrayList<>();
                groupMap.put(key, pi4PatientByDateRespList);
            }
            PI4PatientByDateResp pi4PatientByDateResp = new PI4PatientByDateResp();
            pi4PatientByDateResp.setPatientId(patientByDateVo.getPatientId());
            pi4PatientByDateResp.setPatientName(patientByDateVo.getPatientName());
            pi4PatientByDateRespList.add(pi4PatientByDateResp);
        }
        result.put("content", groupMap);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getPatientByName(String patientName) {
        Map<String, Object> result = new HashMap<>();
        List<PatientByNameVo> patientByDateVos = patientMapper.getPatientByName(patientName);
        return result;
    }
}
