package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterOnGoingOrderDetailsBillingRecy;
import com.freshnin.userapplication.adapter.AdapterOnGoingOrderDetailsFoodListRecy;
import com.freshnin.userapplication.model.ModelFoodItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityOnGoingOrderDetails extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView onGoingOrderProdeuctRecy;
    private AdapterOnGoingOrderDetailsFoodListRecy adapterOnGoingOrderDetailsFoodListRecy;
    private List<ModelFoodItem> foodItemList;

    private RecyclerView onGoingOrderBillingRecy;
    private AdapterOnGoingOrderDetailsBillingRecy adapterOnGoingOrderDetailsBillingRecy;
    private List<ModelFoodItem> billingFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_going_order_details);

        intiList();

        toolbar=findViewById(R.id.aogod_onGOingOrder_details_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        onGoingOrderProdeuctRecy =findViewById(R.id.aogod_productList_recy);
        onGoingOrderProdeuctRecy.setLayoutManager(new LinearLayoutManager(ActivityOnGoingOrderDetails.this));
        adapterOnGoingOrderDetailsFoodListRecy=new AdapterOnGoingOrderDetailsFoodListRecy(foodItemList,ActivityOnGoingOrderDetails.this);
        onGoingOrderProdeuctRecy.setAdapter(adapterOnGoingOrderDetailsFoodListRecy);


        onGoingOrderBillingRecy=findViewById(R.id.aogod_billing_list_recy);
        onGoingOrderBillingRecy.setLayoutManager(new LinearLayoutManager(ActivityOnGoingOrderDetails.this));
        adapterOnGoingOrderDetailsBillingRecy=new AdapterOnGoingOrderDetailsBillingRecy(billingFoodList,ActivityOnGoingOrderDetails.this);
        onGoingOrderBillingRecy.setAdapter(adapterOnGoingOrderDetailsBillingRecy);

    }

    private void intiList() {
        foodItemList=new ArrayList<>();
        foodItemList.add(new ModelFoodItem(
                "Bogurar Doi",
                 R.drawable.food_bogurar_doi,
                "03"
        ));

        foodItemList.add(new ModelFoodItem(
                "Boguar Khirsha",
                R.drawable.food_bogurar_khirsha,
                "02"
        ));

        foodItemList.add(new ModelFoodItem(
                "Chomchom",
                R.drawable.food_bogurar_doi,
                "05"
        ));

        billingFoodList=new ArrayList<>();
        billingFoodList.add(new ModelFoodItem(
                "Bogurar Doi",
                "300 Tk"
        ));

        billingFoodList.add(new ModelFoodItem(
                "Bogurar Khirsha",
                "480 Tk"
        ));

        billingFoodList.add(new ModelFoodItem(
                "Chomchom",
                "250 Tk"
        ));

    }
}