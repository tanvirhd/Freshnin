package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterOldOrderHistoryRecy;
import com.freshnin.userapplication.callbacks.AdapterOldOrderHistoryRecycCallBacks;
import com.freshnin.userapplication.model.ModelOrder;

import java.util.ArrayList;
import java.util.List;

public class ActivityOldOrderHistory extends AppCompatActivity implements AdapterOldOrderHistoryRecycCallBacks {

    private Toolbar toolbar;
    private AdapterOldOrderHistoryRecy adapterOldOrderHistoryRecy;
    private List<ModelOrder> oldOrderHistoryList;
    private List<ModelOrder> oldOrderHistoryProductList;
    private RecyclerView oldOrderHistoryRecy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_order_history);

        initList();

        toolbar=findViewById(R.id.aooh_Old_list_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        oldOrderHistoryRecy=findViewById(R.id.aooh_recyclerView_orderHistory);

        oldOrderHistoryRecy.setLayoutManager(new LinearLayoutManager(ActivityOldOrderHistory.this));
        adapterOldOrderHistoryRecy=new AdapterOldOrderHistoryRecy(
                oldOrderHistoryList,oldOrderHistoryProductList,ActivityOldOrderHistory.this,ActivityOldOrderHistory.this);
        oldOrderHistoryRecy.setAdapter(adapterOldOrderHistoryRecy);
    }

    void initList(){
        oldOrderHistoryList=new ArrayList<>();
        /*oldOrderHistoryList.add(new ModelOrder(
                "Pre1231"
        ));

        oldOrderHistoryList.add(new ModelOrder(
                "Pre5345"
        ));

        oldOrderHistoryList.add(new ModelOrder(
                "Pre1876"
        ));

        oldOrderHistoryList.add(new ModelOrder(
                "Pre3445"
        ));

        oldOrderHistoryList.add(new ModelOrder(
                "Pre3457"
        ));*/

        oldOrderHistoryProductList=new ArrayList<>();
        /*oldOrderHistoryProductList.add(new ModelOrder(
                "Bogurar Doi",
                "03"
        ));

        oldOrderHistoryProductList.add(new ModelOrder(
                "Bogurar Khirsha",
                "06"
        ));

        oldOrderHistoryProductList.add(new ModelOrder(
                "Chomchom",
                "02"
        ));*/
    }

    @Override
    public void onOrderAgainClicked(int index) {
        Intent intent=new Intent(ActivityOldOrderHistory.this,ActivityCheckOut.class);
        startActivity(intent);
    }
}