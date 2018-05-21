package com.clubfactory.center.goods.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 描述:
 *
 * @author pangpeijie
 * @create 2018-05-21 11:39
 */
@Configuration
public class JobEventConfig {

    /**
     * 配置数据源
     * @return
     */
    @Bean(name = "elasticJobDataSource")
    @ConfigurationProperties("spring.datasource.elastic-job")
    public DataSource masterDataSource(){
        return new DruidDataSource();
    }

    @Bean
    public JobEventConfiguration jobEventConfiguration(@Qualifier("elasticJobDataSource") DataSource dataSource) {
        return new JobEventRdbConfiguration(dataSource);
    }

}
