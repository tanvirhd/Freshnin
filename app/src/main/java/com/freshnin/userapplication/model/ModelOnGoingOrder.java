package com.freshnin.userapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelOnGoingOrder implements Parcelable {

    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("itemIds")
    @Expose
    private String itemIds;
    @SerializedName("totalBill")
    @Expose
    private String totalBill;
    @SerializedName("deliveryCharge")
    @Expose
    private String deliveryCharge;
    @SerializedName("deliveryAddress")
    @Expose
    private String deliveryAddress;
    @SerializedName("inTownDelivery")
    @Expose
    private String inTownDelivery;
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
    private String orderStatus;
    @SerializedName("items")
    @Expose
    private List<ModelRegularItem> items;

    public ModelOnGoingOrder(String orderId, String userId, String itemIds, String totalBill,
                             String deliveryCharge, String deliveryAddress,
                             String inTownDelivery, String orderPlaceDate,
                             String orderPlaceTime, String contactNumber,
                             String paymetType, String orderStatus,
                             List<ModelRegularItem> items) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemIds = itemIds;
        this.totalBill = totalBill;
        this.deliveryCharge = deliveryCharge;
        this.deliveryAddress = deliveryAddress;
        this.inTownDelivery = inTownDelivery;
        this.orderPlaceDate = orderPlaceDate;
        this.orderPlaceTime = orderPlaceTime;
        this.contactNumber = contactNumber;
        this.paymetType = paymetType;
        this.orderStatus = orderStatus;
        this.items = items;
    }

    public ModelOnGoingOrder() {

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

    public String getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(String totalBill) {
        this.totalBill = totalBill;
    }

    public String getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(String deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getInTownDelivery() {
        return inTownDelivery;
    }

    public void setInTownDelivery(String inTownDelivery) {
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ModelRegularItem> getItems() {
        return items;
    }

    public void setItems(List<ModelRegularItem> items) {
        this.items = items;
    }



    //===================================

    protected ModelOnGoingOrder(Parcel in) {
        orderId = in.readString();
        userId = in.readString();
        itemIds = in.readString();
        totalBill = in.readString();
        deliveryCharge = in.readString();
        deliveryAddress = in.readString();
        inTownDelivery = in.readString();
        orderPlaceDate = in.readString();
        orderPlaceTime = in.readString();
        contactNumber = in.readString();
        paymetType = in.readString();
        orderStatus = in.readString();
        items = in.createTypedArrayList(ModelRegularItem.CREATOR);
    }

    public static final Creator<ModelOnGoingOrder> CREATOR = new Creator<ModelOnGoingOrder>() {
        @Override
        public ModelOnGoingOrder createFromParcel(Parcel in) {
            return new ModelOnGoingOrder(in);
        }

        @Override
        public ModelOnGoingOrder[] newArray(int size) {
            return new ModelOnGoingOrder[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orderId);
        dest.writeString(userId);
        dest.writeString(itemIds);
        dest.writeString(totalBill);
        dest.writeString(deliveryCharge);
        dest.writeString(deliveryAddress);
        dest.writeString(inTownDelivery);
        dest.writeString(orderPlaceDate);
        dest.writeString(orderPlaceTime);
        dest.writeString(contactNumber);
        dest.writeString(paymetType);
        dest.writeString(orderStatus);
        dest.writeTypedList(items);
    }
}
