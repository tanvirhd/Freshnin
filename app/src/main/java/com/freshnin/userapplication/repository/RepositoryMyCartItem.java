package com.freshnin.userapplication.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.room.MyCartItemDao;
import com.freshnin.userapplication.room.MyCartItemDatabase;

import java.util.List;

public class RepositoryMyCartItem {

    private MyCartItemDao myCartItemDao;

    public RepositoryMyCartItem(Application application){
        MyCartItemDatabase db=MyCartItemDatabase.getDb(application);
        myCartItemDao=db.getMyCartItemDao();
    }

    public void insertNewMyCartItem(ModelMyCartItem myCartItem){
        MyCartItemDatabase.databaseWriteExecutor.execute(()->myCartItemDao.insertNewItemInMyCart(myCartItem));
    }

    public void deleteMyCartItemById(int myCartItemId){
        MyCartItemDatabase.databaseWriteExecutor.execute(()->myCartItemDao.deleteMyCartItemByID(myCartItemId));
    }

    public LiveData<List<ModelMyCartItem>> getAllMyCartItem(){
        return myCartItemDao.getAllMyCartItem();
    }

    public void updateMyCartItem(ModelMyCartItem myCartItem){
        MyCartItemDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                myCartItemDao.updateMyCartItem(
                        myCartItem.id,
                        myCartItem.getProductName(),
                        myCartItem.getProductPrice(),
                        myCartItem.getProductQuantity()
                );
            }
        });
    }
}
