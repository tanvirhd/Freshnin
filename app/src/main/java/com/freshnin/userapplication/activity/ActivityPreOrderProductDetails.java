package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.tools.Utils;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityPreOrderProductDetails extends AppCompatActivity {
    private static final String TAG = "ActivityProductDetails";

    private Toolbar toolbar;
    private TextView btnOrderNow,tvShortDescription;
    private TextView tvItemPrice;
    private TextView tvItemWeight;
    private TextView tvPreOrderOngoingRemainingDay;
    private ImageView ivItem;
    private ModelPreOrderItem itemDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_product_details);

        try {
            init();
        } catch (ParseException e) {
            Log.d(TAG, "init: error"+e.getMessage());
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnOrderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPreOrderProductDetails.this, ActivityPreOrderCheckout.class);
                intent.putExtra("parcel",itemDetails);
                startActivity(intent);
            }
        });
    }


    void init() throws ParseException {
        toolbar=findViewById(R.id.apopd_toolbarActivityProfuctDetails);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white,null));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        btnOrderNow=findViewById(R.id.apopd_btnOrderNow);
        tvShortDescription=findViewById(R.id.apopd_tv_Food_Details);
        tvItemWeight=findViewById(R.id.apopd_tvFoodWeight);
        tvItemPrice=findViewById(R.id.apopd_tvPerFoodPrice);
        tvPreOrderOngoingRemainingDay=findViewById(R.id.apopd_tvProductRemainingDay);
        ivItem=findViewById(R.id.apopd_food_image);



        itemDetails = getIntent().getExtras().getParcelable("parcel");
        if(itemDetails != null){
            updateUI(itemDetails);
        }

    }

    void updateUI(ModelPreOrderItem modelPreOrderItem) throws ParseException {
        Picasso.with(this).load(modelPreOrderItem.getProductPicUrl()).into(ivItem);
        getSupportActionBar().setTitle(modelPreOrderItem.getPreOrderProductName());
        tvShortDescription.setText(modelPreOrderItem.getProductShortDes());
        tvItemPrice.setText(modelPreOrderItem.getProductUnitPrice());
        tvItemWeight.setText(modelPreOrderItem.getProductUnitWeight());


        tvPreOrderOngoingRemainingDay.setText(remainingDay(modelPreOrderItem.getSessionEndDate()));
    }


    String remainingDay(String endDate) throws ParseException {


        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
        Date sessionEndDate=dateFormat.parse(endDate);
        Date currentDate=dateFormat.parse(Utils.getCurrentDate());
        long diff = Math.abs(sessionEndDate.getTime() - currentDate.getTime());
        long remainDay = diff / (24 * 60 * 60 * 1000);

        return String.valueOf(remainDay);
    }
}
