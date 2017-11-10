package com.yoler.grape.service.patient.impl;

import com.yoler.grape.dao.mapper.PatientConditionMapper;
import com.yoler.grape.dao.mapper.PatientInfoMapper;
import com.yoler.grape.request.DateDirReq;
import com.yoler.grape.request.PatientByDateReq;
import com.yoler.grape.response.PI4PatientByDateResp;
import com.yoler.grape.service.patient.PatientService;
import com.yoler.grape.vo.DateDirVo;
import com.yoler.grape.vo.PatientByDateVo;
import com.yoler.grape.vo.PatientByNameVo;
import com.yoler.grape.vo.PatientConditionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("patientServiceImpl")
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientInfoMapper patientInfoMapper;
    @Autowired
    private PatientConditionMapper patientConditionMapper;

    @Override
    public Map<String, Object> getDateDir(DateDirReq req) {
        Map<String, Object> result = new HashMap<>();
        List<DateDirVo> dateDirVos = patientConditionMapper.getDateDir();
        result.put("content", dateDirVos);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getPatientByDate(PatientByDateReq req) {
        Map<String, Object> result = new HashMap<>();
        Map<String, List<PI4PatientByDateResp>> groupMap = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("queryStartDate", req.getQueryStartDate());
        queryMap.put("queryEndDate", req.getQueryEndDate());
        List<PatientByDateVo> patientByDateVos = patientInfoMapper.getPatientByDate(queryMap);
        for (PatientByDateVo patientByDateVo : patientByDateVos) {
            String key = patientByDateVo.getVisitingDate();
            List<PI4PatientByDateResp> pi4PatientByDateRespList = groupMap.get(key);
            if (pi4PatientByDateRespList == null) {
                pi4PatientByDateRespList = new ArrayList<>();
                groupMap.put(key, pi4PatientByDateRespList);
            }
            PI4PatientByDateResp pi4PatientByDateResp = new PI4PatientByDateResp();
            pi4PatientByDateResp.setPatientInfoId(patientByDateVo.getPatientInfoId());
            pi4PatientByDateResp.setPatientConditionId(patientByDateVo.getPatientConditionId());
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
        List<PatientByNameVo> patientByDateVos = patientInfoMapper.getPatientByName(patientName);
        return result;
    }

    @Override
    public Map<String, Object> getPatientCondition() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("patientConditionId", "1");
        PatientConditionVo patientConditionVo = patientConditionMapper.getPatientCondition(queryMap);
        result.put("content", patientConditionVo);
        result.put("status", "200");
        return result;
    }
}
