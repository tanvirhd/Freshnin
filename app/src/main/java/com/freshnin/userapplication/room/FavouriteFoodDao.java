package com.freshnin.userapplication.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelRegularItem;

import java.util.List;

@Dao
public interface FavouriteFoodDao {

    @Insert
    void insertFavouriteFood(ModelRegularItem regularItem);

    @Query("delete from myCartItem_table where id=:favouriteFoodId")
    void deleteFavouriteFoodById(int favouriteFoodId);

    @Query("select * from myCartItem_table")
    LiveData<List<ModelRegularItem>> getAllFavouriteFood();

}
