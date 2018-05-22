package com.clubfactory.center.goods.service.localService;

import com.clubfactory.center.goods.dto.PurchasePriceDTO;

import java.util.HashMap;
import java.util.List;

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

    /**
     * 获取最近7天的采购单，商品编码为key，value为采购信息列表，并按照采购时间倒叙排序
     * @return
     */
    HashMap<String,List<PurchasePriceDTO>> getLastSevenDaysPurchasePrice(int shardingTotalCount,int shardingItem);

    /**
     * 获取最近的采购价格
     * @param shardingTotalCount
     * @param shardingItem
     * @return
     */
    HashMap<String,List<PurchasePriceDTO>> getLatestPurchasePrice(int shardingTotalCount,int shardingItem);

}
