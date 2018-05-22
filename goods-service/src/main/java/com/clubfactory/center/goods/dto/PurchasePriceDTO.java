package com.clubfactory.center.goods.dto;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 *  采购价格
 * @author pangpeijie
 * @create 2018-05-22 13:35
 */
@Data
public class PurchasePriceDTO {

    /**
     * 采购价
     */
    private Double purchasePrice;

    /**
     * 采购时间
     */
    private Date createTime;

}
