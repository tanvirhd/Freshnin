package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelNewUserRegistration;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.tools.GlobalKey;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelUser;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityRegistrationWithDetails extends AppCompatActivity {

    private Button btnRegiConfirm;
    private TextInputEditText tietUserName;
    private TextInputEditText tietUserPassWord;
    private TextInputEditText tietReTypePassword;
    private ViewModelUser viewModelUser;

    String userPhoneNumber="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_with_details);

        init();

       /* btnRegiConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.savePrefBoolean(GlobalKey.IS_LOGGED_IN,true);
                Utils.savePref(GlobalKey.USER_ID,userPhoneNumber);
                Intent intent=new Intent(ActivityRegistrationWithDetails.this,  ActivityHome.class);
                startActivity(intent); finish();
            }
        });*/

        btnRegiConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tietUserName.getText().toString()==null || tietUserPassWord.getText().toString()==null
                        || tietReTypePassword.getText().toString()==null){
                    Toast.makeText(ActivityRegistrationWithDetails.this, "Fill up all fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(tietUserPassWord.getText().toString().contentEquals(tietReTypePassword.getText().toString())){
                        viewModelUser.newUserRegistration(new ModelUser(
                                tietUserName.getText().toString(),
                                getIntent().getStringExtra("userPhoneNumber"),
                                tietUserPassWord.getText().toString(),
                                "google.com"
                        )).observe(ActivityRegistrationWithDetails.this, new Observer<ModelNewUserRegistration>() {
                            @Override
                            public void onChanged(ModelNewUserRegistration modelNewUserRegistration) {
                                if(modelNewUserRegistration==null){
                                    Toast.makeText(ActivityRegistrationWithDetails.this, "Something Went Wrong!", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(ActivityRegistrationWithDetails.this, "Registration Successful", Toast.LENGTH_SHORT).show();



                                    Utils.savePrefBoolean(GlobalKey.IS_LOGGED_IN,true);
                                    Utils.savePref(GlobalKey.USER_ID,userPhoneNumber);
                                    Intent intent=new Intent(ActivityRegistrationWithDetails.this,  ActivityHome.class);
                                    startActivity(intent);
                                }
                            }
                        });

                    }else{
                       Toast.makeText(ActivityRegistrationWithDetails.this, "Re-type field doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void init(){
        tietUserName=findViewById(R.id.arwd_userName);
        tietUserPassWord=findViewById(R.id.arwd_userPassword);
        tietReTypePassword=findViewById(R.id.arwd_ReTypePassword);
        viewModelUser =new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelUser.class);
        btnRegiConfirm=findViewById(R.id.arwd_btnRegConfirm);

        userPhoneNumber= getIntent().getStringExtra("userPhoneNumber");
    }
}