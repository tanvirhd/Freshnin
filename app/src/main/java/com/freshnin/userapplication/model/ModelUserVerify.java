package com.freshnin.userapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelUserVerify {

    @SerializedName("newUser")
    @Expose
    boolean isNewUser;

    @SerializedName("status")
    @Expose
    int statusCode;

    public ModelUserVerify(boolean isNewUser, int statusCode) {
        this.isNewUser = isNewUser;
        this.statusCode = statusCode;
    }

    public boolean isNewUser() {
        return isNewUser;
    }

    public void setNewUser(boolean newUser) {
        isNewUser = newUser;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
