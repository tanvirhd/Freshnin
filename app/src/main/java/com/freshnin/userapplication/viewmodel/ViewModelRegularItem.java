package com.freshnin.userapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelCreateNewRegularOrder;
import com.freshnin.userapplication.model.ModelOnGoingOrder;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.model.ModelResponse;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.repository.RepositoryRegularOrder;

import java.util.List;

public class ViewModelRegularItem extends AndroidViewModel {

    RepositoryRegularOrder repositoryRegularOrder;
    public ViewModelRegularItem(@NonNull Application application) {
        super(application);
        repositoryRegularOrder=new RepositoryRegularOrder();
    }

    public LiveData<List<ModelRegularItem>> getAllItem(){
        return repositoryRegularOrder.getAllItem();
    }

    public LiveData<List<ModelRegularItem>> getAllItemsByCategory(ModelRegularItem modelRegularItem){
        return repositoryRegularOrder.getAllItemsByCategory(modelRegularItem);
    }

    public LiveData<ModelResponse> createNewRegularOrder(ModelCreateNewRegularOrder newRegularOrder){
        return repositoryRegularOrder.createNewRegularOrder(newRegularOrder);
    }

    public LiveData<List<ModelOnGoingOrder>> getOngoingOrderInformationByUser(ModelUser modelUser){
        return repositoryRegularOrder.getOngoingOrderInformationByUser(modelUser);
    }
}
