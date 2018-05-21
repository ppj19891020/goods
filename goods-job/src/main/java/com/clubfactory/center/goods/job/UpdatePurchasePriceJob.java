package com.clubfactory.center.goods.job;

import com.alibaba.fastjson.JSON;
import com.clubfactory.center.goods.entity.PurchaseOrder;
import com.clubfactory.center.goods.service.localService.PurchasePriceService;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述:
 *  更新采购价
 * @author pangpeijie
 * @create 2018-05-21 14:17
 */
@Component(value = "updatePurchasePriceJob")
public class UpdatePurchasePriceJob implements SimpleJob {

    private final static Logger LOGGER = LoggerFactory.getLogger(UpdatePurchasePriceJob.class);

    @Autowired
    private PurchasePriceService purchasePriceService;

    @Override
    public void execute(ShardingContext shardingContext) {
        LOGGER.info("更新采购价job,context:{}",JSON.toJSONString(shardingContext));
        List<PurchaseOrder> purchaseOrderList = purchasePriceService.getALLPurchaseOrders();
    }

}
