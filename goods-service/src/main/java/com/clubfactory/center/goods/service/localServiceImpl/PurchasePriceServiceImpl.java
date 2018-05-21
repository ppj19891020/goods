package com.clubfactory.center.goods.service.localServiceImpl;

import com.clubfactory.center.goods.config.dynamicdatasource.IdooDataSourceKey;
import com.clubfactory.center.goods.dto.PurchaseOrderDTO;
import com.clubfactory.center.goods.service.localService.PurchaseOrderService;
import com.clubfactory.center.goods.service.localService.PurchasePriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 描述:
 *
 * @author pangpeijie
 * @create 2018-05-21 16:24
 */
@Service
public class PurchasePriceServiceImpl implements PurchasePriceService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PurchasePriceServiceImpl.class);

    /**
     * 通用仓库
     */
    @Autowired
    private PurchaseOrderService purchaseOrderService;


    /**
     * 更新采购价格
     */
    @Override
    public void updatePurchasePrice(int shardingTotalCount,int shardingItem) {
        //1、分片查询最近7天的采购单
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(7);
        //余杭仓库的采购单列表
        List<PurchaseOrderDTO> purchaseOrderDTOS = purchaseOrderService.getLastPurchaseOrder(IdooDataSourceKey.YUHANG,localDate.toString(),shardingTotalCount,shardingItem);
        LOGGER.info("查询分片采购单totalCout:{} shardingItem:{} 余杭采购单数量：{}",shardingTotalCount,shardingItem,purchaseOrderDTOS.size());

        //萧山仓库的采购单列表
        List<PurchaseOrderDTO> purchaseXsOrderDTOS = purchaseOrderService.getLastPurchaseOrder(IdooDataSourceKey.XIAOSHAN,localDate.toString(),shardingTotalCount,shardingItem);
        LOGGER.info("查询分片采购单totalCout:{} shardingItem:{} 萧山采购单数量：{}",shardingTotalCount,shardingItem,purchaseXsOrderDTOS.size());

    }
}
