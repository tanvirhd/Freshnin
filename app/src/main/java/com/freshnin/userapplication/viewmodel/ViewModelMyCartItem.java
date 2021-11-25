package com.freshnin.userapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.repository.RepositoryMyCartItem;

import java.util.List;

public class ViewModelMyCartItem extends AndroidViewModel {

    private RepositoryMyCartItem repository;

    public ViewModelMyCartItem(@NonNull Application application) {
        super(application);
        repository=new RepositoryMyCartItem(application);
    }
    public void insertNewMyCartItem(ModelMyCartItem myCartItem){
        repository.insertNewMyCartItem(myCartItem);
    }

    public void deleteMyCartItemById(int myCartItemId){
        repository.deleteMyCartItemById(myCartItemId);
    }

    public LiveData<List<ModelMyCartItem>> getAllMyCartItem(){
        return repository.getAllMyCartItem();
    }

    public void updateMycartItem(ModelMyCartItem myCartItem){
        repository.updateMyCartItem(myCartItem);
    }
}
