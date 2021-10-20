package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterMyCartItemListRecy;
import com.freshnin.userapplication.model.ModelMycartItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityMyCart extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView myCartRecyclerView;
    private AdapterMyCartItemListRecy adapterMyCartItemListRecy;
    private List<ModelMycartItem> myCartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        toolbar=findViewById(R.id.amc_cart_main_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        myCartRecyclerView=findViewById(R.id.amc_myCart_recyclerView);
        initList();

        myCartRecyclerView.setLayoutManager(new LinearLayoutManager(ActivityMyCart.this));
        adapterMyCartItemListRecy=new AdapterMyCartItemListRecy(myCartItems,ActivityMyCart.this);
        myCartRecyclerView.setAdapter(adapterMyCartItemListRecy);

    }

    private void initList() {
        myCartItems=new ArrayList<>();
        myCartItems.add(new ModelMycartItem(
                "Bogurar Doi",
                "200 Tk",
                "3"
        ));

        myCartItems.add(new ModelMycartItem(
                "Khirsha",
                "330 Tk",
                "1"
        ));

        myCartItems.add(new ModelMycartItem(
                "malai kari",
                "200 Tk",
                "2"
        ));


        myCartItems.add(new ModelMycartItem(
                "Bogurar Doi",
                "200 Tk",
                "3"
        ));

        myCartItems.add(new ModelMycartItem(
                "Bogurar Doi",
                "200 Tk",
                "1"
        ));
        myCartItems.add(new ModelMycartItem(
                "Bogurar Doi",
                "200 Tk",
                "6"
        ));

        myCartItems.add(new ModelMycartItem(
                "Bogurar Doi",
                "200 Tk",
                "3"
        ));

        myCartItems.add(new ModelMycartItem(
                "Khirsha",
                "330 Tk",
                "1"
        ));

        myCartItems.add(new ModelMycartItem(
                "malai kari",
                "200 Tk",
                "2"
        ));


        myCartItems.add(new ModelMycartItem(
                "Bogurar Doi",
                "200 Tk",
                "3"
        ));

        myCartItems.add(new ModelMycartItem(
                "Bogurar Doi",
                "200 Tk",
                "1"
        ));
        myCartItems.add(new ModelMycartItem(
                "Bogurar Doi",
                "200 Tk",
                "6"
        ));
    }
}