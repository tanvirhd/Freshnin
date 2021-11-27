package com.freshnin.userapplication.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.freshnin.userapplication.model.ModelLogIn;
import com.freshnin.userapplication.model.ModelNewUserRegistration;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.model.ModelUserVerify;
import com.freshnin.userapplication.network.ApiClient;
import com.freshnin.userapplication.network.ApiInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepositoryUser {
    private static final String TAG = "RepositoryUser";
    private ApiInterface apiInterface;

    public RepositoryUser() {
        apiInterface = ApiClient.getApiInterface();
    }


    public LiveData<ModelLogIn> checkValidLogIn(ModelUser user) {
        MutableLiveData<ModelLogIn> result = new MutableLiveData<>();

        apiInterface.checkValidLogIn(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelLogIn>() {
                    @Override
                    public void accept(ModelLogIn modelLogIn) throws Exception {
                        result.postValue(modelLogIn);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "accept: "+throwable.getMessage());
                        result.postValue(null);
                    }
                });
        return result;
    }

    public LiveData<ModelNewUserRegistration> newUserRegistration(ModelUser user){
        MutableLiveData<ModelNewUserRegistration> result=new MutableLiveData<>();

        apiInterface.newUserRegistration(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelNewUserRegistration>() {
                    @Override
                    public void accept(ModelNewUserRegistration modelNewUserRegistration) throws Exception {
                        result.postValue(modelNewUserRegistration);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "newUserRegistration: error"+throwable.getMessage());
                        result.postValue(null);
                    }
                });
        return result;
    }

    public LiveData<ModelUserVerify> checkUserValidation(ModelUser user){
        MutableLiveData<ModelUserVerify> result= new MutableLiveData<>();

        apiInterface.checkUserValidation(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelUserVerify>() {
                    @Override
                    public void accept(ModelUserVerify modelUserVerify) throws Exception {
                        result.postValue(modelUserVerify);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "checkUserValidation:error "+throwable.getMessage());
                        result.postValue(null);
                    }
                });
        return result;
    }
}
