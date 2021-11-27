package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterFavouriteFoodRecy;
import com.freshnin.userapplication.callbacks.AdapterFavouriteFoodRecyCallBacks;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.viewmodel.ViewModelFavouriteFood;

import java.util.ArrayList;
import java.util.List;

public class ActivityFavouriteFood extends AppCompatActivity implements AdapterFavouriteFoodRecyCallBacks{

    private Toolbar toolbar;
    private RecyclerView favouriteFoodRecy;
    private AdapterFavouriteFoodRecy adapterFavouriteFoodRecy;
    private List<ModelFoodItem> favouriteFoodList;

    private ViewModelFavouriteFood viewModelFavouriteFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_food);

        init();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        super.onResume();
        viewModelFavouriteFood.getAllFavouriteFood().observe(this, new Observer<List<ModelFoodItem>>() {
            @Override
            public void onChanged(List<ModelFoodItem> modelFoodItems) {
                favouriteFoodList.clear();
                favouriteFoodList.addAll(modelFoodItems);
                adapterFavouriteFoodRecy.notifyDataSetChanged();
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
    public void onUnFavouriteClicked(ModelFoodItem modelFoodItem, int position) {
        viewModelFavouriteFood.deleteFavouriteFoodById(modelFoodItem.id);
        viewModelFavouriteFood.getAllFavouriteFood();
    }

    private void init() {
        toolbar=findViewById(R.id.aff_toolbar);
        setSupportActionBar(toolbar);
        favouriteFoodList=new ArrayList<>();

        favouriteFoodRecy=findViewById(R.id.aff_favourite_food_recy);
        adapterFavouriteFoodRecy =new AdapterFavouriteFoodRecy(favouriteFoodList, ActivityFavouriteFood.this, (AdapterFavouriteFoodRecyCallBacks) ActivityFavouriteFood.this);

        viewModelFavouriteFood=new ViewModelProvider(this).get(ViewModelFavouriteFood.class);
        viewModelFavouriteFood.insertFavouriteFood(new ModelFoodItem(
                "Bogurar Doi",
                "230 Tk",
                "300 gm",
                "f1",
                true,
                R.drawable.food_bogurar_doi
        ));

        viewModelFavouriteFood.insertFavouriteFood(new ModelFoodItem(
                "Bogurar Khirsha",
                "330 Tk",
                "300 gm",
                "f2",
                true,
                R.drawable.food_bogurar_khirsha
        ));

        viewModelFavouriteFood.insertFavouriteFood(new ModelFoodItem(
                "Bogurar Doi",
                "230 Tk",
                "300 gm",
                "f3",
                true,
                R.drawable.food_bogurar_doi
        ));
    }
}