package com.freshnin.userapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "food_table")
public class ModelFoodItem {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "foodName")
    private String foodName;

    @ColumnInfo(name = "foodPrice")
    private String foodPrice;

    @ColumnInfo(name = "foodWeight")
    private String foodWeight;

    @ColumnInfo(name = "foodId")
    private String foodId;

    @ColumnInfo(name = "isFavourite")
    private boolean isFavourite;

    private int foodImage;

    private String quantityOfFood;


    // For favourite food
    public ModelFoodItem(String foodName, String foodPrice, String foodWeight, String foodId, boolean isFavourite, int foodImage) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodWeight = foodWeight;
        this.foodId = foodId;
        this.isFavourite = isFavourite;
        this.foodImage = foodImage;
    }

    @Ignore
    public ModelFoodItem(int id, String foodName, String foodPrice, String foodWeight, String foodId, boolean isFavourite, int foodImage, String quantityOfFood) {
        this.id = id;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodWeight = foodWeight;
        this.foodId = foodId;
        this.isFavourite = isFavourite;
        this.foodImage = foodImage;
        this.quantityOfFood = quantityOfFood;
    }

    @Ignore
    public ModelFoodItem(String foodName, String foodPrice, String foodWeight, boolean isFavourite, int foodImage) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodWeight = foodWeight;
        this.isFavourite = isFavourite;
        this.foodImage = foodImage;
    }

    // For Favourite Food List
    @Ignore
    public ModelFoodItem(String foodName, String foodPrice, String foodWeight, int foodImage) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodWeight = foodWeight;
        this.foodImage = foodImage;
    }
    // For check Out
    @Ignore
    public ModelFoodItem(String foodName, String foodPrice, String quantityOfFood) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantityOfFood = quantityOfFood;
    }

    // For Billing in check out && on going order Details
    @Ignore
    public ModelFoodItem(String foodName, String foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    // For on going order food list
    @Ignore
    public ModelFoodItem(String foodName, int foodImage, String quantityOfFood) {
        this.foodName = foodName;
        this.foodImage = foodImage;
        this.quantityOfFood = quantityOfFood;
    }

    @Ignore
    public ModelFoodItem(int foodImage) {
        this.foodImage = foodImage;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
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

    public String getFoodWeight() {
        return foodWeight;
    }

    public void setFoodWeight(String foodWeight) {
        this.foodWeight = foodWeight;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public String getQuantityOfFood() {
        return quantityOfFood;
    }

    public void setQuantityOfFood(String quantityOfFood) {
        this.quantityOfFood = quantityOfFood;
    }
}
