package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterCheckOutBillingRecy;
import com.freshnin.userapplication.adapter.AdapterCheckOutFoodItemRecy;
import com.freshnin.userapplication.model.ModelCartItemWrapper;
import com.freshnin.userapplication.model.ModelCreateNewRegularOrder;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.model.ModelResponse;
import com.freshnin.userapplication.tools.GlobalKey;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelRegularItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityCheckOut extends AppCompatActivity {
    private static final String TAG = "ActivityCheckOut";
    private Toolbar toolbar;


    private List<ModelMyCartItem> checkOutFoodItemList;
    private RecyclerView checkOutProductListRecyc;
    private AdapterCheckOutFoodItemRecy adapterCheckOutFoodItemRecy;
    private RecyclerView checkOutBillingRecy;
    private AdapterCheckOutBillingRecy adapterCheckOutBillingRecy;

    private TextView btnPlaceOrder, tvDeliveryCharge, tvTotalBill;
    private int orderQuantity = 1, deliveryCharge = 0;
    boolean inTownDelivery = false;

    private ModelRegularItem itemDetails;
    private ViewModelRegularItem viewModelRegularItem;
    private Dialog dialogLoading;

    private RadioGroup radioGroupAddress;
    private RadioButton radioInTown;

    private EditText etDeliveryAddress;
    private EditText etPhoneNumber;

    private String caller = "";

    String itemIds = ""; //example 0001,0002,0003,
    String quantities = "";
    int totalBill = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        init();

        toolbar = findViewById(R.id.aco_preOrder_list_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewOrder();
            }
        });

        radioGroupAddress.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.aco_rbtn_inside_chittagong) {
                    deliveryCharge = 80;
                    tvTotalBill.setText((totalBill+deliveryCharge) + " Tk");
                    tvDeliveryCharge.setText(String.valueOf(deliveryCharge));
                } else if (checkedId == R.id.aco_rbtn_outside_chittagong) {
                    deliveryCharge = 120;
                    tvTotalBill.setText((totalBill+deliveryCharge) + " Tk");
                    tvDeliveryCharge.setText(String.valueOf(deliveryCharge));
                }
            }
        });


    }

    private void init() {
        btnPlaceOrder = findViewById(R.id.aco_btn_placeOrder);
        checkOutBillingRecy = findViewById(R.id.aco_product_billing_recyclerView);
        checkOutProductListRecyc = findViewById(R.id.aco_product_recyclerView);
        dialogLoading = Utils.setupLoadingDialog(ActivityCheckOut.this);
        radioGroupAddress = findViewById(R.id.aco_radioGroup);
        radioInTown = findViewById(R.id.aco_rbtn_inside_chittagong);
        etDeliveryAddress = findViewById(R.id.aco_etvDeliveryAddress);
        etPhoneNumber = findViewById(R.id.aco_edt_contact_number);
        tvDeliveryCharge = findViewById(R.id.aco_delivery_charge);
        tvTotalBill = findViewById(R.id.aco_tvTotalBill);

        inTownDelivery = true; //default inTownDelivery true;
        deliveryCharge = 80;
        radioInTown.setChecked(true);
        tvDeliveryCharge.setText(String.valueOf(deliveryCharge));
        viewModelRegularItem = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelRegularItem.class);

        ModelCartItemWrapper wrapper = getIntent().getParcelableExtra("cart-data");

        if (wrapper != null ) {
            checkOutFoodItemList = new ArrayList<>();
            checkOutFoodItemList.addAll(wrapper.getCartItems());
            // For check Out Food Item
            checkOutProductListRecyc.setLayoutManager(new LinearLayoutManager(ActivityCheckOut.this));
            adapterCheckOutFoodItemRecy = new AdapterCheckOutFoodItemRecy(checkOutFoodItemList, ActivityCheckOut.this);
            checkOutProductListRecyc.setAdapter(adapterCheckOutFoodItemRecy);

            // For Check Out Billing
            checkOutBillingRecy.setLayoutManager(new LinearLayoutManager(ActivityCheckOut.this));
            adapterCheckOutBillingRecy = new AdapterCheckOutBillingRecy(checkOutFoodItemList, ActivityCheckOut.this);
            checkOutBillingRecy.setAdapter(adapterCheckOutBillingRecy);


            for (ModelMyCartItem cartItem : checkOutFoodItemList) {
                itemIds = itemIds + cartItem.getFoodId() + ",";
                quantities += cartItem.getFoodQuantity() + ",";

                Log.d(TAG, "init1: bill="+totalBill);
                totalBill=totalBill+Integer.parseInt(cartItem.getFoodPrice());
                Log.d(TAG, "init2: bill="+totalBill);
            }

            tvTotalBill.setText((totalBill+deliveryCharge) + " Tk");

        }
    }

    void createNewOrder() {

        dialogLoading.show();
        ModelCreateNewRegularOrder modelCreateNewRegularOrder = new ModelCreateNewRegularOrder(
                Utils.generate9DigitDeliveryID("abcd"),
                Utils.getPref(GlobalKey.USER_ID, ""),
                itemIds,
                quantities,
                (totalBill+deliveryCharge),
                deliveryCharge,
                etDeliveryAddress.getText().toString(),
                inTownDelivery ? 1 : 0,
                Utils.getCurrentDate(),
                Utils.getCurrentDateTime24HRFormat(),
                etPhoneNumber.getText().toString(),
                "COD",
                1
        );


        viewModelRegularItem.createNewRegularOrder(modelCreateNewRegularOrder).observe(this, new Observer<ModelResponse>() {
            @Override
            public void onChanged(ModelResponse modelResponse) {
                if (modelResponse != null && modelResponse.getResponse() == 1) {
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityCheckOut.this, "Order Placed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ActivityCheckOut.this, ActivityHome.class));
                } else {
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityCheckOut.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}