package com.freshnin.userapplication.activity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelCartItemWrapper;
import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelFavouriteFood;
import com.freshnin.userapplication.viewmodel.ViewModelMyCartItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ActivityFoodItemDetails extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvItemDiscription;
    private TextView tvItemPrice;
    private TextView tvItemWeight;
    private ImageView ivItemImage;

    private TextView btnAddToCart;
    private TextView btnBuyNow;

    private ModelRegularItem itemDetails;
    private ViewModelMyCartItem viewModelMyCartItem;

    private ViewModelFavouriteFood viewModelFavouriteFood;

    private Dialog dialogLoading;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_details);

        init();

        //toolbar.setBackgroundColor(R.color.appbg);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModelMyCartItem cartItem=new ModelMyCartItem(itemDetails.getProductName(),itemDetails.getProductUnitPrice(),"1",itemDetails.getProductId());
                List<ModelMyCartItem> tempList=new ArrayList<>();
                tempList.add(cartItem);
                ModelCartItemWrapper wrapper=new ModelCartItemWrapper(tempList);

                Intent intent=new Intent(ActivityFoodItemDetails.this,ActivityCheckOut.class);
                intent.putExtra("cart-data",wrapper);
                startActivity(intent);
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLoading.show();
                viewModelMyCartItem.insertNewMyCartItem(
                        new ModelMyCartItem(
                                itemDetails.getProductName(),
                                itemDetails.getProductUnitPrice().toString(),
                                1+"",
                                itemDetails.getProductId()
                        )
                );dialogLoading.dismiss();
                Toast.makeText(ActivityFoodItemDetails.this, "Item added", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_activity_food_item_details,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.afid_menuFavourite:
                addItemToFavourite();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addItemToFavourite() {
        viewModelFavouriteFood.insertFavouriteFood(
                new ModelRegularItem(
                        itemDetails.getProductId(),
                        itemDetails.getProductName(),
                        itemDetails.getProductDes(),
                        itemDetails.getProductPicUrl(),
                        itemDetails.getProductUnitPrice(),
                        itemDetails.getProductUnitWeight(),
                        itemDetails.getInStock(),
                        itemDetails.getProductCategory()
                )
        );
        Toast.makeText(this, "item added to favourite", Toast.LENGTH_SHORT).show();
    }

    void init(){
        toolbar=findViewById(R.id.afid_toolbar_food_item_details);
        setSupportActionBar(toolbar);

        btnBuyNow=findViewById(R.id.afid_btn_Buy_Now);
        btnAddToCart=findViewById(R.id.afid_btnAddToCart);
        tvItemDiscription=findViewById(R.id.afid_tvFoodDetails);
        tvItemPrice=findViewById(R.id.afid_tvPerFoodPrice);
        tvItemWeight=findViewById(R.id.afid_tvFoodWeight);
        ivItemImage=findViewById(R.id.afid_ivFoodPicture);

        viewModelMyCartItem=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelMyCartItem.class);
        viewModelFavouriteFood=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelFavouriteFood.class);

        dialogLoading= Utils.setupLoadingDialog(ActivityFoodItemDetails.this);
        itemDetails=getIntent().getExtras().getParcelable("parcel");
        if(itemDetails!=null){
            updateUi(itemDetails);
        }

    }

    private void updateUi(ModelRegularItem itemDetails) {
        getSupportActionBar().setTitle(itemDetails.getProductName());
        Picasso.with(this).load(itemDetails.getProductPicUrl()).into(ivItemImage);
        tvItemDiscription.setText(itemDetails.getProductDes());
        tvItemPrice.setText(itemDetails.getProductUnitPrice()+" Taka");
        tvItemWeight.setText(itemDetails.getProductUnitWeight()+" gram");
    }
}