package com.yoler.grape.service.mobile.patient.impl;

import com.yoler.grape.dao.mapper.PatientConditionMapper;
import com.yoler.grape.dao.mapper.PatientInfoMapper;
import com.yoler.grape.request.mobile.*;
import com.yoler.grape.service.mobile.patient.PatientService;
import com.yoler.grape.vo.mobile.*;
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
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("queryDate", req.getContent().getQueryDate());
        List<ConsiliaDateIntroVo> consiliaDateIntroVos = patientInfoMapper.getConsiliaDateIntro(queryMap);
        result.put("content", consiliaDateIntroVos);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getConsiliaNameDir(ConsiliaNameDirReq req) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("pageIdx", req.getContent().getPageIdx());
        queryMap.put("recordPerPage", req.getContent().getRecordPerPage());
        queryMap.put("patientNameLike", req.getContent().getPatientNameLike());
        List<ConsiliaNameDirVo> consiliaNameDirVos = patientConditionMapper.getConsiliaNameDir(queryMap);
        result.put("content", consiliaNameDirVos);
        result.put("status", "200");
        return result;
    }

    @Override
    public Map<String, Object> getConsiliaNameIntro(ConsiliaNameIntroReq req) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("patientInfoId", req.getContent().getPatientInfoId());
        List<ConsiliaNameIntroVo> consiliaNameIntroVos = patientInfoMapper.getConsiliaNameIntro(queryMap);
        result.put("content", consiliaNameIntroVos);
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
