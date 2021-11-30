package com.freshnin.userapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelCreateNewPreOrder implements Parcelable {

    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("itemId")
    @Expose
    private String itemId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("itemName")
    @Expose
    private String itemName;
    @SerializedName("orderPlaceDate")
    @Expose
    private String orderPlaceDate;
    @SerializedName("orderDeliveryDate")
    @Expose
    private String orderDeliveryDate;
    @SerializedName("orderQuantity")
    @Expose
    private Integer orderQuantity;
    @SerializedName("deliveryAddress")
    @Expose
    private String deliveryAddress;
    @SerializedName("inTownDelivery")
    @Expose
    private Integer inTownDelivery;
    @SerializedName("deliveryCharge")
    @Expose
    private Integer deliveryCharge;
    @SerializedName("totalBill")
    @Expose
    private Integer totalBill;
    @SerializedName("advancePyamentAmount")
    @Expose
    private Integer advancePyamentAmount;
    @SerializedName("advancePaymentStatus")
    @Expose
    private Integer advancePaymentStatus;
    @SerializedName("transactionId")
    @Expose
    private String transactionId;
    @SerializedName("paymnetMethod")
    @Expose
    private String paymnetMethod;
    @SerializedName("advancePaymentMethod")
    @Expose
    private String advancePaymentMethod;
    @SerializedName("orderStatus")
    @Expose
    private Integer orderStatus;


    public ModelCreateNewPreOrder(String orderId, String itemId, String userId,
                                  String itemName, String orderPlaceDate, String orderDeliveryDate,
                                  Integer orderQuantity, String deliveryAddress, Integer inTownDelivery,
                                  Integer deliveryCharge, Integer totalBill, Integer advancePyamentAmount,
                                  Integer advancePaymentStatus, String transactionId, String paymnetMethod,
                                  String advancePaymentMethod, Integer orderStatus) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.userId = userId;
        this.itemName = itemName;
        this.orderPlaceDate = orderPlaceDate;
        this.orderDeliveryDate = orderDeliveryDate;
        this.orderQuantity = orderQuantity;
        this.deliveryAddress = deliveryAddress;
        this.inTownDelivery = inTownDelivery;
        this.deliveryCharge = deliveryCharge;
        this.totalBill = totalBill;
        this.advancePyamentAmount = advancePyamentAmount;
        this.advancePaymentStatus = advancePaymentStatus;
        this.transactionId = transactionId;
        this.paymnetMethod = paymnetMethod;
        this.advancePaymentMethod = advancePaymentMethod;
        this.orderStatus = orderStatus;
    }

    public ModelCreateNewPreOrder() {

    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOrderPlaceDate() {
        return orderPlaceDate;
    }

    public void setOrderPlaceDate(String orderPlaceDate) {
        this.orderPlaceDate = orderPlaceDate;
    }

    public String getOrderDeliveryDate() {
        return orderDeliveryDate;
    }

    public void setOrderDeliveryDate(String orderDeliveryDate) {
        this.orderDeliveryDate = orderDeliveryDate;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
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

    public Integer getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Integer deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public Integer getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Integer totalBill) {
        this.totalBill = totalBill;
    }

    public Integer getAdvancePyamentAmount() {
        return advancePyamentAmount;
    }

    public void setAdvancePyamentAmount(Integer advancePyamentAmount) {
        this.advancePyamentAmount = advancePyamentAmount;
    }

    public Integer getAdvancePaymentStatus() {
        return advancePaymentStatus;
    }

    public void setAdvancePaymentStatus(Integer advancePaymentStatus) {
        this.advancePaymentStatus = advancePaymentStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymnetMethod() {
        return paymnetMethod;
    }

    public void setPaymnetMethod(String paymnetMethod) {
        this.paymnetMethod = paymnetMethod;
    }

    public String getAdvancePaymentMethod() {
        return advancePaymentMethod;
    }

    public void setAdvancePaymentMethod(String advancePaymentMethod) {
        this.advancePaymentMethod = advancePaymentMethod;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }





    //=================================================


    protected ModelCreateNewPreOrder(Parcel in) {
        orderId = in.readString();
        itemId = in.readString();
        userId = in.readString();
        itemName = in.readString();
        orderPlaceDate = in.readString();
        orderDeliveryDate = in.readString();
        if (in.readByte() == 0) {
            orderQuantity = null;
        } else {
            orderQuantity = in.readInt();
        }
        deliveryAddress = in.readString();
        if (in.readByte() == 0) {
            inTownDelivery = null;
        } else {
            inTownDelivery = in.readInt();
        }
        if (in.readByte() == 0) {
            deliveryCharge = null;
        } else {
            deliveryCharge = in.readInt();
        }
        if (in.readByte() == 0) {
            totalBill = null;
        } else {
            totalBill = in.readInt();
        }
        if (in.readByte() == 0) {
            advancePyamentAmount = null;
        } else {
            advancePyamentAmount = in.readInt();
        }
        if (in.readByte() == 0) {
            advancePaymentStatus = null;
        } else {
            advancePaymentStatus = in.readInt();
        }
        transactionId = in.readString();
        paymnetMethod = in.readString();
        advancePaymentMethod = in.readString();
        if (in.readByte() == 0) {
            orderStatus = null;
        } else {
            orderStatus = in.readInt();
        }
    }

    public static final Creator<ModelCreateNewPreOrder> CREATOR = new Creator<ModelCreateNewPreOrder>() {
        @Override
        public ModelCreateNewPreOrder createFromParcel(Parcel in) {
            return new ModelCreateNewPreOrder(in);
        }

        @Override
        public ModelCreateNewPreOrder[] newArray(int size) {
            return new ModelCreateNewPreOrder[size];
        }
    };






    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(orderId);
        dest.writeString(itemId);
        dest.writeString(userId);
        dest.writeString(itemName);
        dest.writeString(orderPlaceDate);
        dest.writeString(orderDeliveryDate);
        if (orderQuantity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(orderQuantity);
        }
        dest.writeString(deliveryAddress);
        if (inTownDelivery == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(inTownDelivery);
        }
        if (deliveryCharge == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(deliveryCharge);
        }
        if (totalBill == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalBill);
        }
        if (advancePyamentAmount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(advancePyamentAmount);
        }
        if (advancePaymentStatus == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(advancePaymentStatus);
        }
        dest.writeString(transactionId);
        dest.writeString(paymnetMethod);
        dest.writeString(advancePaymentMethod);
        if (orderStatus == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(orderStatus);
        }
    }


}
