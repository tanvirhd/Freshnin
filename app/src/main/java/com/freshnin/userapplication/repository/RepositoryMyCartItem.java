package com.freshnin.userapplication.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.room.FreshninDatabase;
import com.freshnin.userapplication.room.MyCartItemDao;

import java.util.List;

public class RepositoryMyCartItem {

    private MyCartItemDao myCartItemDao;

    public RepositoryMyCartItem(Application application){
        FreshninDatabase db= FreshninDatabase.getDb(application);
        myCartItemDao=db.getMyCartItemDao();
    }

    public void insertNewMyCartItem(ModelMyCartItem myCartItem){
        FreshninDatabase.databaseWriteExecutor.execute(()->myCartItemDao.insertNewItemInMyCart(myCartItem));
    }

    public void deleteMyCartItemById(int myCartItemId){
        FreshninDatabase.databaseWriteExecutor.execute(()->myCartItemDao.deleteMyCartItemByID(myCartItemId));
    }

    public LiveData<List<ModelMyCartItem>> getAllMyCartItem(){
        return myCartItemDao.getAllMyCartItem();
    }

    public void updateMyCartItem(ModelMyCartItem myCartItem){
        FreshninDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                myCartItemDao.updateMyCartItem(
                        myCartItem.id,
                        myCartItem.getFoodName(),
                        myCartItem.getFoodPrice(),
                        myCartItem.getFoodQuantity(),
                        myCartItem.getFoodId()
                );
            }
        });
    }

    public void deleteAllItemFromMyCart(){
        FreshninDatabase.databaseWriteExecutor.execute(()->myCartItemDao.deleteAllItemFromMyCart());
    }
}
