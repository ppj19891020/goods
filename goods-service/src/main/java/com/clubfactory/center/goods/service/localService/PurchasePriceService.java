package com.clubfactory.center.goods.service.localService;

/**
 * 描述:
 *  采购价格service
 * @author pangpeijie
 * @create 2018-05-21 16:20
 */
public interface PurchasePriceService {

    /**
     * 更新采购价主service
     * @param shardingTotalCount 总分片数
     * @param shardingItem 当前分片数
     */
    void updatePurchasePrice(int shardingTotalCount,int shardingItem);
}
