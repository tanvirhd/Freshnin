package com.freshnin.userapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelPreOrderItem implements Parcelable {

    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productShortDes")
    @Expose
    private String productShortDes;
    @SerializedName("productPicUrl")
    @Expose
    private String productPicUrl;
    @SerializedName("productUnitPrice")
    @Expose
    private String productUnitPrice;
    @SerializedName("productUnitWeight")
    @Expose
    private String productUnitWeight;
    @SerializedName("sessionStartDate")
    @Expose
    private String sessionStartDate;
    @SerializedName("sessionEndDate")
    @Expose
    private String sessionEndDate;


    @SerializedName("response")
    @Expose
    private Integer response;
    @SerializedName("status")
    @Expose
    private String status;

    public ModelPreOrderItem(String productId, String productName, String productShortDes, String productPicUrl, String productUnitPrice, String productUnitWeight, String sessionStartDate, String sessionEndDate, Integer response, String status) {
        this.productId = productId;
        this.productName = productName;
        this.productShortDes = productShortDes;
        this.productPicUrl = productPicUrl;
        this.productUnitPrice = productUnitPrice;
        this.productUnitWeight = productUnitWeight;
        this.sessionStartDate = sessionStartDate;
        this.sessionEndDate = sessionEndDate;
        this.response = response;
        this.status = status;
    }

    public ModelPreOrderItem() {

    }

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPreOrderProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductShortDes() {
        return productShortDes;
    }
    public void setProductShortDes(String productShortDes) {
        this.productShortDes = productShortDes;
    }

    public String getProductPicUrl() {
        return productPicUrl;
    }
    public void setProductPicUrl(String productPicUrl) {
        this.productPicUrl = productPicUrl;
    }

    public String getProductUnitPrice() {
        return productUnitPrice;
    }
    public void setProductUnitPrice(String productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public String getProductUnitWeight() {
        return productUnitWeight;
    }
    public void setProductUnitWeight(String productUnitWeight) {
        this.productUnitWeight = productUnitWeight;
    }

    public String getSessionStartDate() {
        return sessionStartDate;
    }
    public void setSessionStartDate(String sessionStartDate) {
        this.sessionStartDate = sessionStartDate;
    }

    public String getSessionEndDate() {
        return sessionEndDate;
    }
    public void setSessionEndDate(String sessionEndDate) {
        this.sessionEndDate = sessionEndDate;
    }

    public Integer getResponse() {
        return response;
    }
    public void setResponse(Integer response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    //========================================================

    protected ModelPreOrderItem(Parcel in) {
        productId = in.readString();
        productName = in.readString();
        productShortDes = in.readString();
        productPicUrl = in.readString();
        productUnitPrice = in.readString();
        productUnitWeight = in.readString();
        sessionStartDate = in.readString();
        sessionEndDate = in.readString();
        if (in.readByte() == 0) {
            response = null;
        } else {
            response = in.readInt();
        }
        status = in.readString();
    }

    public static final Creator<ModelPreOrderItem> CREATOR = new Creator<ModelPreOrderItem>() {
        @Override
        public ModelPreOrderItem createFromParcel(Parcel in) {
            return new ModelPreOrderItem(in);
        }

        @Override
        public ModelPreOrderItem[] newArray(int size) {
            return new ModelPreOrderItem[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productId);
        dest.writeString(productName);
        dest.writeString(productShortDes);
        dest.writeString(productPicUrl);
        dest.writeString(productUnitPrice);
        dest.writeString(productUnitWeight);
        dest.writeString(sessionStartDate);
        dest.writeString(sessionEndDate);
        if (response == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(response);
        }
        dest.writeString(status);
    }
}
