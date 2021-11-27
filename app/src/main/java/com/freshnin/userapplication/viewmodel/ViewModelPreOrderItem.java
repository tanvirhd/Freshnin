package com.freshnin.userapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.repository.RepositoryPreOrderItem;

import java.util.List;

public class ViewModelPreOrderItem extends AndroidViewModel {

    RepositoryPreOrderItem repositoryPreOrderItem;

    public ViewModelPreOrderItem(@NonNull Application application) {
        super(application);
        repositoryPreOrderItem=new RepositoryPreOrderItem();
    }

    public LiveData<List<ModelPreOrderItem>> getAllActivePreOrderSession(){
        return repositoryPreOrderItem.getAllActivePreOrderSession();
    }
}
