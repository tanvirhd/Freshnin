package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.freshnin.userapplication.R;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ActivityVerification extends AppCompatActivity {

    private TextView mResendOtp;
    private TextView mOtpTimeCountdown;
    private Button btnVerifyOtp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varification);

        mResendOtp=findViewById(R.id.tv_resend_otp);
        mOtpTimeCountdown=findViewById(R.id.tv_otp_countdown);
        btnVerifyOtp=findViewById(R.id.btnVarify);

        btnVerifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityVerification.this, ActivityRegistrationWithDetails.class);
                startActivity(intent);
            }
        });

        otpTimer();
        mResendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otpTimer();
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
}
