package com.freshnin.userapplication.room;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.freshnin.userapplication.model.ModelMyCartItem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ModelMyCartItem.class}, version = 1)
public abstract class MyCartItemDatabase extends RoomDatabase {

    public abstract MyCartItemDao getMyCartItemDao();

    public static MyCartItemDatabase dbInstance;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized MyCartItemDatabase getDb(Context context){

        if(dbInstance==null){
            dbInstance= Room.databaseBuilder(context.getApplicationContext(),MyCartItemDatabase.class,"myCartItem_database")
                    .fallbackToDestructiveMigration()
                    /*.addCallback(roomDataBaseCallBack)*/
                    .build();
        }
        return dbInstance;
    }

    /*private static RoomDatabase.Callback roomDataBaseCallBack=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(()->{
                MyCartItemDao myCartItemDao= dbInstance.getMyCartItemDao();


                myCartItemDao.insertNewItemInMyCart(new ModelMyCartItem(
                        1,
                        "Bogurar Doi",
                        "230 tk",
                        "3"
                ));
                myCartItemDao.insertNewItemInMyCart(new ModelMyCartItem(
                        2,
                        "Bogurar Khirsha",
                        "250 tk",
                        "1"
                ));
                myCartItemDao.insertNewItemInMyCart(new ModelMyCartItem(
                        3,
                        "Bogurar Chomchom",
                        "500 tk",
                        "6"
                ));
            });
        }
    };*/

}
