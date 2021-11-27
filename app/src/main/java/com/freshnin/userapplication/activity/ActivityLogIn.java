package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.viewmodel.ViewModelUser;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityLogIn extends AppCompatActivity {

    private static final String TAG = "ActivityLogIn";
    private Button mLogIn;
    private TextView mNewRegister;
    private TextInputEditText tietUserPhoneNumber;
    private TextInputEditText tietUserPassword;
    private ViewModelUser viewModelUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();


        int data = getIntent().getIntExtra("key_int_value", -1);

        mNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogIn.this, ActivityCreateAccount.class);
                startActivity(intent);
            }
        });



        mLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLogIn.this,ActivityHome.class));

                //todo revert
               /* viewModelLogIn.checkValidLogIn(new ModelUser(tietUserPhoneNumber.getText().toString(), tietUserPassword.getText().toString()))
                        .observe(ActivityLogIn.this, new Observer<ModelLogIn>() {
                            @Override
                            public void onChanged(ModelLogIn modelLogIn) {
                                if (modelLogIn == null) {
                                    Toast.makeText(ActivityLogIn.this, "something went wrong", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (modelLogIn.isValidUser()) {
                                        Toast.makeText(ActivityLogIn.this, "Successfully Loged in", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(ActivityLogIn.this, "Wrong userid or password", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });*/
            }
        });
    }

    void init() {
        mLogIn = findViewById(R.id.al_btnLogin);
        mNewRegister = findViewById(R.id.al_tv_register);
        tietUserPhoneNumber = findViewById(R.id.al_tietUserPhoneNumber);
        tietUserPassword = findViewById(R.id.al_tietUserPassword);
        viewModelUser = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelUser.class);
    }
}
