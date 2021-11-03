package com.freshnin.userapplication.network;

import com.freshnin.userapplication.model.ModelLogIn;
import com.freshnin.userapplication.model.ModelUser;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("localhost/login.php")
    Observable<ModelLogIn> checkValidLogIn(@Body ModelUser user);

}
