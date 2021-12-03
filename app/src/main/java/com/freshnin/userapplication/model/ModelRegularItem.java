package com.freshnin.userapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.stream.Stream;

@Entity(tableName = "myCartItem_table")
public class ModelRegularItem implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productDes")
    @Expose
    private String productDes;
    @SerializedName("productPicUrl")
    @Expose
    private String productPicUrl;
    @SerializedName("productUnitPrice")
    @Expose
    private String productUnitPrice;
    @SerializedName("productUnitWeight")
    @Expose
    private String productUnitWeight;
    @SerializedName("inStock")
    @Expose
    private String inStock;
    @SerializedName("productCategory")
    @Expose
    private String productCategory;

    public ModelRegularItem(String productId, String productName, String productDes, String productPicUrl,
                            String productUnitPrice, String productUnitWeight, String inStock, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDes = productDes;
        this.productPicUrl = productPicUrl;
        this.productUnitPrice = productUnitPrice;
        this.productUnitWeight = productUnitWeight;
        this.inStock = inStock;
        this.productCategory = productCategory;
    }

    public ModelRegularItem(int id, String productId, String productName, String productDes, String productPicUrl, String productUnitPrice, String productUnitWeight, String inStock, String productCategory) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productDes = productDes;
        this.productPicUrl = productPicUrl;
        this.productUnitPrice = productUnitPrice;
        this.productUnitWeight = productUnitWeight;
        this.inStock = inStock;
        this.productCategory = productCategory;
    }

    public ModelRegularItem() {
    }

    public ModelRegularItem(String productCategory) {
        this.productCategory = productCategory;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
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

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }


    //========================================


    protected ModelRegularItem(Parcel in) {
        productId = in.readString();
        productName = in.readString();
        productDes = in.readString();
        productPicUrl = in.readString();
        productUnitPrice = in.readString();
        productUnitWeight = in.readString();
        inStock = in.readString();
        productCategory = in.readString();
    }

    public static final Creator<ModelRegularItem> CREATOR = new Creator<ModelRegularItem>() {
        @Override
        public ModelRegularItem createFromParcel(Parcel in) {
            return new ModelRegularItem(in);
        }

        @Override
        public ModelRegularItem[] newArray(int size) {
            return new ModelRegularItem[size];
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
        dest.writeString(productDes);
        dest.writeString(productPicUrl);
        dest.writeString(productUnitPrice);
        dest.writeString(productUnitWeight);
        dest.writeString(inStock);
        dest.writeString(productCategory);
    }


}
