package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Display;
import android.view.View;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterCheckOutBillingRecy;
import com.freshnin.userapplication.adapter.AdapterCheckOutFoodItemRecy;
import com.freshnin.userapplication.model.ModelFoodItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityCheckOut extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView checkOutProductListRecyc;
    private List<ModelFoodItem> checkOutFoodItemList;
    private AdapterCheckOutFoodItemRecy adapterCheckOutFoodItemRecy;

    private RecyclerView checkOutBillingRecy;
    private List<ModelFoodItem> checkOutBillingFoodItemList;
    private AdapterCheckOutBillingRecy adapterCheckOutBillingRecy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        intiList();

        toolbar=findViewById(R.id.aco_preOrder_list_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // For check Out Food Item
        checkOutProductListRecyc=findViewById(R.id.aco_product_recyclerView);
        checkOutProductListRecyc.setLayoutManager(new LinearLayoutManager(ActivityCheckOut.this));
        adapterCheckOutFoodItemRecy =new AdapterCheckOutFoodItemRecy(checkOutFoodItemList,ActivityCheckOut.this);
        checkOutProductListRecyc.setAdapter(adapterCheckOutFoodItemRecy);


        // For Check Out Billing
        checkOutBillingRecy=findViewById(R.id.aco_product_billing_recyclerView);
        checkOutBillingRecy.setLayoutManager(new LinearLayoutManager(ActivityCheckOut.this));
        adapterCheckOutBillingRecy=new AdapterCheckOutBillingRecy(checkOutBillingFoodItemList,ActivityCheckOut.this);
        checkOutBillingRecy.setAdapter(adapterCheckOutBillingRecy);


    }

    private void intiList() {
        checkOutFoodItemList=new ArrayList<>();
        checkOutFoodItemList.add(new ModelFoodItem(
                "Bogurar Doi",
                "330 Tk",
                "03"
        ));

        checkOutFoodItemList.add(new ModelFoodItem(
                "Bogurar Khirsha",
                "400 Tk",
                "01"
        ));

        checkOutFoodItemList.add(new ModelFoodItem(
                "Chomchom",
                "220 Tk",
                "04"
        ));


        checkOutBillingFoodItemList=new ArrayList<>();
        checkOutBillingFoodItemList.add(new ModelFoodItem(
                "Bogurar Doi",
                "330 Tk"
        ));

        checkOutBillingFoodItemList.add(new ModelFoodItem(
                "Bogurar Khirsha",
                "400 Tk"
        ));
        checkOutBillingFoodItemList.add(new ModelFoodItem(
                "Chomchom",
                "500 Tk"
        ));

    }

}