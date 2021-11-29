package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.tools.GlobalKey;
import com.freshnin.userapplication.tools.Utils;

public class ActivitySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if(Utils.getPrefBoolean(GlobalKey.IS_LOGGED_IN,false)){
                    startActivity(new Intent(ActivitySplashScreen.this, ActivityHome.class));
                    finish();
                }else {
                    startActivity(new Intent(ActivitySplashScreen.this, ActivityLogIn.class));
                    finish();
                }
            }
        }, 2000);
    }
}