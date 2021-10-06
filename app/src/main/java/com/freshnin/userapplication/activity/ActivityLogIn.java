package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.freshnin.userapplication.R;

public class ActivityLogIn extends AppCompatActivity {

    private Button mLogIn;
    private TextView mNewRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        mLogIn=findViewById(R.id.btnLogin);
        mNewRegister=findViewById(R.id.tv_register);


        mNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogIn.this, ActivityRegistrationWithPhone.class);
                startActivity(intent);
            }
        });
    }
}
