package com.clubfactory.center.goods.entity;

import com.clubfactory.core.base.BaseEntity;
import java.util.Date;

public class PurchaseOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * @Fields uuid 采购批次
     */
    private String uuid;

    /**
     * @Fields qtySystemDemand 系统需求采购量
     */
    private Integer qtySystemDemand;

    /**
     * @Fields qtyPurchaseDemand 人工需求采购量
     */
    private Integer qtyPurchaseDemand;

    /**
     * @Fields qtyPurchased 已买数量
     */
    private Integer qtyPurchased;

    /**
     * @Fields qtyReceived 入库数量
     */
    private Integer qtyReceived;

    /**
     * @Fields purchasePrice 采购价格
     */
    private Double purchasePrice;

    /**
     * @Fields targetWarehouseId 目标仓库的id
     */
    private Short targetWarehouseId;

    private Date createTime;

    /**
     * @Fields purchaseTime 购买时间
     */
    private Date purchaseTime;

    private Date updateTime;

    /**
     * @Fields completeTime 采购单完成时间
     */
    private Date completeTime;

    /**
     * @Fields sourceType 来源种类.0: 系统, 1: 人工, 2: 补单
     */
    private Short sourceType;

    /**
     * @Fields hasBackorder 是否有补单. 0:没有补单. 1:有补单
     */
    private Short hasBackorder;

    /**
     * @Fields state 采购单状态. 0:未采购, 1:已采购, 2:已发货, 3:部分入库, 4:全部入库, 5:部分缺货, 6:全部缺货, 7:取消
     */
    private Short state;

    /**
     * @Fields skuSalePrice 销售单价
     */
    private Double skuSalePrice;

    /**
     * @Fields completeUserId 采购单完成者
     */
    private Integer completeUserId;

    private Integer createUserId;

    /**
     * @Fields followUserId 采购负责人
     */
    private Integer followUserId;

    /**
     * @Fields purchaseUserId 购买者
     */
    private Integer purchaseUserId;

    /**
     * @Fields sourcePurchaseOrderId 源单
     */
    private Integer sourcePurchaseOrderId;

    /**
     * @Fields stockKeepUnitId 连接到本地sku的外健
     */
    private Integer stockKeepUnitId;

    /**
     * @Fields supplyOrderId 连接到supply_order表的外健
     */
    private Integer supplyOrderId;

    /**
     * @Fields updateUserId 更新者的用户id
     */
    private Integer updateUserId;

    /**
     * @Fields purchaseCompanyName 供应商名称
     */
    private String purchaseCompanyName;

    /**
     * @Fields difficultOrder 是否是疑难单. 0:否, 1:是
     */
    private Boolean difficultOrder;

    /**
     * @Fields difficultOrderFollowerId 疑难单负责人
     */
    private Integer difficultOrderFollowerId;

    /**
     * @Fields logisticsStatus 物流状态 0: 无运单， 1：全部是未揽收单， 2：全部是揽收单，3：部分揽收且无未知单， 4：部分揽收且有未知单， 5：只有未知单和未揽收单， 6：全部是未知单，7:已签收
     */
    private Short logisticsStatus;

    /**
     * @Fields qtySigned 签收数量
     */
    private Integer qtySigned;

    /**
     * @Fields signedTime 最近一次签收的时间
     */
    private Date signedTime;

    /**
     * @Fields signedUserId 签收修改者用户id
     */
    private Integer signedUserId;

    /**
     * @Fields completeUserName 采购单完成者的用户名字
     */
    private String completeUserName;

    private String createUserName;

    /**
     * @Fields difficultOrderFollowerName 疑难单负责人的名字
     */
    private String difficultOrderFollowerName;

    /**
     * @Fields followUserName 采购负责人名字
     */
    private String followUserName;

    /**
     * @Fields purchaseUserName 采购购买者的名字
     */
    private String purchaseUserName;

    /**
     * @Fields signedUserName 签收用户的名字
     */
    private String signedUserName;

    private String updateUserName;

    /**
     * @Fields receiveUserName 第一个入库人的名字
     */
    private String receiveUserName;

    private Integer receiveUserId;

    /**
     * @Fields hasBought 是否已买，默认为0，表示没有买
     */
    private Short hasBought;

    /**
     * @Fields topSourcePurchaseOrderId 第一次的单
     */
    private Integer topSourcePurchaseOrderId;

    private String shortUuid;

    /**
     * @Fields isException 是否是异常采购单
     */
    private Boolean isException;

    /**
     * @Fields purchaseSkuBarcode 供货条码
     */
    private String purchaseSkuBarcode;

    /**
     * @Fields isCooperativeSupplier 该采购单是否应由供应商处理
     */
    private Boolean isCooperativeSupplier;

    /**
     * @Fields prevState 前一个状态. 0:未采购, 1:已采购, 2:已发货, 3:部分入库, 4:全部入库, 5:部分缺货, 6:全部缺货, 7:取消
     */
    private Short prevState;

    /**
     * @Fields supplierUuid 供应商uuid
     */
    private String supplierUuid;

    /**
     * @Fields skuLinkRelId sku_link_rel -> id
     */
    private Integer skuLinkRelId;

    /**
     * @Fields sourcePurchaseOrderUuid 源采购批次号
     */
    private String sourcePurchaseOrderUuid;

    /**
     * @Fields topSourcePurchaseOrderUuid 首次源采购批次号
     */
    private String topSourcePurchaseOrderUuid;

    /**
     * @Fields supplierIsDisposable 该po单的供应商是否是一次性供应商. 0:  不是, 1: 是
     */
    private Boolean supplierIsDisposable;

    /**
     * @Fields qualityType 质检类型：NORMAL普通 SCORE打分
     */
    private String qualityType;

    /**
     * @Fields qualityScore 品质分
     */
    private Float qualityScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getQtySystemDemand() {
        return qtySystemDemand;
    }

    public void setQtySystemDemand(Integer qtySystemDemand) {
        this.qtySystemDemand = qtySystemDemand;
    }

    public Integer getQtyPurchaseDemand() {
        return qtyPurchaseDemand;
    }

    public void setQtyPurchaseDemand(Integer qtyPurchaseDemand) {
        this.qtyPurchaseDemand = qtyPurchaseDemand;
    }

    public Integer getQtyPurchased() {
        return qtyPurchased;
    }

    public void setQtyPurchased(Integer qtyPurchased) {
        this.qtyPurchased = qtyPurchased;
    }

    public Integer getQtyReceived() {
        return qtyReceived;
    }

    public void setQtyReceived(Integer qtyReceived) {
        this.qtyReceived = qtyReceived;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Short getTargetWarehouseId() {
        return targetWarehouseId;
    }

    public void setTargetWarehouseId(Short targetWarehouseId) {
        this.targetWarehouseId = targetWarehouseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Short getSourceType() {
        return sourceType;
    }

    public void setSourceType(Short sourceType) {
        this.sourceType = sourceType;
    }

    public Short getHasBackorder() {
        return hasBackorder;
    }

    public void setHasBackorder(Short hasBackorder) {
        this.hasBackorder = hasBackorder;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Double getSkuSalePrice() {
        return skuSalePrice;
    }

    public void setSkuSalePrice(Double skuSalePrice) {
        this.skuSalePrice = skuSalePrice;
    }

    public Integer getCompleteUserId() {
        return completeUserId;
    }

    public void setCompleteUserId(Integer completeUserId) {
        this.completeUserId = completeUserId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getFollowUserId() {
        return followUserId;
    }

    public void setFollowUserId(Integer followUserId) {
        this.followUserId = followUserId;
    }

    public Integer getPurchaseUserId() {
        return purchaseUserId;
    }

    public void setPurchaseUserId(Integer purchaseUserId) {
        this.purchaseUserId = purchaseUserId;
    }

    public Integer getSourcePurchaseOrderId() {
        return sourcePurchaseOrderId;
    }

    public void setSourcePurchaseOrderId(Integer sourcePurchaseOrderId) {
        this.sourcePurchaseOrderId = sourcePurchaseOrderId;
    }

    public Integer getStockKeepUnitId() {
        return stockKeepUnitId;
    }

    public void setStockKeepUnitId(Integer stockKeepUnitId) {
        this.stockKeepUnitId = stockKeepUnitId;
    }

    public Integer getSupplyOrderId() {
        return supplyOrderId;
    }

    public void setSupplyOrderId(Integer supplyOrderId) {
        this.supplyOrderId = supplyOrderId;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getPurchaseCompanyName() {
        return purchaseCompanyName;
    }

    public void setPurchaseCompanyName(String purchaseCompanyName) {
        this.purchaseCompanyName = purchaseCompanyName;
    }

    public Boolean getDifficultOrder() {
        return difficultOrder;
    }

    public void setDifficultOrder(Boolean difficultOrder) {
        this.difficultOrder = difficultOrder;
    }

    public Integer getDifficultOrderFollowerId() {
        return difficultOrderFollowerId;
    }

    public void setDifficultOrderFollowerId(Integer difficultOrderFollowerId) {
        this.difficultOrderFollowerId = difficultOrderFollowerId;
    }

    public Short getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Short logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public Integer getQtySigned() {
        return qtySigned;
    }

    public void setQtySigned(Integer qtySigned) {
        this.qtySigned = qtySigned;
    }

    public Date getSignedTime() {
        return signedTime;
    }

    public void setSignedTime(Date signedTime) {
        this.signedTime = signedTime;
    }

    public Integer getSignedUserId() {
        return signedUserId;
    }

    public void setSignedUserId(Integer signedUserId) {
        this.signedUserId = signedUserId;
    }

    public String getCompleteUserName() {
        return completeUserName;
    }

    public void setCompleteUserName(String completeUserName) {
        this.completeUserName = completeUserName;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getDifficultOrderFollowerName() {
        return difficultOrderFollowerName;
    }

    public void setDifficultOrderFollowerName(String difficultOrderFollowerName) {
        this.difficultOrderFollowerName = difficultOrderFollowerName;
    }

    public String getFollowUserName() {
        return followUserName;
    }

    public void setFollowUserName(String followUserName) {
        this.followUserName = followUserName;
    }

    public String getPurchaseUserName() {
        return purchaseUserName;
    }

    public void setPurchaseUserName(String purchaseUserName) {
        this.purchaseUserName = purchaseUserName;
    }

    public String getSignedUserName() {
        return signedUserName;
    }

    public void setSignedUserName(String signedUserName) {
        this.signedUserName = signedUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Short getHasBought() {
        return hasBought;
    }

    public void setHasBought(Short hasBought) {
        this.hasBought = hasBought;
    }

    public Integer getTopSourcePurchaseOrderId() {
        return topSourcePurchaseOrderId;
    }

    public void setTopSourcePurchaseOrderId(Integer topSourcePurchaseOrderId) {
        this.topSourcePurchaseOrderId = topSourcePurchaseOrderId;
    }

    public String getShortUuid() {
        return shortUuid;
    }

    public void setShortUuid(String shortUuid) {
        this.shortUuid = shortUuid;
    }

    public Boolean getIsException() {
        return isException;
    }

    public void setIsException(Boolean isException) {
        this.isException = isException;
    }

    public String getPurchaseSkuBarcode() {
        return purchaseSkuBarcode;
    }

    public void setPurchaseSkuBarcode(String purchaseSkuBarcode) {
        this.purchaseSkuBarcode = purchaseSkuBarcode;
    }

    public Boolean getIsCooperativeSupplier() {
        return isCooperativeSupplier;
    }

    public void setIsCooperativeSupplier(Boolean isCooperativeSupplier) {
        this.isCooperativeSupplier = isCooperativeSupplier;
    }

    public Short getPrevState() {
        return prevState;
    }

    public void setPrevState(Short prevState) {
        this.prevState = prevState;
    }

    public String getSupplierUuid() {
        return supplierUuid;
    }

    public void setSupplierUuid(String supplierUuid) {
        this.supplierUuid = supplierUuid;
    }

    public Integer getSkuLinkRelId() {
        return skuLinkRelId;
    }

    public void setSkuLinkRelId(Integer skuLinkRelId) {
        this.skuLinkRelId = skuLinkRelId;
    }

    public String getSourcePurchaseOrderUuid() {
        return sourcePurchaseOrderUuid;
    }

    public void setSourcePurchaseOrderUuid(String sourcePurchaseOrderUuid) {
        this.sourcePurchaseOrderUuid = sourcePurchaseOrderUuid;
    }

    public String getTopSourcePurchaseOrderUuid() {
        return topSourcePurchaseOrderUuid;
    }

    public void setTopSourcePurchaseOrderUuid(String topSourcePurchaseOrderUuid) {
        this.topSourcePurchaseOrderUuid = topSourcePurchaseOrderUuid;
    }

    public Boolean getSupplierIsDisposable() {
        return supplierIsDisposable;
    }

    public void setSupplierIsDisposable(Boolean supplierIsDisposable) {
        this.supplierIsDisposable = supplierIsDisposable;
    }

    public String getQualityType() {
        return qualityType;
    }

    public void setQualityType(String qualityType) {
        this.qualityType = qualityType;
    }

    public Float getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(Float qualityScore) {
        this.qualityScore = qualityScore;
    }
}