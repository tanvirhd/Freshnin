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
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterCheckOutBillingRecy;
import com.freshnin.userapplication.adapter.AdapterCheckOutFoodItemRecy;
import com.freshnin.userapplication.model.ModelCreateNewRegularOrder;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.model.ModelResponse;
import com.freshnin.userapplication.tools.GlobalKey;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelRegularItem;

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

    private TextView btnPlaceOrder;
    private int orderQuantity=1,deliveryCharge=0;
    boolean inTownDelivery=false;

    private ModelRegularItem itemDetails;
    private ViewModelRegularItem viewModelRegularItem;
    private Dialog dialogLoading;

    private RadioGroup radioGroupAddress;
    private RadioButton radioInTown;

    private EditText etDeliveryAddress;
    private EditText etPhoneNumber;

    private String itemQuantity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        init();

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


        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewOrder();
                Intent intent = new Intent(ActivityCheckOut.this, ActivityHome .class);
                startActivity(intent);
            }
        });

        radioGroupAddress.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.aco_rbtn_inside_chittagong){
                    deliveryCharge=80;
                    //tvDeliveryCharge.setText(String.valueOf(deliveryCharge));
                }else if(checkedId == R.id.aco_rbtn_outside_chittagong){
                    deliveryCharge=120;
                    //tvDeliveryCharge.setText(String.valueOf(deliveryCharge));
                }
            }
        });

        inTownDelivery=true; //default inTownDelivery true;
        radioInTown.setChecked(true);


    }

    private void init() {


        checkOutFoodItemList=new ArrayList<>();
        checkOutBillingFoodItemList=new ArrayList<>();

        btnPlaceOrder=findViewById(R.id.aco_btn_placeOrder);

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

        viewModelRegularItem= new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelRegularItem.class);

        dialogLoading= Utils.setupLoadingDialog(ActivityCheckOut.this);

        radioGroupAddress=findViewById(R.id.aco_radioGroup);
        radioInTown=findViewById(R.id.aco_rbtn_inside_chittagong);
        etDeliveryAddress=findViewById(R.id.aco_etvDeliveryAddress);
        etPhoneNumber=findViewById(R.id.aco_edt_contact_number);

    }

    void createNewOrder(){
        if(getIntent().getStringExtra("caller")=="ActivityFoodItemDetails"){
            itemQuantity=1+",";
        }else if(getIntent().getStringExtra("caller")=="ActivityMyCart"){
            itemQuantity=getIntent().getStringExtra("data-3");
        }



        dialogLoading.show();
        ModelCreateNewRegularOrder modelCreateNewRegularOrder= new ModelCreateNewRegularOrder(
                Utils.generate9DigitDeliveryID("#"),
                Utils.getPref(GlobalKey.USER_ID,""),
                getIntent().getStringExtra("data-3"),
                itemQuantity,
                getIntent().getIntExtra("data-4",0),
                deliveryCharge,
                etDeliveryAddress.getText().toString(),
                inTownDelivery ? 1:0,
                Utils.getCurrentDate(),
                Utils.getCurrentDateTime24HRFormat(),
                etPhoneNumber.getText().toString(),
                "COD",
                1
        );

        viewModelRegularItem.createNewRegularOrder(modelCreateNewRegularOrder).observe(this, new Observer<ModelResponse>() {
            @Override
            public void onChanged(ModelResponse modelResponse) {
                if(modelResponse != null && modelResponse.getResponse() == 1 ){
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityCheckOut.this, "Order Placed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ActivityCheckOut.this,ActivityHome.class));
                }else{
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityCheckOut.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}