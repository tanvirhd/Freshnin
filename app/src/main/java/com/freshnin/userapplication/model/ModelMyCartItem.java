package com.freshnin.userapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "myCartItem_table")
public class ModelMyCartItem {

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
