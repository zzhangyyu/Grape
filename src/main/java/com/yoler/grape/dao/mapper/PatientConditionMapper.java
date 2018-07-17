package com.yoler.grape.dao.mapper;

import com.yoler.grape.vo.browser.BrowserMounthDatasVo;
import com.yoler.grape.vo.browser.BrowserPatientBriefInfoVo;
import com.yoler.grape.vo.mobile.ConsiliaDateDirVo;
import com.yoler.grape.vo.mobile.ConsiliaDetailVo;
import com.yoler.grape.vo.mobile.ConsiliaNameDirVo;

import java.util.List;
import java.util.Map;

/**
 * mybatis-病历Mapper
 */
public interface PatientConditionMapper {
    List<ConsiliaDateDirVo> getConsiliaDateDir(Map<String, Object> queryMap);

    List<ConsiliaNameDirVo> getConsiliaNameDir(Map<String, Object> queryMap);

    ConsiliaDetailVo getConsiliaDetail(Map queryMap);

    List<BrowserPatientBriefInfoVo> getBrowserPatientBriefInfo(Map<String, Object> queryMap);
    
    List<BrowserMounthDatasVo> getBrowserMounthDatas(Map<String, Object> queryMap);
}
