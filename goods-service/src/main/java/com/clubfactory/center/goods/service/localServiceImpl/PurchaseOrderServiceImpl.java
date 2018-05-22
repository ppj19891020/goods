package com.clubfactory.center.goods.service.localServiceImpl;

import com.clubfactory.center.goods.config.dynamicdatasource.DynamicIdooDataSourceContextHolder;
import com.clubfactory.center.goods.config.dynamicdatasource.IdooDataSourceKey;
import com.clubfactory.center.goods.dao.idoo.PurchaseOrderDao;
import com.clubfactory.center.goods.dto.PurchaseOrderDTO;
import com.clubfactory.center.goods.service.localService.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *  采购单服务
 * @author pangpeijie
 * @create 2018-05-21 19:50
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;

    @Override
    public List<PurchaseOrderDTO> getLastPurchaseOrder(IdooDataSourceKey idooDataSourceKey, String lastDate, int shardingTotalCount, int shardingItem) {
        DynamicIdooDataSourceContextHolder.setDataSourceKey(idooDataSourceKey);
        return purchaseOrderDao.getLastPurchaseOrder(lastDate,shardingTotalCount,shardingItem);
    }

    @Override
    public List<PurchaseOrderDTO> getLatestPurchasePrice(IdooDataSourceKey idooDataSourceKey, int shardingTotalCount, int shardingItem) {
        DynamicIdooDataSourceContextHolder.setDataSourceKey(idooDataSourceKey);
        return purchaseOrderDao.getLatestPurchasePrice(shardingTotalCount,shardingItem);
    }
}
