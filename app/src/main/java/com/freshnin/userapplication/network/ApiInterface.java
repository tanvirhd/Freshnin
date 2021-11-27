package com.freshnin.userapplication.network;

import com.freshnin.userapplication.model.ModelLogIn;
import com.freshnin.userapplication.model.ModelNewUserRegistration;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.model.ModelUserVerify;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    //user data related
    @POST("login.php")
    Observable<ModelLogIn> checkValidLogIn(@Body ModelUser user);

    @POST("userVerify.php")
    Observable<ModelUserVerify> checkUserValidation(@Body ModelUser user);

    @POST("newUserRegistration.php")
    Observable<ModelNewUserRegistration> newUserRegistration(@Body ModelUser user);


    // pre order item related
    @POST ("getPreorderActiveSession.php")
    Observable<List<ModelPreOrderItem>> getAllActivePreOrderSession();

}
