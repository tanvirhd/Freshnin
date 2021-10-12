package com.freshnin.userapplication.model;

public class ModelFoodItem {

    private String foodName;
    private String foodPrice;
    private String foodWeight;

    private boolean isFavourite;

    private int foodImage;


    public ModelFoodItem(String foodName, String foodPrice, String foodWeight, boolean isFavourite, int foodImage) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodWeight = foodWeight;
        this.isFavourite = isFavourite;
        this.foodImage = foodImage;
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
}
