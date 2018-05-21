package com.clubfactory.center.goods.dto;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 *  查询近7天采购单
 * @author pangpeijie
 * @create 2018-05-21 17:42
 */
@Data
public class PurchaseOrderDTO {

    /**
     * 商品编码
     */
    private String itemNo;

    /**
     * 商品价格
     */
    private Double purchasePrice;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 采购单状态. 0:未采购, 1:已采购, 2:已发货, 3:部分入库, 4:全部入库, 5:部分缺货, 6:全部缺货, 7:取消
     */
    private int state;

    /**
     * 购买备注
     */
    private String purchaseNote;

}
