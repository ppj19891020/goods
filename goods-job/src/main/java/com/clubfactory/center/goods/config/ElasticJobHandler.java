package com.clubfactory.center.goods.config;

import com.clubfactory.center.goods.job.UpdateGoodsPriceJob;
import com.clubfactory.center.goods.job.UpdatePurchasePriceJob;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 描述:
 *  定时任务job配置
 * @author pangpeijie
 * @create 2018-05-21 15:08
 */
@Component
public class ElasticJobHandler {

    @Resource
    protected ZookeeperRegistryCenter regCenter;

    @Resource
    protected JobEventConfiguration jobEventConfiguration;

    /**
     * 更新采购价定时任务
     * @param cron
     * @param shardingTotalCount
     * @param shardingItemParameters
     * @return
     */
    @Bean(initMethod = "init",name = "updatePurchasePriceJobScheduler")
    public JobScheduler updateGoodsPriceJobScheduler(@Value("${elastic-job.updateGoodsPriceJob.cron}") final String cron,
                                           @Value("${elastic-job.updateGoodsPriceJob.shardingTotalCount}") final int shardingTotalCount,
                                           @Value("${elastic-job.updateGoodsPriceJob.shardingItemParameters}") final String shardingItemParameters){
        return new SpringJobScheduler(new UpdatePurchasePriceJob(), regCenter, getLiteJobConfiguration(UpdatePurchasePriceJob.class, cron, shardingTotalCount,
                shardingItemParameters), jobEventConfiguration);
    }

    /**
     * 更新商品价格
     * @param cron
     * @param shardingTotalCount
     * @param shardingItemParameters
     * @return
     */
    @Bean(initMethod = "init",name = "updateGoodsPriceJobScheduler")
    public JobScheduler simpleJobScheduler(@Value("${elastic-job.updateGoodsPriceJob.cron}") final String cron,
                                           @Value("${elastic-job.updateGoodsPriceJob.shardingTotalCount}") final int shardingTotalCount,
                                           @Value("${elastic-job.updateGoodsPriceJob.shardingItemParameters}") final String shardingItemParameters){
        return new SpringJobScheduler(new UpdateGoodsPriceJob(), regCenter, getLiteJobConfiguration(UpdateGoodsPriceJob.class, cron, shardingTotalCount,
                shardingItemParameters), jobEventConfiguration);
    }

    protected LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass, final String cron, final int shardingTotalCount, final String shardingItemParameters) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(JobCoreConfiguration.newBuilder(
                jobClass.getName(), cron, shardingTotalCount).shardingItemParameters(shardingItemParameters).build(), jobClass.getCanonicalName())).overwrite(true).build();
    }

}
