package com.freshnin.userapplication.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.network.ApiClient;
import com.freshnin.userapplication.network.ApiInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public  class RepositoryPreOrderItem {
    private static final String TAG = "RepositoryPreOrderItem";
    private ApiInterface apiInterface;

    public RepositoryPreOrderItem() {
        apiInterface= ApiClient.getApiInterface();
    }

    public LiveData<List<ModelPreOrderItem>> getAllActivePreOrderSession(){
        MutableLiveData<List<ModelPreOrderItem>> result =new MutableLiveData<>();

        apiInterface.getAllActivePreOrderSession().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelPreOrderItem>>() {
                    @Override
                    public void accept(List<ModelPreOrderItem> modelPreOrderItems) throws Exception {
                        if(modelPreOrderItems != null){
                            result.postValue(modelPreOrderItems);
                        }else {
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "getAllActivePreOrderSession: error :"+throwable.getMessage());
                    }
                });

        return result;
    }
}