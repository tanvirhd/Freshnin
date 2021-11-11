package com.freshnin.userapplication.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.freshnin.userapplication.model.ModelNewUserRegistration;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.network.ApiClient;
import com.freshnin.userapplication.network.ApiInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepositoryNewUserRegistration {
    private static final String TAG = "RepositoryNewUserRegistration";
    private ApiInterface apiInterface;

    public RepositoryNewUserRegistration() {
        apiInterface= ApiClient.getApiInterface();
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
}
