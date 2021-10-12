package com.freshnin.userapplication.model;

public class ModelPreOrderHistory {

    private String preOrdrId;
    private String preOrderProductName;
    private String preOrderProductDeliverDate;
    private String preOrderPaymentStatus;

    public ModelPreOrderHistory(String preOrdrId, String preOrderProductName, String preOrderProductDeliverDate, String preOrderPaymentStatus) {
        this.preOrdrId = preOrdrId;
        this.preOrderProductName = preOrderProductName;
        this.preOrderProductDeliverDate = preOrderProductDeliverDate;
        this.preOrderPaymentStatus = preOrderPaymentStatus;
    }

    public String getPreOrdrId() {
        return preOrdrId;
    }

    public void setPreOrdrId(String preOrdrId) {
        this.preOrdrId = preOrdrId;
    }

    public String getPreOrderProductName() {
        return preOrderProductName;
    }

    public void setPreOrderProductName(String preOrderProductName) {
        this.preOrderProductName = preOrderProductName;
    }

    public String getPreOrderProductDeliverDate() {
        return preOrderProductDeliverDate;
    }

    public void setPreOrderProductDeliverDate(String preOrderProductDeliverDate) {
        this.preOrderProductDeliverDate = preOrderProductDeliverDate;
    }

    public String getPreOrderPaymentStatus() {
        return preOrderPaymentStatus;
    }

    public void setPreOrderPaymentStatus(String preOrderPaymentStatus) {
        this.preOrderPaymentStatus = preOrderPaymentStatus;
    }
}
