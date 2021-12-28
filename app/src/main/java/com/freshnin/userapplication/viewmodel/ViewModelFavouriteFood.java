package com.freshnin.userapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.repository.RepositoryFavouriteFood;

import java.util.List;

public class ViewModelFavouriteFood extends AndroidViewModel {

    private RepositoryFavouriteFood repository;

    public ViewModelFavouriteFood(@NonNull Application application) {
        super(application);
        repository=new RepositoryFavouriteFood(application);
    }

    public void insertFavouriteFood(ModelRegularItem regularItem){
        repository.insertFavouriteFood(regularItem);
    }

    public void deleteFavouriteFoodById(int id){
        repository.deleteFavouriteFoodById(id);
    }

    public LiveData<List<ModelRegularItem>> getAllFavouriteFood(){
        return repository.getAllFavouriteFood();
    }
}
