package com.freshnin.userapplication.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.freshnin.userapplication.model.ModelMyCartItem;

import java.util.List;

@Dao
public interface MyCartItemDao {

    @Insert
    void insertNewItemInMyCart(ModelMyCartItem myCartItem);

    @Query("delete from myCartItems_table where id=:myCartItemID")
    void deleteMyCartItemByID(int myCartItemID);

    @Query("select * from myCartItems_table")
    LiveData<List<ModelMyCartItem>> getAllMyCartItem();

    @Query("update myCartItems_table set foodName=:foodName, foodPrice=:foodPrice, foodQuantity=:foodQuantity,foodId=:foodId where id=:id")
    void updateMyCartItem(int id, String foodName, String foodPrice, String foodQuantity,String foodId);

    @Query("delete from myCartItems_table")
    void deleteAllItemFromMyCart();
}
