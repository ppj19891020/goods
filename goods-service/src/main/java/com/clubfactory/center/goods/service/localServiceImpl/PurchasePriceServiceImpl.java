package com.clubfactory.center.goods.service.localServiceImpl;

import com.clubfactory.center.goods.dao.idoo.PurchaseOrderDao;
import com.clubfactory.center.goods.entity.PurchaseOrder;
import com.clubfactory.center.goods.service.localService.PurchasePriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 *
 * @author pangpeijie
 * @create 2018-05-21 16:24
 */
@Service
public class PurchasePriceServiceImpl implements PurchasePriceService {

    @Resource
    private PurchaseOrderDao purchaseOrderDao;

    @Override
    public List<PurchaseOrder> getALLPurchaseOrders() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        return purchaseOrderDao.getList(purchaseOrder);
    }
}
