package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelLogIn;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.viewholder.ViewModelLogIn;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityLogIn extends AppCompatActivity {

    private static final String TAG = "ActivityLogIn";
    private Button mLogIn;
    private TextView mNewRegister;
    private TextInputEditText tietUserPhoneNumber;
    private TextInputEditText tietUserPassword;
    private ViewModelLogIn viewModelLogIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();


        int data = getIntent().getIntExtra("key_int_value", -1);
        //Toast.makeText(ActivityLogIn.this, String.valueOf(data), Toast.LENGTH_SHORT).show();

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
                viewModelLogIn.checkValidLogIn(new ModelUser(tietUserPhoneNumber.getText().toString(), tietUserPassword.getText().toString()))
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
                        });
            }
        });
    }

    void init() {
        mLogIn = findViewById(R.id.al_btnLogin);
        mNewRegister = findViewById(R.id.al_tv_register);
        tietUserPhoneNumber = findViewById(R.id.al_tietUserPhoneNumber);
        tietUserPassword = findViewById(R.id.al_tietUserPassword);
        viewModelLogIn = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelLogIn.class);
    }
}
