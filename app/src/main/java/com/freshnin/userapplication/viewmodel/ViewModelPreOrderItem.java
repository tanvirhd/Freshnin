package com.freshnin.userapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelCreateNewPreOrder;
import com.freshnin.userapplication.model.ModelOngoingPreOrder;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.model.ModelResponse;
import com.freshnin.userapplication.model.ModelUser;
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

    public LiveData<ModelResponse> createNewPreOrder(ModelCreateNewPreOrder order){
        return repositoryPreOrderItem.createNewPreOrder(order);
    }

    public LiveData<List<ModelOngoingPreOrder>> getOngoingPreOrderInformationByUser(ModelUser modelUser){
        return repositoryPreOrderItem.getOngoingPreOrderInformationByUser(modelUser);
    }
}
