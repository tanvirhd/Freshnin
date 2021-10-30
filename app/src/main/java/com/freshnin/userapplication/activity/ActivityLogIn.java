package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        mLogIn=findViewById(R.id.al_btnLogin);
        mNewRegister=findViewById(R.id.al_tv_register);

        int data=getIntent().getIntExtra("key_int_value",-1);
        //Toast.makeText(ActivityLogIn.this, String.valueOf(data), Toast.LENGTH_SHORT).show();

        mNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogIn.this, ActivityRegistrationWithPhone.class);
                startActivity(intent);
            }
        });
    }
}
