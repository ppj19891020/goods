package com.clubfactory.center.goods.job;

import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述:
 *  商品价格更新job
 * @author pangpeijie
 * @create 2018-05-21 10:17
 */
public class UpdateGoodsPriceJob implements SimpleJob {

    private final static Logger LOGGER = LoggerFactory.getLogger(UpdateGoodsPriceJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        LOGGER.info("商品价格更新定时任务，context:{}",JSON.toJSONString(shardingContext));
    }
}
