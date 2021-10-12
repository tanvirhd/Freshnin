package com.freshnin.userapplication.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.freshnin.userapplication.R;

public class ActivityPreOrderProductDetails extends AppCompatActivity {
    private static final String TAG = "ActivityProductDetails";

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_product_details);

        toolbar=findViewById(R.id.toolbarActivityProfuctDetails);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white,null));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bogurar Doi");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }
}
