package com.freshnin.userapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterCanFoodListRecy;
import com.freshnin.userapplication.adapter.AdapterDryFoodListRecy;
import com.freshnin.userapplication.adapter.AdapterEdibleOilFoodListRecy;
import com.freshnin.userapplication.adapter.AdapterHerbalItemRecy;
import com.freshnin.userapplication.adapter.AdapterHoneyAndGheeListRecy;
import com.freshnin.userapplication.adapter.AdapterPreOrderGoingOnListRecy;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelPreOrderFood;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView btnCloseNavDrawer;
    private TextView tvPreOrderSeeAll;

    private RecyclerView preOrderRecy;
    private List<ModelPreOrderFood> preOrderFoodList;
    private AdapterPreOrderGoingOnListRecy adapterPreOrderGoingOnListRecy;

    private RecyclerView dryFoodRecy;
    private List<ModelFoodItem> dryFoodItemList;
    private AdapterDryFoodListRecy adapterDryFoodListRecy;

    private RecyclerView edibleOilFoodRecy;
    private List<ModelFoodItem> edibleFoodList;
    private AdapterEdibleOilFoodListRecy adapterEdibleOilFoodListRecy;

    private RecyclerView herbalItemRecy;
    private List<ModelFoodItem> herbalItemList;
    private AdapterHerbalItemRecy adapterHerbalItemRecy;

    private RecyclerView canFoodItemRecy;
    private List<ModelFoodItem> canFoodItemList;
    private AdapterCanFoodListRecy adapterCanFoodListRecy;

    private RecyclerView honeyAndGheeItemRecy;
    private List<ModelFoodItem> honeyAndGheeItemList;
    private AdapterHoneyAndGheeListRecy adapterHoneyAndGheeListRecy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initList();
        init();


        toolbar=findViewById(R.id.ah_home_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.ah_home_drawer_layout);
        navigationView=findViewById(R.id.ah_home_nav_view);
        tvPreOrderSeeAll=findViewById(R.id.ah_preOrder_seeAll);

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


        // Pre-Order RecyclerView Horizontal
        preOrderRecy.setLayoutManager(new LinearLayoutManager(ActivityHome.this,LinearLayoutManager.HORIZONTAL,false));
        preOrderRecy.setAdapter(adapterPreOrderGoingOnListRecy);

        // Dry Food RecyclerView
        dryFoodRecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        dryFoodRecy.setAdapter(adapterDryFoodListRecy);

        // Edible Food RecyclerView
        edibleOilFoodRecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        edibleOilFoodRecy.setAdapter(adapterEdibleOilFoodListRecy);

        // Herbal Item RecyclerView
        herbalItemRecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        herbalItemRecy.setAdapter(adapterHerbalItemRecy);

        // Can Food Item RecyclerView
        canFoodItemRecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        canFoodItemRecy.setAdapter(adapterCanFoodListRecy);

        // Honey And Ghee Item RecyclerView
        honeyAndGheeItemRecy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        honeyAndGheeItemRecy.setAdapter(adapterHoneyAndGheeListRecy);



//        btnPreOrderGoingOn=findViewById(R.id.ah_btn_goto_preOrderOnGoing);
//        btnFoodItem=findViewById(R.id.ah_btn_gotoFoodItem);

        /*btnPreOrderGoingOn.setOnClickListener(new View.OnClickListener() {
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
        });*/


        // Need to fix
        /*btnCloseNavDrawer=(ImageView) findViewById(R.id.ah_btn_close_nav_drawer);
        btnCloseNavDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        // all onClick action
        tvPreOrderSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityHome.this,ActivityPreOrderFoodList.class));
            }
        });

    }


    public void init(){
        preOrderRecy=findViewById(R.id.ah_preOrder_recyclerView);
        adapterPreOrderGoingOnListRecy =new AdapterPreOrderGoingOnListRecy(preOrderFoodList,this);

        dryFoodRecy=findViewById(R.id.ah_dryFood_recyclerView);
        adapterDryFoodListRecy =new AdapterDryFoodListRecy(dryFoodItemList,this);

        edibleOilFoodRecy=findViewById(R.id.ah_edibleOil_recyclerView);
        adapterEdibleOilFoodListRecy=new AdapterEdibleOilFoodListRecy(edibleFoodList,this);

        herbalItemRecy=findViewById(R.id.ah_herbalItem_recyclerView);
        adapterHerbalItemRecy=new AdapterHerbalItemRecy(herbalItemList,this);

        canFoodItemRecy=findViewById(R.id.ah_canFood_recyclerView);
        adapterCanFoodListRecy=new AdapterCanFoodListRecy(canFoodItemList,this);

        honeyAndGheeItemRecy=findViewById(R.id.ah_HoneyAndGhee_recyclerView);
        adapterHoneyAndGheeListRecy=new AdapterHoneyAndGheeListRecy(honeyAndGheeItemList,this);
    }

    public void initList(){
        preOrderFoodList=new ArrayList<>();
        preOrderFoodList.add(new ModelPreOrderFood(
                R.drawable.food_bogurar_doi
        ));
        preOrderFoodList.add(new ModelPreOrderFood(
                R.drawable.food_bogurar_khirsha
        ));
        preOrderFoodList.add(new ModelPreOrderFood(
                R.drawable.food_bogurar_doi
        ));
        preOrderFoodList.add(new ModelPreOrderFood(
                R.drawable.food_bogurar_doi
        ));
        preOrderFoodList.add(new ModelPreOrderFood(
                R.drawable.food_bogurar_khirsha
        ));
        preOrderFoodList.add(new ModelPreOrderFood(
                R.drawable.food_bogurar_khirsha
        ));
        preOrderFoodList.add(new ModelPreOrderFood(
                R.drawable.food_bogurar_doi
        ));
        preOrderFoodList.add(new ModelPreOrderFood(
                R.drawable.food_bogurar_khirsha
        ));



        dryFoodItemList=new ArrayList<>();
        dryFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        dryFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        dryFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        dryFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        dryFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        dryFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));


        edibleFoodList=new ArrayList<>();
        edibleFoodList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        edibleFoodList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        edibleFoodList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        edibleFoodList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        edibleFoodList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        edibleFoodList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        edibleFoodList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));



        herbalItemList=new ArrayList<>();
        herbalItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        herbalItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        herbalItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        herbalItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        herbalItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        herbalItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        herbalItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));



        canFoodItemList=new ArrayList<>();
        canFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        canFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        canFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        canFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        canFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));canFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        canFoodItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));


        honeyAndGheeItemList=new ArrayList<>();
        honeyAndGheeItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        honeyAndGheeItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        honeyAndGheeItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        honeyAndGheeItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        honeyAndGheeItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_khirsha
        ));
        honeyAndGheeItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));
        honeyAndGheeItemList.add(new ModelFoodItem(
                R.drawable.food_bogurar_doi
        ));


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
                Intent intentFavourite = new Intent(ActivityHome.this, ActivityFavouriteFood.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_activity_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.ah_cartIcon:
                Intent intentMyCart = new Intent(ActivityHome.this, ActivityMyCart.class);
                startActivity(intentMyCart);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}