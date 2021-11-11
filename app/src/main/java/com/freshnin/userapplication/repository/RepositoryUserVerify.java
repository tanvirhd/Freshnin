package com.freshnin.userapplication.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.model.ModelUserVerify;
import com.freshnin.userapplication.network.ApiClient;
import com.freshnin.userapplication.network.ApiInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepositoryUserVerify {

    private static final String TAG = "RepositoryUserVerify";
    private ApiInterface apiInterface;

    public RepositoryUserVerify() {
        apiInterface= ApiClient.getApiInterface();
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
