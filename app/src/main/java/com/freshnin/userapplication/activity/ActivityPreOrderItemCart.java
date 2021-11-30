package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.viewmodel.ViewModelPreOrderItem;
import com.squareup.picasso.Picasso;

import java.util.Random;

public class ActivityPreOrderItemCart extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView btnPlaceOrder;
    private ModelPreOrderItem itemDetails;
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

    private Random randomNumber;
    private String randOne,randTwo;

    private ViewModelPreOrderItem viewModelPreOrderItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_item_cart);

        init();
        updateUi();

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
                Intent intent = new Intent(ActivityPreOrderItemCart.this, ActivityHome.class);
                startActivity(intent);
            }
        });

    }

    private void updateUi() {
        tvOrderId.setText("Pre"+(randOne+randTwo)+"Fresh"+randomNumber.nextInt(50));
        Picasso.with(this).load(itemDetails.getProductPicUrl()).into(ivItemImage);
        tvItemName.setText(itemDetails.getPreOrderProductName());
        tvTotalQuantity.setText("1");

        tvBillingItemName.setText(itemDetails.getPreOrderProductName());
        tvBillingItemPrice.setText(itemDetails.getProductUnitPrice());
        tvDeliveryCharge.setText("0");
        tvBillThirtyPercent.setText("0");
        tvBillingTotalBill.setText(itemDetails.getProductUnitPrice());

    }

    public void init(){
        toolbar=findViewById(R.id.apoic_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        btnPlaceOrder=findViewById(R.id.apoic_btnPlaceOrder);

        itemDetails =getIntent().getExtras().getParcelable("parcel");

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
        radioGroupPaymentMethod=findViewById(R.id.radioGroup_paymentMethod);

        randomNumber=new Random();
        randOne=String.valueOf(randomNumber.nextInt(999));
        randTwo=String.valueOf(randomNumber.nextInt(999));

        viewModelPreOrderItem= new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelPreOrderItem.class);


    }
    private void createNewOrder(){
        int selectedRadioInTown=0;
        int selectedAdvancedPaymentMethod=0;

        

    }
}