package com.clubfactory.center.goods.job;

import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述:
 *  更新采购价
 * @author pangpeijie
 * @create 2018-05-21 14:17
 */
public class UpdatePurchasePriceJob implements SimpleJob {

    private final static Logger LOGGER = LoggerFactory.getLogger(UpdatePurchasePriceJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        LOGGER.info("更新采购价job,context:{}",JSON.toJSONString(shardingContext));
    }

}
