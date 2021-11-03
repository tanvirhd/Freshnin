package com.freshnin.userapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelUser {

    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("userPhoneNumber")
    @Expose
    private String userPhoneNumber;

    @SerializedName("userPassword")
    @Expose
    private String userPassWord;

    @SerializedName("userPhotoUrl")
    @Expose
    private String userPhotoUrl;

    public ModelUser(String userName, String userPhoneNumber, String userPassWord, String userPhotoUrl) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userPassWord = userPassWord;
        this.userPhotoUrl = userPhotoUrl;
    }

    public ModelUser(String userPhoneNumber, String userPassWord) {
        this.userPhoneNumber = userPhoneNumber;
        this.userPassWord = userPassWord;
    }

    public ModelUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }
}
