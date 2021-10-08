package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.freshnin.userapplication.R;

public class ActivityRegistrationWithDetails extends AppCompatActivity {

    private Button btnRegiConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_with_details);

        btnRegiConfirm=findViewById(R.id.btnRegConfirm);

        btnRegiConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityRegistrationWithDetails.this, ActivityProductDetails.class);
                startActivity(intent);
            }
        });

    }
}