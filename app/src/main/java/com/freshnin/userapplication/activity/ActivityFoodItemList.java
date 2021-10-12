package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterFoodItemListRecy;
import com.freshnin.userapplication.model.ModelFoodItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityFoodItemList extends AppCompatActivity {

    private List<ModelFoodItem> foodItems;
    private RecyclerView recyclerViewFoodItem;
    private AdapterFoodItemListRecy adapterFoodItemListRecy;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_list);

        intList();

        toolbar=findViewById(R.id.toolbar_activity_food_item_list);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        recyclerViewFoodItem=findViewById(R.id.foodItemRecy);
        recyclerViewFoodItem.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        adapterFoodItemListRecy=new AdapterFoodItemListRecy(foodItems,ActivityFoodItemList.this);
        recyclerViewFoodItem.setAdapter(adapterFoodItemListRecy);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_activity_food_item_list,menu);
        return true;
    }

    void intList(){
        foodItems=new ArrayList<>();
        foodItems.add(new ModelFoodItem(
                "Bogurar Doi",
                "230 Tk",
                "200 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Bogurar Khirsha",
                "400 Tk",
                "800 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Krishna Kebiner MalaiKari",
                "370 Tk",
                "600 gm",
                false,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Bogurar Doi",
                "230 Tk",
                "200 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Porabarir Chomchom",
                "330 Tk",
                "700 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems=new ArrayList<>();
        foodItems.add(new ModelFoodItem(
                "Bogurar Doi",
                "230 Tk",
                "200 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Bogurar Khirsha",
                "400 Tk",
                "800 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Krishna Kebiner MalaiKari",
                "370 Tk",
                "600 gm",
                false,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Bogurar Doi",
                "230 Tk",
                "200 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Porabarir Chomchom",
                "330 Tk",
                "700 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Bogurar Doisdfsdb svdjnvsnsdv  sdjs sjdkssdjs smvl",
                "230 Tk",
                "200 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Bogurar Khirsha",
                "400 Tk",
                "800 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Krishna Kebiner MalaiKari",
                "370 Tk",
                "600 gm",
                false,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Bogurar Doi jhkabsdsk sjvnsvn asdfnsv dsb sjvksj sduhfsj sdvsjkb isdnjk",
                "230 Tk",
                "200 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

        foodItems.add(new ModelFoodItem(
                "Porabarir Chomchom",
                "330 Tk",
                "700 gm",
                true,
                R.drawable.food_bogurar_doi
        ));

    }
}