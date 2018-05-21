package com.clubfactory.center.goods.config.dynamicdatasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 描述:
 *  仓库动态数据源
 * @author pangpeijie
 * @create 2018-05-21 18:58
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicIdooDataSourceContextHolder.getDataSourceKey();
    }
}
