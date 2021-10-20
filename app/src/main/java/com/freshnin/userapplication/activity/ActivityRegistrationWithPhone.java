package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.freshnin.userapplication.R;

public class ActivityRegistrationWithPhone extends AppCompatActivity {

    private Button btnSendOtp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_with_phone);

        btnSendOtp=findViewById(R.id.arwp_btn_send_otp);
        btnSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityRegistrationWithPhone.this, ActivityVerification.class);
                startActivity(intent);
            }
        });
    }
}
