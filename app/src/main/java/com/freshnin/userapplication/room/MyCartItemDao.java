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

    @Query("delete from myCartItem_table where id=:myCartItemID")
    void deleteMyCartItemByID(int myCartItemID);

    @Query("select * from myCartItem_table")
    LiveData<List<ModelMyCartItem>> getAllMyCartItem();

    @Query("update myCartItem_table set productName=:productName, productPrice=:productPrice, productQuantity=:productQuantity where id=:id")
    void updateMyCartItem(int id, String productName, String productPrice, String productQuantity);
}
