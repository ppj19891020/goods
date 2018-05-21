package com.clubfactory.center.goods.entity;

public class PurchaseOrderWithBLOBs extends PurchaseOrder {
    /**
     * @Fields purchaseLink 供应商链接
     */
    private String purchaseLink;

    /**
     * @Fields purchaseLinkNote 采购规格
     */
    private String purchaseLinkNote;

    public String getPurchaseLink() {
        return purchaseLink;
    }

    public void setPurchaseLink(String purchaseLink) {
        this.purchaseLink = purchaseLink;
    }

    public String getPurchaseLinkNote() {
        return purchaseLinkNote;
    }

    public void setPurchaseLinkNote(String purchaseLinkNote) {
        this.purchaseLinkNote = purchaseLinkNote;
    }
}