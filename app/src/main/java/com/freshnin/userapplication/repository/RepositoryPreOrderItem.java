package com.freshnin.userapplication.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.freshnin.userapplication.model.ModelCreateNewPreOrder;
import com.freshnin.userapplication.model.ModelOngoingOrder;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.model.ModelResponse;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.network.ApiClient;
import com.freshnin.userapplication.network.ApiInterface;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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

    public LiveData<ModelResponse> createNewPreOrder(ModelCreateNewPreOrder order){
        MutableLiveData<ModelResponse> result=new MutableLiveData<>();

        apiInterface.createNewPreOrder(order).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelResponse>() {
                    @Override
                    public void accept(ModelResponse response) throws Exception {
                        if(response != null){
                            result.postValue(response);
                        }else{
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "createNewPreOrder: error" + throwable.getMessage());
                    }
                });
        return result;
    }



    public LiveData<List<ModelOngoingOrder>> getOngoingPreOrderInformationByUser(ModelUser modelUser){
        MutableLiveData<List<ModelOngoingOrder>> result =new MutableLiveData<>();

        apiInterface.getOngoingPreOrderInformationByUser(modelUser).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelOngoingOrder>>() {
                    @Override
                    public void accept(List<ModelOngoingOrder> modelOngoingOrders) throws Exception {
                        if(modelOngoingOrders!=null){
                            result.postValue(modelOngoingOrders);
                        }else{
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        result.postValue(null);
                        Log.d(TAG, "getOngoingPreOrderInformationByUser: error"+throwable.getMessage());
                    }
                });
        return result;
    }


}