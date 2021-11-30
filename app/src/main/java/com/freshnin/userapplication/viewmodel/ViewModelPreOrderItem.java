package com.freshnin.userapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelCreateNewPreOrder;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.repository.RepositoryPreOrderItem;

import java.util.List;

import retrofit2.http.Body;

public class ViewModelPreOrderItem extends AndroidViewModel {

    RepositoryPreOrderItem repositoryPreOrderItem;

    public ViewModelPreOrderItem(@NonNull Application application) {
        super(application);
        repositoryPreOrderItem=new RepositoryPreOrderItem();
    }

    public LiveData<List<ModelPreOrderItem>> getAllActivePreOrderSession(){
        return repositoryPreOrderItem.getAllActivePreOrderSession();
    }

    public LiveData<List<ModelCreateNewPreOrder>> createNewPreOrder(ModelUser modelUser){
        return repositoryPreOrderItem.createNewPreOrder(modelUser);
    }
}
