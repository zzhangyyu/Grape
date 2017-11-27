package com.yoler.grape.service.patient.impl;

import com.yoler.grape.dao.mapper.PatientConditionMapper;
import com.yoler.grape.dao.mapper.PatientInfoMapper;
import com.yoler.grape.request.*;
import com.yoler.grape.response.ConsiliaDateIntroPI;
import com.yoler.grape.response.ConsiliaDateIntroResp;
import com.yoler.grape.service.patient.PatientService;
import com.yoler.grape.vo.*;
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
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("queryStartDate", req.getContent().getQueryStartDate());
        queryMap.put("queryEndDate", req.getContent().getQueryEndDate());
        List<ConsiliaDateDirVo> consiliaDateDirVos = patientConditionMapper.getConsiliaDateDir(queryMap);
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
        queryMap.put("queryStartDate", req.getContent().getQueryStartDate());
        queryMap.put("queryEndDate", req.getContent().getQueryEndDate());
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
            consiliaDateIntroPI.setPatientSex(consiliaDateIntroVo.getPatientSex());
            ConsiliaDateIntroPIs.add(consiliaDateIntroPI);
        }

        Set<String> keys = groupMap.keySet();
        for (String key : keys) {
            ConsiliaDateIntroResp consiliaDateIntroResp = new ConsiliaDateIntroResp();
            consiliaDateIntroResp.setVisitingDate(key);
            consiliaDateIntroResp.setPatientInfos(groupMap.get(key));
            content.add(consiliaDateIntroResp);
        }
        result.put("content", content);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getConsiliaPatientDir(ConsiliaPatientDirReq req) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        List<ConsiliaPatientDirVo> consiliaPatientDirVos = patientConditionMapper.getConsiliaPatientDir(queryMap);
        result.put("content", consiliaPatientDirVos);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getConsiliaPatientIntro(ConsiliaPatientIntroReq req) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("patientInfoId", req.getContent().getPatientInfoId());
        List<ConsiliaPatientIntroVo> consiliaPatientIntroVos = patientInfoMapper.getConsiliaPatientIntro(queryMap);
        result.put("content", consiliaPatientIntroVos);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getConsiliaDetail(ConsiliaDetailReq req) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("patientConditionId", req.getContent().getPatientConditionId());
        ConsiliaDetailVo consiliaDetailVo = patientConditionMapper.getConsiliaDetail(queryMap);
        result.put("content", consiliaDetailVo);
        result.put("status", "200");
        return result;
    }
}
