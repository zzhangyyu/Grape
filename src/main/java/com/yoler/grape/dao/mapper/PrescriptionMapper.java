package com.yoler.grape.dao.mapper;

import com.yoler.grape.entity.Prescription;
import org.apache.ibatis.annotations.Mapper;

/**
 * mybatis-药方Mapper
 */
@Mapper
public interface PrescriptionMapper extends BaseMapper<Prescription, Integer> {

}
