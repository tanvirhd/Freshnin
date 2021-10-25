package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Display;
import android.view.View;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterOnGoingOrdersRecy;
import com.freshnin.userapplication.model.ModelOrder;

import java.util.ArrayList;
import java.util.List;

public class ActivityOnGoingOrders extends AppCompatActivity {

    private Toolbar toolbar;
    private List<ModelOrder> onGoingOrderList;
    private List<ModelOrder> onGoingOrderProductList;
    private RecyclerView onGoingOrderRecy;
    private AdapterOnGoingOrdersRecy adapterOnGoingOrdersRecy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_going_orders);

        initList();

        toolbar=findViewById(R.id.aogo_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        onGoingOrderRecy=findViewById(R.id.aogo_on_oging_order_recy);

        onGoingOrderRecy.setLayoutManager(new LinearLayoutManager(ActivityOnGoingOrders.this));
        adapterOnGoingOrdersRecy=new AdapterOnGoingOrdersRecy(onGoingOrderList,onGoingOrderProductList,ActivityOnGoingOrders.this);
        onGoingOrderRecy.setAdapter(adapterOnGoingOrdersRecy);


    }

    void initList(){
        onGoingOrderList=new ArrayList<>();
        onGoingOrderList.add(new ModelOrder(
                "Pre1231"
        ));

        onGoingOrderList.add(new ModelOrder(
                "Pre5345"
        ));

        onGoingOrderList.add(new ModelOrder(
                "Pre1876"
        ));

        onGoingOrderList.add(new ModelOrder(
                "Pre3445"
        ));

        onGoingOrderList.add(new ModelOrder(
                "Pre3457"
        ));

        onGoingOrderProductList=new ArrayList<>();
        onGoingOrderProductList.add(new ModelOrder(
                "Bogurar Doi",
                "03"
        ));

        onGoingOrderProductList.add(new ModelOrder(
                "Bogurar Khirsha",
                "06"
        ));

    }
}