package com.freshnin.userapplication.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.freshnin.userapplication.model.ModelCreateNewRegularOrder;
import com.freshnin.userapplication.model.ModelOnGoingOrder;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.model.ModelResponse;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.network.ApiClient;
import com.freshnin.userapplication.network.ApiInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepositoryRegularOrder {
    private static final String TAG = "RepositoryRegularOrder";

    private ApiInterface apiInterface;

    public RepositoryRegularOrder(){
        apiInterface= ApiClient.getApiInterface();
    }


    public LiveData<List<ModelRegularItem>> getAllItem(){
        MutableLiveData<List<ModelRegularItem>> result=new MutableLiveData<>();

        apiInterface.getAllItem().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelRegularItem>>() {
                    @Override
                    public void accept(List<ModelRegularItem> modelRegularItems) throws Exception {
                        if (modelRegularItems != null){
                            result.postValue(modelRegularItems);
                        }else{
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "getAllItem: error"+throwable.getMessage());
                        result.postValue(null);
                    }
                });
    return result;
    }

    public LiveData<List<ModelRegularItem>> getAllItemsByCategory(ModelRegularItem modelRegularItem){
        MutableLiveData<List<ModelRegularItem>> result= new MutableLiveData<>();

        apiInterface.getAllItemsByCategory(modelRegularItem).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelRegularItem>>() {
                    @Override
                    public void accept(List<ModelRegularItem> modelRegularItems) throws Exception {
                        if(modelRegularItems !=null){
                            result.postValue(modelRegularItems);
                        }else{
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "getAllItemsByCategory: error"+throwable.getMessage());
                        result.postValue(null);
                    }
                });
        return result;
    }

    public LiveData<ModelResponse> createNewRegularOrder(ModelCreateNewRegularOrder createNewRegularOrder){
        MutableLiveData<ModelResponse> result=  new MutableLiveData<>();

        apiInterface.createNewRegularOrder(createNewRegularOrder).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ModelResponse>() {
                    @Override
                    public void accept(ModelResponse modelResponse) throws Exception {
                        if(modelResponse !=null){
                            result.postValue(modelResponse);
                        }else{
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "createNewRegularOrder: error"+throwable.getMessage());
                        result.postValue(null);
                    }
                });
        return result;
    }


    public LiveData<List<ModelOnGoingOrder>> getOngoingOrderInformationByUser(ModelUser modelUser){
        MutableLiveData<List<ModelOnGoingOrder>> result= new MutableLiveData<>();

        apiInterface.getOngoingOrderInformationByUser(modelUser).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ModelOnGoingOrder>>() {
                    @Override
                    public void accept(List<ModelOnGoingOrder> modelOnGoingOrders) throws Exception {
                        if(modelOnGoingOrders!=null){
                            result.postValue(modelOnGoingOrders);
                        }else{
                            result.postValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "getOngoingOrderInformationByUser: error"+throwable.getMessage());
                        result.postValue(null);
                    }
                });
        return result;
    }

}
