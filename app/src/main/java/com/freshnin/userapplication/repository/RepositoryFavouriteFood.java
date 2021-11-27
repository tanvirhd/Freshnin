package com.freshnin.userapplication.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.room.FavouriteFoodDao;
import com.freshnin.userapplication.room.FreshninDatabase;

import java.util.List;

public class RepositoryFavouriteFood {

    private FavouriteFoodDao favouriteFoodDao;

    public RepositoryFavouriteFood(Application application){
        FreshninDatabase db=FreshninDatabase.getDb(application);
        favouriteFoodDao=db.getFavouriteFoodDao();
    }

    public void insertFavouriteFood(ModelFoodItem foodItem){
        FreshninDatabase.databaseWriteExecutor.execute(()->favouriteFoodDao.insertFavouriteFood(foodItem));
    }

    public void deleteFavouriteFoodById(int favouriteFoodId){
        FreshninDatabase.databaseWriteExecutor.execute(()->favouriteFoodDao.deleteFavouriteFoodById(favouriteFoodId));
    }

    public LiveData<List<ModelFoodItem>> getAllFavouriteFood(){
        return favouriteFoodDao.getAllFavouriteFood();
    }
}
