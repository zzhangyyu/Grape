package com.yoler.grape.dao.mapper;

import com.yoler.grape.entity.RegisterGuJingbo;
import com.yoler.grape.vo.browser.BrowserIntentionDateAndWeekVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * mybatis-谷大夫挂号Mapper
 */
@Mapper
public interface RegisterGuJingboMapper extends BaseMapper<RegisterGuJingbo, Integer> {

    List<BrowserIntentionDateAndWeekVo> getIntentionDateAndWeek();

    List<RegisterGuJingbo> getRegisterDetail(Date date);

}
