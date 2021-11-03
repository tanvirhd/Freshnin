package com.freshnin.userapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelLogIn {

    @SerializedName("validation")
    @Expose
    boolean isValidUser;

    @SerializedName("status")
    @Expose
    int statusCode;

    public ModelLogIn(boolean isValidUser, int statusCode) {
        this.isValidUser = isValidUser;
        this.statusCode = statusCode;
    }

    public boolean isValidUser() {
        return isValidUser;
    }

    public void setValidUser(boolean validUser) {
        isValidUser = validUser;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
