package com.yoler.grape.dao.mapper;

import com.yoler.grape.entity.PatientCondition;
import com.yoler.grape.vo.browser.BrowserMounthDatasVo;
import com.yoler.grape.vo.browser.BrowserPatientBriefInfoVo;
import com.yoler.grape.vo.mobile.ConsiliaDateDirVo;
import com.yoler.grape.vo.mobile.ConsiliaDetailVo;
import com.yoler.grape.vo.mobile.ConsiliaNameDirVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * mybatis-病历Mapper
 */
@Mapper
public interface PatientConditionMapper extends BaseMapper<PatientCondition, Integer> {
    List<ConsiliaDateDirVo> getConsiliaDateDir(Map<String, Object> queryMap);

    List<ConsiliaNameDirVo> getConsiliaNameDir(Map<String, Object> queryMap);

    ConsiliaDetailVo getConsiliaDetail(Map queryMap);

    List<BrowserPatientBriefInfoVo> getBrowserPatientBriefInfo(Map<String, Object> queryMap);

    List<BrowserMounthDatasVo> getBrowserMounthDatas(Map<String, Object> queryMap);
}
