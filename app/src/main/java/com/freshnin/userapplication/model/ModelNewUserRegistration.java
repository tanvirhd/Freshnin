package com.freshnin.userapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelNewUserRegistration {

    @SerializedName("registrationSuccessful")
    @Expose
    boolean isRegistrationSuccess;

    @SerializedName("statusCode")
    @Expose
    int statusCode;

    public ModelNewUserRegistration(boolean isRegistrationSuccess, int statusCode) {
        this.isRegistrationSuccess = isRegistrationSuccess;
        this.statusCode = statusCode;
    }

    public boolean isRegistrationSuccess() {
        return isRegistrationSuccess;
    }

    public void setRegistrationSuccess(boolean registrationSuccess) {
        isRegistrationSuccess = registrationSuccess;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
