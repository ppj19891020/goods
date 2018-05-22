package com.clubfactory.center.goods.entity;

import com.clubfactory.core.base.BaseEntity;
import java.util.Date;

public class PricePurchaseRelated extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * @Fields productNo 货号
     */
    private String productNo;

    /**
     * @Fields purchasePrice 采购价
     */
    private Double purchasePrice;

    /**
     * @Fields operationPrice 运营人工价
     */
    private Double operationPrice;

    /**
     * @Fields skuLinkPrice 供应商参考价
     */
    private Double skuLinkPrice;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(Double operationPrice) {
        this.operationPrice = operationPrice;
    }

    public Double getSkuLinkPrice() {
        return skuLinkPrice;
    }

    public void setSkuLinkPrice(Double skuLinkPrice) {
        this.skuLinkPrice = skuLinkPrice;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}