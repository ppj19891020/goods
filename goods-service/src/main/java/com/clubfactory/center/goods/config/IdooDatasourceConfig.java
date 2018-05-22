package com.clubfactory.center.goods.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.clubfactory.center.goods.config.dynamicdatasource.IdooDataSourceKey;
import com.clubfactory.center.goods.config.dynamicdatasource.DynamicIdooDataSourceContextHolder;
import com.clubfactory.center.goods.config.dynamicdatasource.DynamicRoutingDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *  余杭仓库数据库
 * @author pangpeijie
 * @create 2018-05-21 15:49
 */
@Configuration
@MapperScan(basePackages = "com.clubfactory.center.goods.dao.idoo",
        sqlSessionFactoryRef = "idooSqlSessionFactory")
public class IdooDatasourceConfig {
    /**
     * 余杭仓库数据源
     * @return
     */
    @Primary
    @Bean(name = "idooDataSource")
    @ConfigurationProperties("spring.datasource.idoo")
    public DataSource idooDataSource(){
        return new DruidDataSource();
    }


    /**
     * 萧山数据源
     * @return
     */
    @Bean(name = "idooXsDataSource")
    @ConfigurationProperties("spring.datasource.idooxs")
    public DataSource idooXsDataSource(){
        return new DruidDataSource();
    }

    /**
     * 心怡数据源
     * @return
     */
    @Bean(name = "idooHnDataSource")
    @ConfigurationProperties("spring.datasource.idoohn")
    public DataSource idooHnDataSource(){
        return new DruidDataSource();
    }

    /**
     * 动态数据源
     * @return
     */
    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(4);
        dataSourceMap.put(IdooDataSourceKey.YUHANG.getCode(), idooDataSource());
        dataSourceMap.put(IdooDataSourceKey.XIAOSHAN.getCode(), idooXsDataSource());
        dataSourceMap.put(IdooDataSourceKey.XINYI.getCode(), idooHnDataSource());
        // 默认指定的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(idooDataSource());
        // 指定的数据源
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        // 将数据源的 key 放到数据源上下文的 key 集合中，用于切换时判断数据源是否有效
        DynamicIdooDataSourceContextHolder.dataSourceKeys.addAll(dataSourceMap.keySet());
        return dynamicRoutingDataSource;
    }

    /**
     * 配置sqlsessionfactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Primary
    @Bean(name = "idooSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("idooDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dynamicDataSource());
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:com/clubfactory/mapper/idoo/*.xml"));
        return sessionFactoryBean.getObject();
    }

    /**
     * 配置事物管理器
     * @return
     */
    @Primary
    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("idooDataSource") DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dynamicDataSource());
        return dataSourceTransactionManager;
    }

}
