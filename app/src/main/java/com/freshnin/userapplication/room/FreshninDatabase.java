package com.freshnin.userapplication.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.model.ModelRegularItem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ModelMyCartItem.class, ModelRegularItem.class}, version = 3,exportSchema = false)
public abstract class FreshninDatabase extends RoomDatabase {

    public abstract MyCartItemDao getMyCartItemDao();

    public abstract FavouriteFoodDao getFavouriteFoodDao();

    public static FreshninDatabase dbInstance;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized FreshninDatabase getDb(Context context){

        if(dbInstance==null){
            dbInstance= Room.databaseBuilder(context.getApplicationContext(), FreshninDatabase.class,"freshnin_database")
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
