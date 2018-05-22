package com.clubfactory.center.goods.dao.price;

import com.clubfactory.center.goods.dto.PurchaseOrderDTO;
import com.clubfactory.center.goods.entity.PricePurchaseRelated;
import com.clubfactory.core.base.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PricePurchaseRelatedDao extends BaseDao<PricePurchaseRelated> {

    /**
     * 获取所有有采购价的商品
     * @return
     */
    List<PricePurchaseRelated> getAllHavePurchase(@Param("shardingTotalCount") int shardingTotalCount,@Param("shardingItem") int shardingItem);

    /**
     * 更新采购价格为null
     * @param noPurchasePriceNullItemoList
     */
    void updatePurchasePriceNullByItemNo(@Param("noPurchasePriceNullItemoList") List<String> noPurchasePriceNullItemoList);

    /**
     * 插入或者更新采购价格
     * @param purchaseOrderDTO
     */
    void saveOrUpdatePurchasePrice(PurchaseOrderDTO purchaseOrderDTO);
}