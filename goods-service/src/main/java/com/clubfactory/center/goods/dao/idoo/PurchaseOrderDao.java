package com.clubfactory.center.goods.dao.idoo;

import com.clubfactory.center.goods.dto.PurchaseOrderDTO;
import com.clubfactory.center.goods.entity.PurchaseOrder;
import com.clubfactory.core.base.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 通用仓库接口
 */
public interface PurchaseOrderDao extends BaseDao<PurchaseOrder> {

    /**
     * 查询最近几天的采购单
     * @param lastDate
     * @return
     */
    List<PurchaseOrderDTO> getLastPurchaseOrder(@Param("lastDate")String lastDate,
                                                @Param("shardingTotalCount")int shardingTotalCount,@Param("shardingItem")int shardingItem);

    /**
     * 获取最近一次采购价格数据
     * @param shardingTotalCount
     * @param shardingItem
     * @return
     */
    List<PurchaseOrderDTO> getLatestPurchasePrice(@Param("shardingTotalCount")int shardingTotalCount,@Param("shardingItem")int shardingItem);
}