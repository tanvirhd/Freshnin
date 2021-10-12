package com.freshnin.userapplication.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterPreOrderFoodRecy;
import com.freshnin.userapplication.model.ModelPreOrderFood;

import java.util.ArrayList;
import java.util.List;

public class ActivityPreOrderFoodList extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView preOrderFoodRecy;
    private AdapterPreOrderFoodRecy adapterPreOrderFoodRecy;
    private List<ModelPreOrderFood> preOrderFoodList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_item_list);

        toolbar=findViewById(R.id.preOrder_list_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initList();

        preOrderFoodRecy=findViewById(R.id.pre_Order_FoodRecy);
        preOrderFoodRecy.setLayoutManager(new LinearLayoutManager(ActivityPreOrderFoodList.this));

        adapterPreOrderFoodRecy=new AdapterPreOrderFoodRecy(preOrderFoodList,ActivityPreOrderFoodList.this);
        preOrderFoodRecy.setAdapter(adapterPreOrderFoodRecy);

    }

    private void initList() {
        preOrderFoodList=new ArrayList<>();

        preOrderFoodList.add(new ModelPreOrderFood(
                "Bogurar Doi",
                "Wednesday",
                R.drawable.food_bogurar_doi
        ));

        preOrderFoodList.add(new ModelPreOrderFood(
                "Bogurar Khirsha",
                "Monday",
                R.drawable.food_bogurar_doi
        ));

        preOrderFoodList.add(new ModelPreOrderFood(
                "Krishna kabiner Malai kari",
                "Satarday",
                R.drawable.food_bogurar_doi
        ));

        preOrderFoodList.add(new ModelPreOrderFood(
                "Bogurar Doi",
                "Wednesday",
                R.drawable.food_bogurar_doi
        ));

        preOrderFoodList.add(new ModelPreOrderFood(
                "Bogurar Doi",
                "Wednesday",
                R.drawable.food_bogurar_doi
        ));

        preOrderFoodList.add(new ModelPreOrderFood(
                "Bogurar Doi",
                "Wednesday",
                R.drawable.food_bogurar_doi
        ));

        preOrderFoodList.add(new ModelPreOrderFood(
                "Bogurar Khirsha",
                "Monday",
                R.drawable.food_bogurar_doi
        ));

        preOrderFoodList.add(new ModelPreOrderFood(
                "Krishna kabiner Malai kari",
                "Satarday",
                R.drawable.food_bogurar_doi
        ));

        preOrderFoodList.add(new ModelPreOrderFood(
                "Bogurar Doi",
                "Wednesday",
                R.drawable.food_bogurar_doi
        ));

        preOrderFoodList.add(new ModelPreOrderFood(
                "Bogurar Doi",
                "Wednesday",
                R.drawable.food_bogurar_doi
        ));
    }
}
