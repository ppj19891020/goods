package com.clubfactory.center.goods.config;

import com.alibaba.druid.pool.DruidDataSource;
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

/**
 * 描述:
 *  仓库数据库
 * @author pangpeijie
 * @create 2018-05-21 15:49
 */
@Configuration
@MapperScan(basePackages = "com.clubfactory.center.goods.dao.idoo",
        sqlSessionFactoryRef = "idooSqlSessionFactory")
public class IdooDatasourceConfig {
    /**
     * 配置数据源
     * @return
     */
    @Primary
    @Bean(name = "idooDataSource")
    @ConfigurationProperties("spring.datasource.idoo")
    public DataSource idooDataSource(){
        return new DruidDataSource();
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
        sessionFactoryBean.setDataSource(dataSource);
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
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
