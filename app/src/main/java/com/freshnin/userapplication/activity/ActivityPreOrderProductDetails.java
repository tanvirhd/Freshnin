package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelPreOrderItem;

public class ActivityPreOrderProductDetails extends AppCompatActivity {
    private static final String TAG = "ActivityProductDetails";

    private Toolbar toolbar;
    private TextView btnOrderNow,tvShortDescription;

    private ModelPreOrderItem itemDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_product_details);

        toolbar=findViewById(R.id.apopd_toolbarActivityProfuctDetails);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white,null));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bogurar Doi");

        btnOrderNow=findViewById(R.id.apopd_btnOrderNow);
        tvShortDescription=findViewById(R.id.apopd_tv_Food_Details);

        init();


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnOrderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityPreOrderProductDetails.this, ActivityPreOrderItemCart.class);
                startActivity(intent);
            }
        });
    }


    void init(){
        itemDetails = getIntent().getExtras().getParcelable("parcel");
        if(itemDetails != null){
            updateUI(itemDetails);
        }

    }

    void updateUI(ModelPreOrderItem modelPreOrderItem){
        tvShortDescription.setText(modelPreOrderItem.getProductShortDes());
    }
}
