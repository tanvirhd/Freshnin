package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelCreateNewPreOrder;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.model.ModelResponse;
import com.freshnin.userapplication.tools.GlobalKey;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelPreOrderItem;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class ActivityPreOrderCheckout extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView btnPlaceOrder;
    private TextView tvOrderId;
    private TextView tvItemName;
    private ImageView ivItemImage;
    private ImageView ivQuantityIncrease;
    private ImageView ivQuantityDecrease;
    private TextView tvTotalQuantity;
    private TextView tvBillingItemName, tvBillingItemPrice, tvDeliveryCharge;
    private TextView tvBillingTotalBill, tvBillThirtyPercent;
    private EditText etDeliveryAddress;
    private EditText etTransctionId;
    private RadioGroup radioGroupAddress;
    private RadioGroup radioGroupPaymentMethod;
    private RadioButton radioInTown;

    private Random randomNumber;
    private String randOne,randTwo;
    private int orderQuantity=1,deliveryCharge=0;
    boolean inTownDelivery=false,isAdvancePaymentMethodSelected=false;
    private String advancePaymentMethod="";

    private ModelPreOrderItem itemDetails;
    private ViewModelPreOrderItem viewModelPreOrderItem;

    private Dialog dialogLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_item_cart);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        ivQuantityIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderQuantity++;
                onQuantityChanged(orderQuantity);
            }
        });

        ivQuantityDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(orderQuantity>=2){
                    orderQuantity--;
                    onQuantityChanged(orderQuantity);
                }else{
                    Toast.makeText(ActivityPreOrderCheckout.this, "Minimum Quantity 1", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAdvancePaymentMethodSelected ||
                        etDeliveryAddress.getText().toString().isEmpty() ||
                          etTransctionId.getText().toString().isEmpty()){
                    Toast.makeText(ActivityPreOrderCheckout.this, "Fill-up All Fields!!", Toast.LENGTH_SHORT).show();
                }else {
                    createNewOrder();
                }


            }
        });

        radioGroupAddress.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.apoic_rbtn_inside_chittagong){
                    deliveryCharge=80;
                    tvDeliveryCharge.setText(String.valueOf(deliveryCharge));
                }else if(checkedId == R.id.apoic_rbtn_outside_chittagong){
                    deliveryCharge=120;
                    tvDeliveryCharge.setText(String.valueOf(deliveryCharge));
                }
            }
        });


        radioGroupPaymentMethod.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonBkash:
                        isAdvancePaymentMethodSelected=true;
                        advancePaymentMethod="Bkash";
                        break;
                    case R.id.radioButtonNagad:
                        isAdvancePaymentMethodSelected=true;
                        advancePaymentMethod="Nagad";
                        break;
                    case R.id.radioButtonRocket:
                        isAdvancePaymentMethodSelected=true;
                        advancePaymentMethod="Rocket";
                        break;
                }
            }
        });

    }

    public void init(){
        toolbar=findViewById(R.id.apoic_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        btnPlaceOrder=findViewById(R.id.apoic_btnPlaceOrder);
        tvOrderId=findViewById(R.id.apoic_orderId);
        tvItemName=findViewById(R.id.apoic_tvFoodName);
        ivItemImage=findViewById(R.id.apoic_iv_food_image);
        ivQuantityIncrease=findViewById(R.id.apoic_btn_cart_quantity_increment);
        ivQuantityDecrease=findViewById(R.id.apoic_btn_cart_quantity_decrement);
        tvBillingItemName=findViewById(R.id.apoic_billing_tvFoodName);
        tvBillingItemPrice=findViewById(R.id.apoic_billing_tvFoodPrice);
        tvDeliveryCharge=findViewById(R.id.tvDeliveryCharge);
        tvBillingTotalBill=findViewById(R.id.apoic_tvTotalBill);
        tvBillThirtyPercent=findViewById(R.id.apoic_tvThirtyPercentOfTotalBill);
        tvTotalQuantity=findViewById(R.id.apoic_tv_cart_food_quantity);
        etDeliveryAddress=findViewById(R.id.apoic_etvDeliveryAddress);
        etTransctionId=findViewById(R.id.apoic_etvPreorder_payment_transction_id);

        radioGroupAddress=findViewById(R.id.apoic_radioGroup_address);
        radioInTown=findViewById(R.id.apoic_rbtn_inside_chittagong);
        radioGroupPaymentMethod=findViewById(R.id.radioGroup_paymentMethod);

        viewModelPreOrderItem= new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelPreOrderItem.class);


        itemDetails =getIntent().getExtras().getParcelable("parcel");
        if(itemDetails!=null){
            updateUi();
        }

        dialogLoading= Utils.setupLoadingDialog(ActivityPreOrderCheckout.this);

    }

    private void updateUi() {
        tvOrderId.setText(Utils.generate9DigitDeliveryID(itemDetails.getPreOrderProductName().substring(0,3)));
        Picasso.with(this).load(itemDetails.getProductPicUrl()).into(ivItemImage);
        tvItemName.setText(itemDetails.getPreOrderProductName());

        tvTotalQuantity.setText(String.valueOf(orderQuantity));

        tvBillingItemName.setText(itemDetails.getPreOrderProductName());
        tvBillingItemPrice.setText(itemDetails.getProductUnitPrice());

        tvBillingTotalBill.setText(itemDetails.getProductUnitPrice());
        double advanceBillAmount=(Integer.parseInt(itemDetails.getProductUnitPrice())) *(30/100.00);
        tvBillThirtyPercent.setText(String.valueOf(advanceBillAmount));


        inTownDelivery=true; //default inTownDelivery true;
        deliveryCharge=80;
        radioInTown.setChecked(true);
        tvDeliveryCharge.setText(String.valueOf(deliveryCharge));

    }


    void onQuantityChanged(int orderQuantity){
        int unitPrice=Integer.parseInt(itemDetails.getProductUnitPrice());
        int netPrice=Integer.parseInt(itemDetails.getProductUnitPrice()) *orderQuantity;
        int totalBil=(orderQuantity*unitPrice)+deliveryCharge;
        double advanceBill=totalBil*(30/100.00);


        tvBillingItemPrice.setText(String.valueOf(netPrice));
        tvTotalQuantity.setText(String.valueOf(orderQuantity));
        tvBillingTotalBill.setText(String.valueOf(totalBil));
        tvBillThirtyPercent.setText(String.valueOf(advanceBill));

    }

    private void createNewOrder(){
        dialogLoading.show();
        int unitPrice=Integer.parseInt(itemDetails.getProductUnitPrice());
        int totalBil=(orderQuantity*unitPrice)+deliveryCharge;
        double advanceBill=totalBil*(30/100.00);

        ModelCreateNewPreOrder newPreOrder=new ModelCreateNewPreOrder(
                tvOrderId.getText().toString(),
                itemDetails.getProductId(),
                Utils.getPref(GlobalKey.USER_ID,""),
                itemDetails.getPreOrderProductName(),
                Utils.getCurrentDate(),
                itemDetails.getSessionEndDate(),
                orderQuantity,
                etDeliveryAddress.getText().toString(),
                inTownDelivery ? 1:0,
                deliveryCharge,
                totalBil,
                (int)advanceBill,
                1,
                etTransctionId.getText().toString(),
                "COD",
                advancePaymentMethod,
                1
        );

        viewModelPreOrderItem.createNewPreOrder(newPreOrder).observe(this, new Observer<ModelResponse>() {
            @Override
            public void onChanged(ModelResponse response) {
                if(response != null && response.getResponse() == 1 ){
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityPreOrderCheckout.this, "Order Placed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ActivityPreOrderCheckout.this,ActivityHome.class));
                }else{
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityPreOrderCheckout.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}