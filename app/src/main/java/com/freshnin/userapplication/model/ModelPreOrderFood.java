package com.freshnin.userapplication.model;

public class ModelPreOrderFood {

    private String preOrderFoodName;
    private String orderGoingTillDay;

    private int preOrderFoodImage;

    public ModelPreOrderFood(String preOrderFoodName, String orderGoingTillDay, int preOrderFoodImage) {
        this.preOrderFoodName = preOrderFoodName;
        this.orderGoingTillDay = orderGoingTillDay;
        this.preOrderFoodImage = preOrderFoodImage;
    }

    public ModelPreOrderFood(int preOrderFoodImage) {
        this.preOrderFoodImage = preOrderFoodImage;
    }

    public String getPreOrderFoodName() {
        return preOrderFoodName;
    }

    public void setPreOrderFoodName(String preOrderFoodName) {
        this.preOrderFoodName = preOrderFoodName;
    }

    public String getOrderGoingTillDay() {
        return orderGoingTillDay;
    }

    public void setOrderGoingTillDay(String orderGoingTillDay) {
        this.orderGoingTillDay = orderGoingTillDay;
    }

    public int getPreOrderFoodImage() {
        return preOrderFoodImage;
    }

    public void setPreOrderFoodImage(int preOrderFoodImage) {
        this.preOrderFoodImage = preOrderFoodImage;
    }
}
