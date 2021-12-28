package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterFavouriteFoodRecy;
import com.freshnin.userapplication.callbacks.AdapterFavouriteFoodRecyCallBacks;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelFavouriteFood;
import com.freshnin.userapplication.viewmodel.ViewModelMyCartItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityFavouriteFood extends AppCompatActivity implements AdapterFavouriteFoodRecyCallBacks{

    private Toolbar toolbar;
    private RecyclerView favouriteFoodRecy;
    private AdapterFavouriteFoodRecy adapterFavouriteFoodRecy;
    private List<ModelRegularItem> favouriteFoodList;

    private ViewModelFavouriteFood viewModelFavouriteFood;
    private ViewModelMyCartItem viewModelMyCartItem;

    private Dialog dialogLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_food);

        init();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        favouriteFoodRecy.setLayoutManager(new GridLayoutManager(this,2));
        favouriteFoodRecy.setAdapter(adapterFavouriteFoodRecy);
    }

    @Override
    protected void onResume() {
        dialogLoading.show();
        super.onResume();
        viewModelFavouriteFood.getAllFavouriteFood().observe(this, new Observer<List<ModelRegularItem>>() {
            @Override
            public void onChanged(List<ModelRegularItem> modelRegularItems) {
                favouriteFoodList.clear();
                favouriteFoodList.addAll(modelRegularItems);
                adapterFavouriteFoodRecy.notifyDataSetChanged();

                dialogLoading.dismiss();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_activity_food_item_list,menu);
        return true;
    }


    @Override
    public void onUnFavouriteClicked(ModelRegularItem regularItem, int position) {
        viewModelFavouriteFood.deleteFavouriteFoodById(regularItem.getId());
        viewModelFavouriteFood.getAllFavouriteFood();
        Toast.makeText(this, "item deleted from favourite", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClicked(int index) {
        Intent intent=new Intent(this,ActivityFoodItemDetails.class);
        intent.putExtra("parcel",favouriteFoodList.get(index));
        startActivity(intent);
    }

    @Override
    public void onAddToCartClicked(int index) {
        viewModelMyCartItem.insertNewMyCartItem(
                new ModelMyCartItem(
                        favouriteFoodList.get(index).getProductName(),
                        favouriteFoodList.get(index).getProductUnitPrice(),
                        1+"",
                        favouriteFoodList.get(index).getProductId()
                )
        );
        Toast.makeText(this, "added to cart", Toast.LENGTH_SHORT).show();
    }

    private void init() {
        toolbar=findViewById(R.id.aff_toolbar);
        setSupportActionBar(toolbar);
        favouriteFoodList=new ArrayList<>();

        favouriteFoodRecy=findViewById(R.id.aff_favourite_food_recy);
        adapterFavouriteFoodRecy =new AdapterFavouriteFoodRecy(favouriteFoodList, ActivityFavouriteFood.this, (AdapterFavouriteFoodRecyCallBacks) ActivityFavouriteFood.this);

        viewModelFavouriteFood=new ViewModelProvider(this).get(ViewModelFavouriteFood.class);
        viewModelMyCartItem=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelMyCartItem.class);

        dialogLoading= Utils.setupLoadingDialog(this);
    }
}