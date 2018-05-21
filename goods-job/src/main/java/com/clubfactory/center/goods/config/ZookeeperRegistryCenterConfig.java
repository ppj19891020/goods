package com.clubfactory.center.goods.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *  elastic-job zookeeper配置中心
 * @author pangpeijie
 * @create 2018-05-21 10:13
 */
@Configuration
@ConditionalOnExpression("'${regCenter.serverList}'.length()>0")
public class ZookeeperRegistryCenterConfig {

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(@Value("${elastic-job.regCenter.serverList}") final String serverList,
                                             @Value("${elastic-job.regCenter.namespace}") final String namespace){
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList,namespace));
    }

}
