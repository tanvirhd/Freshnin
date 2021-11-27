package com.freshnin.userapplication.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.freshnin.userapplication.model.ModelFoodItem;

import java.util.List;

@Dao
public interface FavouriteFoodDao {

    @Insert
    void insertFavouriteFood(ModelFoodItem foodItem);

    @Query("delete from food_table where id=:favouriteFoodId")
    void deleteFavouriteFoodById(int favouriteFoodId);

    @Query("select * from food_table")
    LiveData<List<ModelFoodItem>> getAllFavouriteFood();

}
