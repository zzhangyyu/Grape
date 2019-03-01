package com.yoler.grape.dao.mapper;

import java.io.Serializable;

/**
 * zhangyu
 *
 * @param <E>  数据库实体entity
 * @param <PK> 主键
 */
public interface BaseMapper<E, PK extends Serializable> {

    int insert(E entity);

    int update(E entity);

    int delete(PK pk);

    E get(PK pk);

}
