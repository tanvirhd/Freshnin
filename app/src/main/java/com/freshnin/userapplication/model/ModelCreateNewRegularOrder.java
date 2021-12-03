package com.freshnin.userapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelCreateNewRegularOrder {

    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("itemIds")
    @Expose
    private String itemIds;
    @SerializedName("itemQuantities")
    @Expose
    private String itemQuantities;
    @SerializedName("totalBill")
    @Expose
    private Integer totalBill;
    @SerializedName("deliveryCharge")
    @Expose
    private Integer deliveryCharge;
    @SerializedName("deliveryAddress")
    @Expose
    private String deliveryAddress;
    @SerializedName("inTownDelivery")
    @Expose
    private Integer inTownDelivery;
    @SerializedName("orderPlaceDate")
    @Expose
    private String orderPlaceDate;
    @SerializedName("orderPlaceTime")
    @Expose
    private String orderPlaceTime;
    @SerializedName("contactNumber")
    @Expose
    private String contactNumber;
    @SerializedName("paymetType")
    @Expose
    private String paymetType;
    @SerializedName("orderStatus")
    @Expose
    private Integer orderStatus;

    public ModelCreateNewRegularOrder(String orderId, String userId, String itemIds, String itemQuantities,
                                      Integer totalBill, Integer deliveryCharge, String deliveryAddress,
                                      Integer inTownDelivery, String orderPlaceDate, String orderPlaceTime,
                                      String contactNumber, String paymetType, Integer orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemIds = itemIds;
        this.itemQuantities = itemQuantities;
        this.totalBill = totalBill;
        this.deliveryCharge = deliveryCharge;
        this.deliveryAddress = deliveryAddress;
        this.inTownDelivery = inTownDelivery;
        this.orderPlaceDate = orderPlaceDate;
        this.orderPlaceTime = orderPlaceTime;
        this.contactNumber = contactNumber;
        this.paymetType = paymetType;
        this.orderStatus = orderStatus;
    }

    public ModelCreateNewRegularOrder() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemIds() {
        return itemIds;
    }

    public void setItemIds(String itemIds) {
        this.itemIds = itemIds;
    }

    public String getItemQuantities() {
        return itemQuantities;
    }

    public void setItemQuantities(String itemQuantities) {
        this.itemQuantities = itemQuantities;
    }

    public Integer getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Integer totalBill) {
        this.totalBill = totalBill;
    }

    public Integer getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Integer deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getInTownDelivery() {
        return inTownDelivery;
    }

    public void setInTownDelivery(Integer inTownDelivery) {
        this.inTownDelivery = inTownDelivery;
    }

    public String getOrderPlaceDate() {
        return orderPlaceDate;
    }

    public void setOrderPlaceDate(String orderPlaceDate) {
        this.orderPlaceDate = orderPlaceDate;
    }

    public String getOrderPlaceTime() {
        return orderPlaceTime;
    }

    public void setOrderPlaceTime(String orderPlaceTime) {
        this.orderPlaceTime = orderPlaceTime;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPaymetType() {
        return paymetType;
    }

    public void setPaymetType(String paymetType) {
        this.paymetType = paymetType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
