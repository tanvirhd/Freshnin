package com.freshnin.userapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.repository.RepositoryFavouriteFood;

import java.util.List;

public class ViewModelFavouriteFood extends AndroidViewModel {

    private RepositoryFavouriteFood repository;

    public ViewModelFavouriteFood(@NonNull Application application) {
        super(application);
        repository=new RepositoryFavouriteFood(application);
    }

    public void insertFavouriteFood(ModelFoodItem foodItem){
        repository.insertFavouriteFood(foodItem);
    }

    public void deleteFavouriteFoodById(int id){
        repository.deleteFavouriteFoodById(id);
    }

    public LiveData<List<ModelFoodItem>> getAllFavouriteFood(){
        return repository.getAllFavouriteFood();
    }
}
