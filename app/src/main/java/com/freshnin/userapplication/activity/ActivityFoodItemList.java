package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterFoodItemListRecy;
import com.freshnin.userapplication.callbacks.AdapterDryFoodListRecyCallBacks;
import com.freshnin.userapplication.callbacks.AdapterFoodItemListRecycCallBacks;
import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelFavouriteFood;
import com.freshnin.userapplication.viewmodel.ViewModelMyCartItem;
import com.freshnin.userapplication.viewmodel.ViewModelRegularItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityFoodItemList extends AppCompatActivity implements AdapterFoodItemListRecycCallBacks{

    private static final String TAG = "ActivityFoodItemList";
    private List<ModelRegularItem> foodItems;
    private RecyclerView recyclerViewFoodItem;
    private AdapterFoodItemListRecy adapterFoodItemListRecy;
    private Toolbar toolbar;

    private ViewModelRegularItem viewModelRegularItem;

    private ModelRegularItem itemId;
    private ViewModelMyCartItem viewModelMyCartItem;

    private ViewModelFavouriteFood viewModelFavouriteFood;

    private Dialog dialogLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_list);

        init();


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getItemsByCategory();
        //getAllFavouriteItems();
    }



    private void getItemsByCategory(){
        dialogLoading.show();

        //LiveData<List<ModelRegularItem>> favouriteItemList = viewModelFavouriteFood.getAllFavouriteFood();

        viewModelRegularItem.getAllItemsByCategory(itemId).observe(this, new Observer<List<ModelRegularItem>>() {
            @Override
            public void onChanged(List<ModelRegularItem> modelRegularItems) {
                dialogLoading.show();
                if(modelRegularItems!=null){
                    foodItems.clear();
                    foodItems.addAll(modelRegularItems);
                    adapterFoodItemListRecy.notifyDataSetChanged();
                    dialogLoading.dismiss();
                }else{
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityFoodItemList.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

/*    private void getAllFavouriteItems() {
        viewModelFavouriteFood.getAllFavouriteFood().observe(this, new Observer<List<ModelRegularItem>>() {
            @Override
            public void onChanged(List<ModelRegularItem> modelRegularItems) {
                // Todo need to work
            }
        });
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_activity_food_item_list,menu);
        return true;
    }

    void init(){
        Log.d(TAG, "init: called");
        foodItems=new ArrayList<>();

        toolbar=findViewById(R.id.afil_toolbar_activity_food_item_list);

        recyclerViewFoodItem=findViewById(R.id.afil_foodItemRecy);
        recyclerViewFoodItem.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adapterFoodItemListRecy=new AdapterFoodItemListRecy(foodItems,ActivityFoodItemList.this, (AdapterFoodItemListRecycCallBacks) ActivityFoodItemList.this);
        recyclerViewFoodItem.setAdapter(adapterFoodItemListRecy);

        viewModelRegularItem= new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelRegularItem.class);
        viewModelMyCartItem=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelMyCartItem.class);
        viewModelFavouriteFood=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelFavouriteFood.class);


        dialogLoading= Utils.setupLoadingDialog(this);
        itemId=new ModelRegularItem(getIntent().getExtras().getString("foodId"));
        Log.d(TAG, "init: "+itemId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(itemId.getProductCategory());
    }

    @Override
    public void onItemClick(int index) {
        Intent intent=new Intent(ActivityFoodItemList.this,ActivityFoodItemDetails.class);
        intent.putExtra("parcel",foodItems.get(index));
        startActivity(intent);
    }

    @Override
    public void onAddToCartClicked(int index) {
        viewModelMyCartItem.insertNewMyCartItem(
                new ModelMyCartItem(
                        foodItems.get(index).getProductName(),
                        foodItems.get(index).getProductUnitPrice(),
                        1+"",
                        foodItems.get(index).getProductId()
                )
        );
        Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onFavouriteClicked(int position) {
        viewModelFavouriteFood.insertFavouriteFood(
                new ModelRegularItem(
                        foodItems.get(position).getProductId(),
                        foodItems.get(position).getProductName(),
                        foodItems.get(position).getProductDes(),
                        foodItems.get(position).getProductPicUrl(),
                        foodItems.get(position).getProductUnitPrice(),
                        foodItems.get(position).getProductUnitWeight(),
                        foodItems.get(position).getInStock(),
                        foodItems.get(position).getProductCategory()
                )
        );
        Toast.makeText(this, "Item Added to favourite", Toast.LENGTH_SHORT).show();
    }

}