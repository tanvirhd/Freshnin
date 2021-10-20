package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterFavouriteItemRecy;
import com.freshnin.userapplication.model.ModelFoodItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityFavouriteItem extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView favouriteFoodRecy;
    private AdapterFavouriteItemRecy adapterFavouriteItemRecy;
    private List<ModelFoodItem> favouriteFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_item);

        toolbar=findViewById(R.id.afi_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initList();

        favouriteFoodRecy=findViewById(R.id.afi_favourite_food_recy);
        favouriteFoodRecy.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        adapterFavouriteItemRecy=new AdapterFavouriteItemRecy(favouriteFoodList,ActivityFavouriteItem.this);
        favouriteFoodRecy.setAdapter(adapterFavouriteItemRecy);
    }

    private void initList() {
        favouriteFoodList=new ArrayList<>();

        favouriteFoodList.add(new ModelFoodItem(
                "Bogurar Doi",
                "230 Tk",
                "300 gm",
                R.drawable.food_bogurar_doi
        ));

        favouriteFoodList.add(new ModelFoodItem(
                "Bogurar Khirsha",
                "330 Tk",
                "300 gm",
                R.drawable.food_bogurar_khirsha
        ));

        favouriteFoodList.add(new ModelFoodItem(
                "Bogurar Doi",
                "230 Tk",
                "300 gm",
                R.drawable.food_bogurar_doi
        ));

        favouriteFoodList.add(new ModelFoodItem(
                "Chomchom",
                "500 Tk",
                "300 gm",
                R.drawable.food_porabari_chomchom
        ));

        favouriteFoodList.add(new ModelFoodItem(
                "Bogurar Doi",
                "230 Tk",
                "300 gm",
                R.drawable.food_bogurar_doi
        ));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_activity_food_item_list,menu);
        return true;
    }
}