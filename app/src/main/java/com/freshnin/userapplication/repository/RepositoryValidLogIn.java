package com.freshnin.userapplication.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.freshnin.userapplication.model.ModelLogIn;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.network.ApiClient;
import com.freshnin.userapplication.network.ApiInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RepositoryValidLogIn {

    private ApiInterface apiInterface;

    public RepositoryValidLogIn() {
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
                        result.postValue(null);
                    }
                });
        return result;
    }
}
