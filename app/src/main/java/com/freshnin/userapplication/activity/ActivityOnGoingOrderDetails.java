package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterOnGoingOrderDetailsBillingRecy;
import com.freshnin.userapplication.adapter.AdapterOnGoingOrderDetailsFoodListRecy;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelOnGoingOrder;
import com.freshnin.userapplication.model.ModelRegularItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityOnGoingOrderDetails extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvDeliveryCharge;
    private TextView tvTotalBill;
    private TextView tvDeliveryAddress;


    private RecyclerView onGoingOrderProdeuctRecy;
    private AdapterOnGoingOrderDetailsFoodListRecy adapterOnGoingOrderDetailsFoodListRecy;
    private List<ModelRegularItem> foodItemList;

    private RecyclerView onGoingOrderBillingRecy;
    private AdapterOnGoingOrderDetailsBillingRecy adapterOnGoingOrderDetailsBillingRecy;
    private List<ModelRegularItem> billingFoodList;


    private ModelRegularItem regularItemDetails;
    private ModelOnGoingOrder onGoingOrderDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_going_order_details);

        init();



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void init() {
        toolbar=findViewById(R.id.aogod_onGOingOrder_details_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        foodItemList=new ArrayList<>();
        billingFoodList=new ArrayList<>();

        onGoingOrderProdeuctRecy =findViewById(R.id.aogod_productList_recy);
        onGoingOrderProdeuctRecy.setLayoutManager(new LinearLayoutManager(ActivityOnGoingOrderDetails.this));
        adapterOnGoingOrderDetailsFoodListRecy=new AdapterOnGoingOrderDetailsFoodListRecy(foodItemList,ActivityOnGoingOrderDetails.this);
        onGoingOrderProdeuctRecy.setAdapter(adapterOnGoingOrderDetailsFoodListRecy);

        onGoingOrderBillingRecy=findViewById(R.id.aogod_billing_list_recy);
        onGoingOrderBillingRecy.setLayoutManager(new LinearLayoutManager(ActivityOnGoingOrderDetails.this));
        adapterOnGoingOrderDetailsBillingRecy=new AdapterOnGoingOrderDetailsBillingRecy(billingFoodList,ActivityOnGoingOrderDetails.this);
        onGoingOrderBillingRecy.setAdapter(adapterOnGoingOrderDetailsBillingRecy);


        tvDeliveryCharge=findViewById(R.id.aogod_deliveryCharge);
        tvTotalBill=findViewById(R.id.aogod_total_bill);
        tvDeliveryCharge=findViewById(R.id.aogod_tv_delivery_address);

        onGoingOrderDetails=getIntent().getExtras().getParcelable("parcel-1");
        regularItemDetails=getIntent().getExtras().getParcelable("parcel-2");
        if(onGoingOrderDetails!=null && regularItemDetails!=null){
            updateUi();
        }

    }

    private void updateUi() {
        foodItemList.addAll(onGoingOrderDetails.getItems());
        billingFoodList.addAll(onGoingOrderDetails.getItems());
        tvDeliveryCharge.setText(onGoingOrderDetails.getDeliveryCharge());
        tvTotalBill.setText(onGoingOrderDetails.getTotalBill());
        tvDeliveryAddress.setText(onGoingOrderDetails.getDeliveryAddress());
    }
}