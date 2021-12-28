package com.freshnin.userapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "myCartItems_table")
public class ModelMyCartItem implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "foodName")
    private String foodName;

    @ColumnInfo(name = "foodPrice")
    private String foodPrice;

    @ColumnInfo(name = "foodQuantity")
    private String foodQuantity;

    @ColumnInfo(name = "foodId")
    private String foodId;

    @Ignore
    public ModelMyCartItem(int id, String foodName, String foodPrice, String foodQuantity, String foodId) {
        this.id = id;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;
        this.foodId = foodId;
    }


    public ModelMyCartItem(String foodName, String foodPrice, String foodQuantity, String foodId) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;
        this.foodId = foodId;
    }

    protected ModelMyCartItem(Parcel in) {
        id = in.readInt();
        foodName = in.readString();
        foodPrice = in.readString();
        foodQuantity = in.readString();
        foodId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(foodName);
        dest.writeString(foodPrice);
        dest.writeString(foodQuantity);
        dest.writeString(foodId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelMyCartItem> CREATOR = new Creator<ModelMyCartItem>() {
        @Override
        public ModelMyCartItem createFromParcel(Parcel in) {
            return new ModelMyCartItem(in);
        }

        @Override
        public ModelMyCartItem[] newArray(int size) {
            return new ModelMyCartItem[size];
        }
    };

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(String foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }
}
