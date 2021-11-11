package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.model.ModelUserVerify;
import com.freshnin.userapplication.viewholder.ViewModelCheckUserVerify;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityCreateAccount extends AppCompatActivity {

    private Button btnSendOtp;
    private TextInputEditText tietUserPhoneNumber;
    private ViewModelCheckUserVerify viewModelCheckUserVerify;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        init();


        btnSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tietUserPhoneNumber.getText().toString().length()!=11){
                    Toast.makeText(ActivityCreateAccount.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                }else{
                    viewModelCheckUserVerify.checkUserValidation(new ModelUser(tietUserPhoneNumber.getText().toString()))
                            .observe(ActivityCreateAccount.this, new Observer<ModelUserVerify>() {
                                @Override
                                public void onChanged(ModelUserVerify modelUserVerify) {
                                    if(modelUserVerify==null){
                                        Toast.makeText(ActivityCreateAccount.this, "something went wrong", Toast.LENGTH_SHORT).show();
                                    }else{
                                        if(modelUserVerify.isNewUser()){
                                            sendOTP();
                                        }else{
                                            Toast.makeText(ActivityCreateAccount.this, "Already Registered", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            });
                }

            }
        });
    }

    private void sendOTP() {
             Intent intent =new Intent(ActivityCreateAccount.this, ActivityOTPVerification.class);
             intent.putExtra("userPhoneNumber",tietUserPhoneNumber.getText().toString());
             startActivity(intent);
    }

    void init(){
        btnSendOtp=findViewById(R.id.aca_btn_send_otp);
        tietUserPhoneNumber=findViewById(R.id.aca_tiet_userPhoneNumber);
        viewModelCheckUserVerify=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelCheckUserVerify.class);
    }
}
