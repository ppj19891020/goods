package com.clubfactory.center.goods.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 描述:
 *  价格服务datasource
 * @author pangpeijie
 * @create 2018-05-18 13:20
 */
@Configuration
@MapperScan(basePackages = "com.clubfactory.center.goods.mapper.price",
        sqlSessionFactoryRef = "priceSqlSessionFactory")
public class PriceDatasourceConfig {

    /**
     * 配置数据源
     * @return
     */
    @Bean(name = "priceDataSource")
    @ConfigurationProperties("spring.datasource.price")
    public DataSource masterDataSource(){
        return new DruidDataSource();
    }

    /**
     * 配置sqlsessionfactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "priceSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("priceDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:com/clubfactory/mapper/price/*.xml"));
        return sessionFactoryBean.getObject();
    }

    /**
     * 配置事物管理器
     * @return
     */
    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("priceDataSource") DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
