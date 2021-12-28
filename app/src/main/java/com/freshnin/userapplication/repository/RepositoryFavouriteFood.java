package com.freshnin.userapplication.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.room.FavouriteFoodDao;
import com.freshnin.userapplication.room.FreshninDatabase;

import java.util.List;

public class RepositoryFavouriteFood {

    private FavouriteFoodDao favouriteFoodDao;

    public RepositoryFavouriteFood(Application application){
        FreshninDatabase db=FreshninDatabase.getDb(application);
        favouriteFoodDao=db.getFavouriteFoodDao();
    }

    public void insertFavouriteFood(ModelRegularItem regularItem){
        FreshninDatabase.databaseWriteExecutor.execute(()->favouriteFoodDao.insertFavouriteFood(regularItem));
    }

    public void deleteFavouriteFoodById(int favouriteFoodId){
        FreshninDatabase.databaseWriteExecutor.execute(()->favouriteFoodDao.deleteFavouriteFoodById(favouriteFoodId));
    }

    public LiveData<List<ModelRegularItem>> getAllFavouriteFood(){
        return favouriteFoodDao.getAllFavouriteFood();
    }
}
