package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chaos.view.PinView;
import com.freshnin.userapplication.R;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ActivityOTPVerification extends AppCompatActivity {

    private static final String TAG = "ActivityVerification";

    private TextView mResendOtp;
    private TextView mOtpTimeCountdown;
    private Button btnVerifyOtp;
    private PinView otpPinView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_varification);
        init();

        String userPhoneNumber= getIntent().getStringExtra("userPhoneNumber");

        btnVerifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otpPinView.getText().toString().contentEquals("12345")){
                    Intent intent=new Intent(ActivityOTPVerification.this, ActivityRegistrationWithDetails.class);
                    intent.putExtra("userPhoneNumber",userPhoneNumber);
                    startActivity(intent);
                }else{
                    Toast.makeText(ActivityOTPVerification.this, "Wrong OTP "+otpPinView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        otpTimer();
        mResendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpTimer();
            }
        });

        otpPinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "onTextChanged: "+s.toString()+" Start="+ String.valueOf(start)+ " After= "+String.valueOf(after)
                        +" Count= "+String.valueOf(count));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: "+s.toString()+" Start="+ String.valueOf(start)+ " Before= "+String.valueOf(before)
                +" Count= "+String.valueOf(count));
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "afterTextChanged: "+s.toString());
            }
        });


    }

    void otpTimer(){
        long timeDuration = TimeUnit.MINUTES.toMillis(1);

        new CountDownTimer(timeDuration,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                mResendOtp.setVisibility(View.GONE);
                mOtpTimeCountdown.setVisibility(View.VISIBLE);

                String sDuration =String.format(Locale.ENGLISH,"%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                mOtpTimeCountdown.setText(sDuration);
            }

            @Override
            public void onFinish() {
                mOtpTimeCountdown.setVisibility(View.GONE);
                mResendOtp.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    void init(){
        mResendOtp=findViewById(R.id.aotpv_tv_resend_otp);
        mOtpTimeCountdown=findViewById(R.id.aotpv_tv_otp_countdown);
        btnVerifyOtp=findViewById(R.id.aotpv_btnVarify);
        otpPinView=findViewById(R.id.aotpv_pinViewOTP);
    }


}
