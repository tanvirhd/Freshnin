package com.freshnin.userapplication.model;

public class ModelOrder {

    private String orderId;
    private String orderedFoodName;
    private String orderedFoodQuantity;

    public ModelOrder(String orderId) {
        this.orderId = orderId;
    }

    public ModelOrder(String orderedFoodName, String orderedFoodQuantity) {
        this.orderedFoodName = orderedFoodName;
        this.orderedFoodQuantity = orderedFoodQuantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderedFoodName() {
        return orderedFoodName;
    }

    public void setOrderedFoodName(String orderedFoodName) {
        this.orderedFoodName = orderedFoodName;
    }

    public String getOrderedFoodQuantity() {
        return orderedFoodQuantity;
    }

    public void setOrderedFoodQuantity(String orderedFoodQuantity) {
        this.orderedFoodQuantity = orderedFoodQuantity;
    }
}
