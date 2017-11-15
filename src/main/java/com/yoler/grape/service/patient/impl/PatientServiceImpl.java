package com.yoler.grape.service.patient.impl;

import com.yoler.grape.dao.mapper.PatientConditionMapper;
import com.yoler.grape.dao.mapper.PatientInfoMapper;
import com.yoler.grape.request.ConsiliaDateDirReq;
import com.yoler.grape.request.ConsiliaDateIntroReq;
import com.yoler.grape.response.ConsiliaDateIntroPI;
import com.yoler.grape.response.ConsiliaDateIntroResp;
import com.yoler.grape.service.patient.PatientService;
import com.yoler.grape.vo.ConsiliaDateDirVo;
import com.yoler.grape.vo.ConsiliaDateIntroVo;
import com.yoler.grape.vo.ConsiliaPatientIntroVo;
import com.yoler.grape.vo.PatientConditionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("patientServiceImpl")
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientInfoMapper patientInfoMapper;
    @Autowired
    private PatientConditionMapper patientConditionMapper;

    @Override
    public Map<String, Object> getConsiliaDateDir(ConsiliaDateDirReq req) {
        Map<String, Object> result = new HashMap<>();
        List<ConsiliaDateDirVo> consiliaDateDirVos = patientConditionMapper.getConsiliaDateDir();
        result.put("content", consiliaDateDirVos);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getConsiliaDateIntro(ConsiliaDateIntroReq req) {
        Map<String, Object> result = new HashMap<>();
        List<ConsiliaDateIntroResp> content = new ArrayList<>();
        Map<String, List<ConsiliaDateIntroPI>> groupMap = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("queryStartDate", req.getQueryStartDate());
        queryMap.put("queryEndDate", req.getQueryEndDate());
        List<ConsiliaDateIntroVo> consiliaDateIntroVos = patientInfoMapper.getConsiliaDateIntro(queryMap);
        for (ConsiliaDateIntroVo consiliaDateIntroVo : consiliaDateIntroVos) {
            String key = consiliaDateIntroVo.getVisitingDate();
            List<ConsiliaDateIntroPI> ConsiliaDateIntroPIs = groupMap.get(key);
            if (ConsiliaDateIntroPIs == null) {
                ConsiliaDateIntroPIs = new ArrayList<>();
                groupMap.put(key, ConsiliaDateIntroPIs);
            }
            ConsiliaDateIntroPI consiliaDateIntroPI = new ConsiliaDateIntroPI();
            consiliaDateIntroPI.setPatientInfoId(consiliaDateIntroVo.getPatientInfoId());
            consiliaDateIntroPI.setPatientConditionId(consiliaDateIntroVo.getPatientConditionId());
            consiliaDateIntroPI.setPatientName(consiliaDateIntroVo.getPatientName());
            ConsiliaDateIntroPIs.add(consiliaDateIntroPI);
        }

        Set<String> keys = groupMap.keySet();
        for (String key : keys) {
            ConsiliaDateIntroResp consiliaDateIntroResp = new ConsiliaDateIntroResp();
            consiliaDateIntroResp.setVisitingTime(key);
            consiliaDateIntroResp.setPatientInfos(groupMap.get(key));
            content.add(consiliaDateIntroResp);
        }
        result.put("content", content);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getConsiliaPatientIntro(String patientName) {
        Map<String, Object> result = new HashMap<>();
        List<ConsiliaPatientIntroVo> consiliaPatientIntroVos = patientInfoMapper.getConsiliaPatientIntro(patientName);
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
