package com.clubfactory.center.goods.service.localService;

import com.clubfactory.center.goods.config.dynamicdatasource.IdooDataSourceKey;
import com.clubfactory.center.goods.dto.PurchaseOrderDTO;

import java.util.List;

/**
 * 描述:
 *
 * @author pangpeijie
 * @create 2018-05-21 19:50
 */
public interface PurchaseOrderService {

    /**
     * 查询最近几天的采购单
     * @param lastDate
     * @return
     */
    List<PurchaseOrderDTO> getLastPurchaseOrder(IdooDataSourceKey idooDataSourceKey, String lastDate, int shardingTotalCount, int shardingItem);

    /**
     * 获取最近一次采购价格数据
     * @param shardingTotalCount
     * @param shardingItem
     * @return
     */
    List<PurchaseOrderDTO> getLatestPurchasePrice(IdooDataSourceKey idooDataSourceKey,int shardingTotalCount,int shardingItem);

}
