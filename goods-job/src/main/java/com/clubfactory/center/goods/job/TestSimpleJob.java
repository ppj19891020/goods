package com.clubfactory.center.goods.job;

import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述:
 *  测试简单任务
 * @author pangpeijie
 * @create 2018-05-21 10:17
 */
public class TestSimpleJob implements SimpleJob {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestSimpleJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        try {
            LOGGER.info("测试简单任务-start，context:{}",JSON.toJSONString(shardingContext));
            Thread.sleep(5000L);
            LOGGER.info("测试简单任务-end，context:{}",JSON.toJSONString(shardingContext));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
