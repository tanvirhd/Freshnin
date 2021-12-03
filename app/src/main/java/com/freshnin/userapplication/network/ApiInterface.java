package com.freshnin.userapplication.network;

import com.freshnin.userapplication.model.ModelCreateNewPreOrder;
import com.freshnin.userapplication.model.ModelCreateNewRegularOrder;
import com.freshnin.userapplication.model.ModelLogIn;
import com.freshnin.userapplication.model.ModelNewUserRegistration;
import com.freshnin.userapplication.model.ModelOngoingOrder;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.model.ModelResponse;
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

    @POST("createNewPreOrder.php")
    Observable<ModelResponse> createNewPreOrder(@Body ModelCreateNewPreOrder order);

    @POST("getOngoingPreOrderInformationByUser.php")
    Observable<List<ModelOngoingOrder>> getOngoingPreOrderInformationByUser(@Body ModelUser modelUser);


    // Regular order related
    @POST("getAllItem.php")
    Observable<List<ModelRegularItem>> getAllItem();

    @POST("getAllItemByCategory.php")
    Observable<List<ModelRegularItem>> getAllItemsByCategory(@Body ModelRegularItem modelRegularItem);

    @POST ("createNewRegularOrder.php")
    Observable<ModelResponse> createNewRegularOrder(@Body ModelCreateNewRegularOrder modelCreateNewRegularOrder);
}
