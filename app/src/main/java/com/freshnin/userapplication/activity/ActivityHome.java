package com.freshnin.userapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.freshnin.userapplication.R;
import com.google.android.material.navigation.NavigationView;

public class ActivityHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView btnCloseNavDrawer;

    private Button btnPreOrderGoingOn;
    private Button btnFoodItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar=findViewById(R.id.ah_home_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.ah_home_drawer_layout);
        navigationView=findViewById(R.id.ah_home_nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



        btnPreOrderGoingOn=findViewById(R.id.ah_btn_goto_preOrderOnGoing);
        btnFoodItem=findViewById(R.id.ah_btn_gotoFoodItem);

        btnPreOrderGoingOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHome.this, ActivityPreOrderFoodList.class);
                startActivity(intent);
            }
        });

        btnFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityHome.this, ActivityFoodItemList.class);
                startActivity(intent);
            }
        });


        // Need to fix
//        btnCloseNavDrawer=(ImageView) findViewById(R.id.ah_btn_close_nav_drawer);
//        btnCloseNavDrawer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_goto_profile:
                break;

            case R.id.nav_goto_myCart:
                Intent intentMyCart = new Intent(ActivityHome.this, ActivityMyCart.class);
                startActivity(intentMyCart);
                break;

            case R.id.nav_goto_preOrder:
                Intent intentPreOrder = new Intent(ActivityHome.this, ActivityPreOrderHistory.class);
                startActivity(intentPreOrder);
                break;

            case R.id.nav_goto_onGoingOrder:
                Intent intentOnGoingOrder = new Intent(ActivityHome.this, ActivityOnGoingOrders.class);
                startActivity(intentOnGoingOrder);
                break;

            case R.id.nav_goto_oldOrder:
                Intent intentOldOrder = new Intent(ActivityHome.this, ActivityOldOrderHistory.class);
                startActivity(intentOldOrder);
                break;

            case R.id.nav_goto_favourite:
                Intent intentFavourite = new Intent(ActivityHome.this, ActivityFavouriteItem.class);
                startActivity(intentFavourite);
                break;

            case R.id.nav_goto_contuctUs:
                break;

            case R.id.nav_goto_aboutUs:
                break;

        }

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}