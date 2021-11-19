package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.model.ModelUserVerify;
import com.freshnin.userapplication.viewholder.ViewModelCheckUserVerify;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class ActivityCreateAccount extends AppCompatActivity {

    private Button btnSendOtp;
    private TextInputEditText tietUserPhoneNumber;
    private ViewModelCheckUserVerify viewModelCheckUserVerify;
    private FirebaseAuth mAuth;
    private static final String TAG = "ActivityCreateAccount";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        init();


       /* btnSendOtp.setOnClickListener(new View.OnClickListener() {
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
        });*/
        sendOTP();
    }

    private void sendOTP() {
//             Intent intent =new Intent(ActivityCreateAccount.this, ActivityOTPVerification.class);
//             intent.putExtra("userPhoneNumber",tietUserPhoneNumber.getText().toString());
//             startActivity(intent);

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+8801774201312")       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    void init(){
        btnSendOtp=findViewById(R.id.aca_btn_send_otp);
        tietUserPhoneNumber=findViewById(R.id.aca_tiet_userPhoneNumber);
        mAuth=FirebaseAuth.getInstance();
        viewModelCheckUserVerify=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelCheckUserVerify.class);
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(PhoneAuthCredential credential) {
            // This callback will be invoked in two situations:
            // 1 - Instant verification. In some cases the phone number can be instantly
            //     verified without needing to send or enter a verification code.
            // 2 - Auto-retrieval. On some devices Google Play services can automatically
            //     detect the incoming verification SMS and perform verification without
            //     user action.
            Log.d(TAG, "onVerificationCompleted:" + credential);

            //signInWithPhoneAuthCredential(credential);
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            // This callback is invoked in an invalid request for verification is made,
            // for instance if the the phone number format is not valid.
            Log.w(TAG, "onVerificationFailed", e);

            if (e instanceof FirebaseAuthInvalidCredentialsException) {
                // Invalid request
            } else if (e instanceof FirebaseTooManyRequestsException) {
                // The SMS quota for the project has been exceeded
            }

            // Show a message and update the UI
        }

        @Override
        public void onCodeSent(@NonNull String verificationId,
                @NonNull PhoneAuthProvider.ForceResendingToken token) {
            // The SMS verification code has been sent to the provided phone number, we
            // now need to ask the user to enter the code and then construct a credential
            // by combining the code with a verification ID.
            Log.d(TAG, "onCodeSent:" + verificationId);

            // Save verification ID and resending token so we can use them later
//            mVerificationId = verificationId;
//            mResendToken = token;
        }
    };


}
