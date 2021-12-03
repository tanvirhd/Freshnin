package com.freshnin.userapplication.activity;



import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterDryFoodListRecy;
import com.freshnin.userapplication.adapter.AdapterEdibleOilFoodListRecy;
import com.freshnin.userapplication.adapter.AdapterHerbalItemRecy;
import com.freshnin.userapplication.adapter.AdapterHoneyAndGheeListRecy;
import com.freshnin.userapplication.adapter.AdapterPreOrderGoingOnListRecy;
import com.freshnin.userapplication.callbacks.AdapterDryFoodListRecyCallBacks;
import com.freshnin.userapplication.callbacks.AdapterEdibleOilFoodListRecyCallBacks;
import com.freshnin.userapplication.callbacks.AdapterHerbalItemRecyCallBacks;
import com.freshnin.userapplication.callbacks.AdapterHoneyAndGheeListRecyCallBacks;
import com.freshnin.userapplication.callbacks.AdapterPreOrderGoingOnListRecyCallBacks;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.viewmodel.ViewModelPreOrderItem;
import com.freshnin.userapplication.viewmodel.ViewModelRegularItem;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        AdapterPreOrderGoingOnListRecyCallBacks,AdapterDryFoodListRecyCallBacks,AdapterHerbalItemRecyCallBacks,
        AdapterEdibleOilFoodListRecyCallBacks,AdapterHoneyAndGheeListRecyCallBacks {

    private static final String TAG = "ActivityHome";

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView btnCloseNavDrawer;
    private TextView tvPreOrderSeeAll;
    private TextView tvDryFoodSeeAll;
    private TextView tvEdibleOilSeeAll;
    private TextView tvHerbalItemSeeAll;
    private TextView tvHoneyAndGheeSeeAll;

    private RecyclerView preOrderRecy;
    private List<ModelPreOrderItem> preOrderFoodList;
    private AdapterPreOrderGoingOnListRecy adapterPreOrderGoingOnListRecy;
    private ViewModelPreOrderItem viewModelPreOrderOnGoingItem;
    private ViewModelRegularItem viewModelRegularItem;



    private Map<String,List<ModelRegularItem>> mapOfRegularItems=new HashMap<String,List<ModelRegularItem>>();

    private RecyclerView dryFoodRecy;
    private List<ModelRegularItem> dryFoodItemList;
    private AdapterDryFoodListRecy adapterDryFoodListRecy;

    private RecyclerView edibleOilFoodRecy;
    private List<ModelRegularItem> edibleFoodList;
    private AdapterEdibleOilFoodListRecy adapterEdibleOilFoodListRecy;

    private RecyclerView herbalItemRecy;
    private List<ModelRegularItem> herbalItemList;
    private AdapterHerbalItemRecy adapterHerbalItemRecy;

    private RecyclerView honeyAndGheeItemRecy;
    private List<ModelRegularItem> honeyAndGheeItemList;
    private AdapterHoneyAndGheeListRecy adapterHoneyAndGheeListRecy;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initList();
        init();


        toolbar=findViewById(R.id.ah_home_toolbar);
        setSupportActionBar(toolbar);


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

        tvDryFoodSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dryFoodIntent = new Intent(ActivityHome.this,ActivityFoodItemList.class);
                dryFoodIntent.putExtra("foodId","dry-food");
                startActivity(dryFoodIntent);

                //startActivity(new Intent(ActivityHome.this,ActivityFoodItemList.class));

            }
        });

        tvEdibleOilSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edibleIntent = new Intent(ActivityHome.this,ActivityFoodItemList.class);
                edibleIntent.putExtra("foodId","edible-oil");
                startActivity(edibleIntent);
            }
        });

        tvHerbalItemSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent herbalIntent = new Intent(ActivityHome.this, ActivityFoodItemList.class);
                herbalIntent.putExtra("foodId", "harbal");
                startActivity(herbalIntent);}
        });

        tvHoneyAndGheeSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent honeyAndGheeIntent = new Intent(ActivityHome.this,ActivityFoodItemList.class);
                honeyAndGheeIntent.putExtra("foodId","modhu-ghee");
                startActivity(honeyAndGheeIntent);
            }
        });
    }

            @Override
            protected void onResume() {
                super.onResume();
                getAllRegularItem();
                getFirstFivePreOrderActiveSession();
            }

            private void getAllRegularItem() {
                viewModelRegularItem.getAllItem().observe(this, new Observer<List<ModelRegularItem>>() {
                    @Override
                    public void onChanged(List<ModelRegularItem> modelRegularItems) {
                        //Log.d(TAG, "onChanged: getAllItem()"+ modelRegularItems.size() );
                        if (modelRegularItems != null) {
                            mapOfRegularItems.clear();

                            for (ModelRegularItem item : modelRegularItems) {
                                if (mapOfRegularItems.containsKey(item.getProductCategory())) {
                                    mapOfRegularItems.get(item.getProductCategory()).add(item);
                                } else {
                                    List<ModelRegularItem> tempList = new ArrayList<>();
                                    tempList.add(item);
                                    mapOfRegularItems.put(item.getProductCategory(), tempList);
                                }
                            } //mapping

                            dryFoodItemList.clear();
                            dryFoodItemList.addAll(mapOfRegularItems.get("dry-food"));
                            adapterDryFoodListRecy.notifyDataSetChanged();

                            edibleFoodList.clear();
                            edibleFoodList.addAll(mapOfRegularItems.get("edible-oil"));
                            adapterEdibleOilFoodListRecy.notifyDataSetChanged();

                            herbalItemList.clear();
                            herbalItemList.addAll(mapOfRegularItems.get("harbal"));
                            adapterHerbalItemRecy.notifyDataSetChanged();

                            honeyAndGheeItemList.clear();
                            honeyAndGheeItemList.addAll(mapOfRegularItems.get("modhu-ghee"));
                            adapterHoneyAndGheeListRecy.notifyDataSetChanged();


                        } else {
                            Toast.makeText(ActivityHome.this, "Something went Wrong!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

            void getFirstFivePreOrderActiveSession() {
                viewModelPreOrderOnGoingItem.getAllActivePreOrderSession().observe(this, new Observer<List<ModelPreOrderItem>>() {
                    @Override
                    public void onChanged(List<ModelPreOrderItem> modelPreOrderItems) {
                        if (modelPreOrderItems != null) {
                            if (modelPreOrderItems.size() >= 5) {
                                preOrderFoodList.clear();
                                for (int i = 1; i <= 5; i++) {
                                    preOrderFoodList.set(i, modelPreOrderItems.get(i));
                                    adapterPreOrderGoingOnListRecy.notifyDataSetChanged();
                                }

                            } else {
                                preOrderFoodList.clear();
                                preOrderFoodList.addAll(modelPreOrderItems);
                                adapterPreOrderGoingOnListRecy.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(ActivityHome.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
    /*private void getFirstFiveDryFood() {
        viewModelRegularItem.getAllItemsByCategory(new ModelRegularItem("dry-food")).observe(this, new Observer<List<ModelRegularItem>>() {
            @Override
            public void onChanged(List<ModelRegularItem> modelRegularItems) {
                try{
                    dryFoodItemList.clear();
                    dryFoodItemList.addAll(modelRegularItems);
                    adapterDryFoodListRecy.notifyDataSetChanged();
                }catch(Exception e){
                    Log.d(TAG, "getFirstFiveDryFood: error"+e.getMessage());
                }
            }
        });

    }
    private void getFirstFiveEdibleOilFood() {
        viewModelRegularItem.getAllItemsByCategory(new ModelRegularItem("edible-oil")).observe(this, new Observer<List<ModelRegularItem>>() {
            @Override
            public void onChanged(List<ModelRegularItem> modelRegularItems) {
                try{
                    edibleFoodList.clear();
                    edibleFoodList.addAll(modelRegularItems);
                    adapterEdibleOilFoodListRecy.notifyDataSetChanged();

                }catch(Exception e){
                    Log.d(TAG, "getFirstFiveEdibleOilFood: error"+e.getMessage());
                }
            }
        });
    }
    private void getFirstFiveHerbalFood(){
        viewModelRegularItem.getAllItemsByCategory(new ModelRegularItem("harbal")).observe(this, new Observer<List<ModelRegularItem>>() {
            @Override
            public void onChanged(List<ModelRegularItem> modelRegularItems) {
                try{
                    herbalItemList.clear();
                    herbalItemList.addAll(modelRegularItems);
                    adapterHerbalItemRecy.notifyDataSetChanged();
                }catch (Exception e){
                    Log.d(TAG, "getFirstFiveHerbalFood: error"+e.getMessage());
                }
            }
        });
    }
    private void getFirstModhuGheeFood(){
        viewModelRegularItem.getAllItemsByCategory(new ModelRegularItem("modhu-ghee")).observe(this, new Observer<List<ModelRegularItem>>() {
            @Override
            public void onChanged(List<ModelRegularItem> modelRegularItems) {
                try{
                    honeyAndGheeItemList.clear();
                    honeyAndGheeItemList.addAll(modelRegularItems);
                    adapterHoneyAndGheeListRecy.notifyDataSetChanged();
                }catch (Exception e){
                    Log.d(TAG, "getFirstModhuGheeFood: error"+e.getMessage());
                }
            }
        });
    }*/

            public void init() {
                preOrderRecy = findViewById(R.id.ah_preOrder_recyclerView);
                adapterPreOrderGoingOnListRecy = new AdapterPreOrderGoingOnListRecy(preOrderFoodList, this, (AdapterPreOrderGoingOnListRecyCallBacks) this);
                viewModelPreOrderOnGoingItem = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelPreOrderItem.class);
                viewModelRegularItem = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelRegularItem.class);

                drawerLayout = findViewById(R.id.ah_home_drawer_layout);
                navigationView = findViewById(R.id.ah_home_nav_view);
                tvPreOrderSeeAll = findViewById(R.id.ah_preOrder_seeAll);
                tvDryFoodSeeAll = findViewById(R.id.ah_dryFood_seeAll);
                tvEdibleOilSeeAll = findViewById(R.id.ah_edibleOil_seeAll);
                tvHerbalItemSeeAll = findViewById(R.id.ah_herbalItem_seeAll);
                tvHoneyAndGheeSeeAll = findViewById(R.id.ah_honeyAndGhee_seeAll);


                dryFoodRecy = findViewById(R.id.ah_dryFood_recyclerView);
                adapterDryFoodListRecy = new AdapterDryFoodListRecy(dryFoodItemList, this, (AdapterDryFoodListRecyCallBacks) this);

                edibleOilFoodRecy = findViewById(R.id.ah_edibleOil_recyclerView);
                adapterEdibleOilFoodListRecy = new AdapterEdibleOilFoodListRecy(edibleFoodList, this, (AdapterEdibleOilFoodListRecyCallBacks) ActivityHome.this);

                herbalItemRecy = findViewById(R.id.ah_herbalItem_recyclerView);
                adapterHerbalItemRecy = new AdapterHerbalItemRecy(herbalItemList, this, (AdapterHerbalItemRecyCallBacks) this);


                honeyAndGheeItemRecy = findViewById(R.id.ah_HoneyAndGhee_recyclerView);
                adapterHoneyAndGheeListRecy = new AdapterHoneyAndGheeListRecy(honeyAndGheeItemList, this, (AdapterHoneyAndGheeListRecyCallBacks) this);


            }

            public void initList() {
                preOrderFoodList = new ArrayList<>();

                dryFoodItemList = new ArrayList<>();

                edibleFoodList = new ArrayList<>();

                herbalItemList = new ArrayList<>();

                honeyAndGheeItemList = new ArrayList<>();

            }

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
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
                getMenuInflater().inflate(R.menu.menu_activity_home, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.ah_cartIcon:
                        Intent intentMyCart = new Intent(ActivityHome.this, ActivityMyCart.class);
                        startActivity(intentMyCart);
                        return true;

                    default:
                        return super.onOptionsItemSelected(item);
                }
            }

            @Override
            public void onPreOrderItemClick(int index) {
                Intent intent = new Intent(this, ActivityPreOrderProductDetails.class);
                intent.putExtra("parcel", preOrderFoodList.get(index));
                startActivity(intent);
            }

    @Override
    public void onDryFoodItemClick(int index) {
        Intent dryFoodIntent=new Intent(ActivityHome.this,ActivityFoodItemDetails.class);
        dryFoodIntent.putExtra("parcel",dryFoodItemList.get(index));
        startActivity(dryFoodIntent);
    }

    @Override
    public void onHerbalItemClick(int index) {
        Intent herbalIntent=new Intent(this, ActivityFoodItemDetails.class);
        herbalIntent.putExtra("parcel",herbalItemList.get(index));
        startActivity(herbalIntent);
    }

    @Override
    public void onEdibleItemClick(int index) {
        Intent edivleOilIntent=new Intent(this, ActivityFoodItemDetails.class);
        edivleOilIntent.putExtra("parcel",edibleFoodList.get(index));
        startActivity(edivleOilIntent);
    }

    @Override
    public void onHoneyAndGheeItemClick(int index) {
        Intent honeyAndGheeIntent = new Intent(this, ActivityFoodItemDetails.class);
        honeyAndGheeIntent.putExtra("parcel",honeyAndGheeItemList.get(index));
        startActivity(honeyAndGheeIntent);
    }
}