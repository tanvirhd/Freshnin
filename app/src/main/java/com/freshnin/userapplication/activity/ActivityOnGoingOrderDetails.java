package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG = "ActivityOnGoingOrderDetails";
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


        tvDeliveryCharge=findViewById(R.id.aogod_deliveryCharge);
        tvTotalBill=findViewById(R.id.aogod_total_bill);
        tvDeliveryAddress=findViewById(R.id.aogod_tv_delivery_address);

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

        onGoingOrderDetails=getIntent().getExtras().getParcelable("parcel-1");

        if(onGoingOrderDetails!=null){
            Log.d(TAG, "init: not null");
            getSupportActionBar().setTitle(onGoingOrderDetails.getOrderId());
            updateUi(onGoingOrderDetails);
        }else {
            Log.d(TAG, "init: yes null");
        }
    }

    private void updateUi(ModelOnGoingOrder order) {
        foodItemList.addAll(order.getItems());
        billingFoodList.addAll(order.getItems());
        tvDeliveryCharge.setText(order.getDeliveryCharge());
        tvTotalBill.setText(order.getTotalBill());
        tvDeliveryAddress.setText(order.getDeliveryAddress());

        //list
    }
}