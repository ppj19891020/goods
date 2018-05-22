package com.clubfactory.center.goods.service.localServiceImpl;

import com.alibaba.fastjson.JSON;
import com.clubfactory.center.goods.config.dynamicdatasource.IdooDataSourceKey;
import com.clubfactory.center.goods.dao.price.PricePurchaseRelatedDao;
import com.clubfactory.center.goods.dto.PurchaseOrderDTO;
import com.clubfactory.center.goods.dto.PurchasePriceDTO;
import com.clubfactory.center.goods.entity.PricePurchaseRelated;
import com.clubfactory.center.goods.service.localService.PurchaseOrderService;
import com.clubfactory.center.goods.service.localService.PurchasePriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;

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

    @Autowired
    private PricePurchaseRelatedDao pricePurchaseRelatedDao;


    /**
     * 更新采购价格
     */
    @Override
    public void updatePurchasePrice(int shardingTotalCount,int shardingItem) {
        //最近7天的采购件
        HashMap<String,List<PurchasePriceDTO>> purchasePriceHashMap = this.getLastSevenDaysPurchasePrice(shardingTotalCount,shardingItem);
        //获取最近的采购价格
        HashMap<String,List<PurchasePriceDTO>> latestProductNoPurchasePriceMap = this.getLatestPurchasePrice(shardingTotalCount,shardingItem);

        //最终的采购价
        final HashMap<String,Double> purchasePrice = new HashMap<>(purchasePriceHashMap.size());
        //最近七天采购的商品，采购价求均值
        purchasePriceHashMap.forEach((k,v)->{
            OptionalDouble optionalDouble = v.stream().mapToDouble(t->t.getPurchasePrice()).average();
            if(optionalDouble.isPresent()){
                purchasePrice.put(k,optionalDouble.getAsDouble());
            }
        });
        //最近七天无采购记录，取最近一次采购价
        latestProductNoPurchasePriceMap.forEach((k,v)->{
            if(null == purchasePrice.get(k)){
                OptionalDouble optionalDouble = v.stream().mapToDouble(t->t.getPurchasePrice()).average();
                purchasePrice.put(k,optionalDouble.getAsDouble());
            }
        });

        //采购价更新
        List<String> noPurchasePriceNullItemoList = new ArrayList<>();//没有采购价商品编码列表
        List<PurchaseOrderDTO> updatePurchasePrice = new ArrayList<>();//更新最新采购价
        List<PricePurchaseRelated> pricePurchaseRelateds = pricePurchaseRelatedDao.getAllHavePurchase(shardingTotalCount,shardingItem);

        pricePurchaseRelateds.stream().forEach(t->{
            if(null == purchasePrice.get(t.getProductNo())){
                //该商品编码有采购价，但是不存在需要更新的商品编码
                noPurchasePriceNullItemoList.add(t.getProductNo());
            }else{
                PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
                purchaseOrderDTO.setItemNo(t.getProductNo());
                purchaseOrderDTO.setPurchasePrice(purchasePrice.get(t.getProductNo()).doubleValue());
                updatePurchasePrice.add(purchaseOrderDTO);
            }
        });

        LOGGER.info("开始更新价格");
        //更新采购价格为null
        if(null != noPurchasePriceNullItemoList && noPurchasePriceNullItemoList.size() > 0){
            pricePurchaseRelatedDao.updatePurchasePriceNullByItemNo(noPurchasePriceNullItemoList);
        }
        LOGGER.info("更新采购价格为null,list:{}",JSON.toJSON(noPurchasePriceNullItemoList));
        //更新最新采购价
        if(null != updatePurchasePrice && updatePurchasePrice.size() > 0){
            updatePurchasePrice.stream().forEach(t->{
                pricePurchaseRelatedDao.saveOrUpdatePurchasePrice(t);
            });
        }
        LOGGER.info("更新采购价完成");
    }

    @Override
    public HashMap<String, List<PurchasePriceDTO>> getLastSevenDaysPurchasePrice(int shardingTotalCount,int shardingItem) {
        //1、分片查询最近7天的采购单
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(7);
        //采购商品-商品编码/采购列表
        HashMap<String,List<PurchasePriceDTO>> purchasePriceHashMap = new HashMap<>(100000);

        //余杭仓库的采购单列表
        List<PurchaseOrderDTO> purchaseOrderDTOS = purchaseOrderService.getLastPurchaseOrder(IdooDataSourceKey.YUHANG,localDate.toString(),shardingTotalCount,shardingItem);
        LOGGER.info("获取最新7天采购单-查询分片采购单totalCout:{} shardingItem:{} 余杭采购单数量：{}",shardingTotalCount,shardingItem,purchaseOrderDTOS.size());
        //萧山仓库的采购单列表
        List<PurchaseOrderDTO> purchaseXsOrderDTOS = purchaseOrderService.getLastPurchaseOrder(IdooDataSourceKey.XIAOSHAN,localDate.toString(),shardingTotalCount,shardingItem);
        LOGGER.info("获取最新7天采购单-查询分片采购单totalCout:{} shardingItem:{} 萧山采购单数量：{}",shardingTotalCount,shardingItem,purchaseXsOrderDTOS.size());
        //心怡仓库的采购单列表
        List<PurchaseOrderDTO> purchaseHnOrderDTOS = purchaseOrderService.getLastPurchaseOrder(IdooDataSourceKey.XINYI,localDate.toString(),shardingTotalCount,shardingItem);
        LOGGER.info("获取最新7天采购单-查询分片采购单totalCout:{} shardingItem:{} 心怡采购单数量：{}",shardingTotalCount,shardingItem,purchaseHnOrderDTOS.size());

        //根据商品编码整理采购单
        this.converPurchasePrice(purchasePriceHashMap,purchaseOrderDTOS);
        this.converPurchasePrice(purchasePriceHashMap,purchaseXsOrderDTOS);
        this.converPurchasePrice(purchasePriceHashMap,purchaseHnOrderDTOS);

        //排序
        purchasePriceHashMap.forEach((k,v)->{
            v.sort((PurchasePriceDTO t1,PurchasePriceDTO t2)->t2.getCreateTime().compareTo(t1.getCreateTime()));
        });

        return purchasePriceHashMap;
    }

    @Override
    public HashMap<String, List<PurchasePriceDTO>> getLatestPurchasePrice(int shardingTotalCount, int shardingItem) {
        //余杭仓库的采购单列表
        List<PurchaseOrderDTO> purchaseOrderDTOS = purchaseOrderService.getLatestPurchasePrice(IdooDataSourceKey.YUHANG,shardingTotalCount,shardingItem);
        LOGGER.info("获取最近的采购价格-查询分片采购单totalCout:{} shardingItem:{} 余杭采购单数量：{}",shardingTotalCount,shardingItem,purchaseOrderDTOS.size());
        //萧山仓库的采购单列表
        List<PurchaseOrderDTO> purchaseXsOrderDTOS = purchaseOrderService.getLatestPurchasePrice(IdooDataSourceKey.XIAOSHAN,shardingTotalCount,shardingItem);
        LOGGER.info("获取最近的采购价格-查询分片采购单totalCout:{} shardingItem:{} 萧山采购单数量：{}",shardingTotalCount,shardingItem,purchaseXsOrderDTOS.size());
        //心怡仓库的采购单列表
        List<PurchaseOrderDTO> purchaseHnOrderDTOS = purchaseOrderService.getLatestPurchasePrice(IdooDataSourceKey.XINYI,shardingTotalCount,shardingItem);
        LOGGER.info("获取最近的采购价格-查询分片采购单totalCout:{} shardingItem:{} 心怡采购单数量：{}",shardingTotalCount,shardingItem,purchaseHnOrderDTOS.size());

        //采购商品-商品编码/采购列表
        HashMap<String,List<PurchasePriceDTO>> purchasePriceHashMap = new HashMap<>(100000);

        //根据商品编码整理采购单
        this.converPurchasePrice(purchasePriceHashMap,purchaseOrderDTOS);
        this.converPurchasePrice(purchasePriceHashMap,purchaseXsOrderDTOS);
        this.converPurchasePrice(purchasePriceHashMap,purchaseHnOrderDTOS);

        //排序
        purchasePriceHashMap.forEach((k,v)->{
            v.sort((PurchasePriceDTO t1,PurchasePriceDTO t2)->t2.getCreateTime().compareTo(t1.getCreateTime()));
        });

        return purchasePriceHashMap;
    }

    /**
     * 按照商品编码生成map 商品编码-采购单列表
     * @param purchasePriceHashMap
     * @param purchaseOrderDTOS
     */
    private void converPurchasePrice(HashMap<String,List<PurchasePriceDTO>> purchasePriceHashMap,List<PurchaseOrderDTO> purchaseOrderDTOS){
        purchaseOrderDTOS.stream().filter(t->null != t.getPurchasePrice()&&t.getPurchasePrice().doubleValue() > 0).forEach(t -> {
            if (t.getState() == 6 && (t.getPurchaseNote() == null || t.getPurchaseNote().equals("价高") )){
                return;
            }
            List result = purchasePriceHashMap.get(t.getItemNo());
            PurchasePriceDTO purchasePriceDTO = new PurchasePriceDTO();
            if(null != result){
                purchasePriceDTO.setPurchasePrice(t.getPurchasePrice());
                purchasePriceDTO.setCreateTime(t.getCreateTime());
                result.add(purchasePriceDTO);
            }else{
                List<PurchasePriceDTO> purchasePriceDTOList = new ArrayList<>();
                purchasePriceDTO.setPurchasePrice(t.getPurchasePrice());
                purchasePriceDTO.setCreateTime(t.getCreateTime());
                purchasePriceDTOList.add(purchasePriceDTO);
                purchasePriceHashMap.put(t.getItemNo(),purchasePriceDTOList);
            }
        });
    }
}
