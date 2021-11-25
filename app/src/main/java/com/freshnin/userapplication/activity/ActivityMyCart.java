package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterMyCartItemListRecy;
import com.freshnin.userapplication.callbacks.AdapterMyCartItemListRecyCallBacks;
import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.viewmodel.ViewModelMyCartItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityMyCart extends AppCompatActivity implements AdapterMyCartItemListRecyCallBacks{

    private Toolbar toolbar;
    private RecyclerView myCartRecyclerView;
    private AdapterMyCartItemListRecy adapterMyCartItemListRecy;
    private List<ModelMyCartItem> myCartItemList;
    private ConstraintLayout btnCheckOut;

    private ViewModelMyCartItem myCartItemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        toolbar=findViewById(R.id.amc_cart_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        myCartRecyclerView=findViewById(R.id.amc_myCart_recyclerView);
        initList();

        myCartRecyclerView.setLayoutManager(new LinearLayoutManager(ActivityMyCart.this));
        adapterMyCartItemListRecy=new AdapterMyCartItemListRecy(
                myCartItemList,ActivityMyCart.this, (AdapterMyCartItemListRecyCallBacks) ActivityMyCart.this);
        myCartRecyclerView.setAdapter(adapterMyCartItemListRecy);

        btnCheckOut=findViewById(R.id.amc_btnConstrain);
        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ActivityMyCart.this,ActivityCheckOut.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        myCartItemViewModel.getAllMyCartItem().observe(this, new Observer<List<ModelMyCartItem>>() {
            @Override
            public void onChanged(List<ModelMyCartItem> modelMyCartItems) {
                myCartItemList.clear();
                myCartItemList.addAll(modelMyCartItems);
                adapterMyCartItemListRecy.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDeleteClicked(ModelMyCartItem myCartItem, int position) {
        myCartItemViewModel.deleteMyCartItemById(myCartItem.id);
        myCartItemViewModel.getAllMyCartItem();
    }


    private void initList() {
        myCartItemViewModel = new ViewModelProvider(this).get(ViewModelMyCartItem.class);
        myCartItemList = new ArrayList<>();
        myCartItemViewModel.insertNewMyCartItem(new ModelMyCartItem(
                "Bogurar Doi",
                "200 Tk",
                "3"
        ));
        myCartItemViewModel.insertNewMyCartItem(new ModelMyCartItem(
                "Khirsha",
                "330 Tk",
                "1"
        ));
        myCartItemViewModel.insertNewMyCartItem(new ModelMyCartItem(
                "malai kari",
                "200 Tk",
                "2"
        ));
        myCartItemViewModel.insertNewMyCartItem(new ModelMyCartItem(
                "Bogurar Doi",
                "200 Tk",
                "3"
        ));
    }
}