package com.clubfactory.core.base;

import java.util.List;

/**
 * 描述:
 *  基础DAO
 * @author pangpeijie
 * @create 2018-05-18 18:14
 */
public interface BaseDao<T> {
    T selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int insertSelective(T t);

    int updateByPrimaryKeySelective(T t);

    List<T> getList(T t);

}
