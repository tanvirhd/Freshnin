package com.freshnin.userapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterPreOrderHistoryRecy;
import com.freshnin.userapplication.callbacks.AdapterPreOrderHistoryRecycCallbacks;
import com.freshnin.userapplication.model.ModelCreateNewPreOrder;

import java.util.List;

public class ActivityPreOrderHistory extends AppCompatActivity implements AdapterPreOrderHistoryRecycCallbacks {

    private Toolbar toolbar;
    private RecyclerView preOrderHistoryRecy;
    private AdapterPreOrderHistoryRecy adapterPreOrderHistoryRecy;
    private List<ModelCreateNewPreOrder> preOrderHistoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_history);

        toolbar=findViewById(R.id.apoh_preOrder_history_list_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        //initList();

        preOrderHistoryRecy=findViewById(R.id.apoh_preOrderHistoryRecy);
        preOrderHistoryRecy.setLayoutManager(new LinearLayoutManager(ActivityPreOrderHistory.this));

        adapterPreOrderHistoryRecy=new AdapterPreOrderHistoryRecy(
                preOrderHistoryList, ActivityPreOrderHistory.this, ActivityPreOrderHistory.this);
        preOrderHistoryRecy.setAdapter(adapterPreOrderHistoryRecy);
    }

    /*private void initList() {
        preOrderHistoryList=new ArrayList<>();

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre3242",
                "Bogurar Doi",
                "24 Sep 2021",
                "Verification Pending"
        ));

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre3213",
                "Bogurar Khirsha",
                "9 Sep 2021",
                "Verified"
        ));

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre1238",
                "Bogurar Doi",
                "2 Oct 2021",
                "Verification Prending"
        ));

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre3242",
                "Bogurar Doi",
                "24 Sep 2021",
                "Verification Prending"
        ));

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre3242",
                "Bogurar Doi",
                "24 Sep 2021",
                "Verification Prending"
        ));

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre3242",
                "Bogurar Doi",
                "24 Sep 2021",
                "Verification Pending"
        ));

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre3213",
                "Bogurar Khirsha",
                "9 Sep 2021",
                "Verified"
        ));

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre1238",
                "Bogurar Doi",
                "2 Oct 2021",
                "Verification Prending"
        ));

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre3242",
                "Bogurar Doi",
                "24 Sep 2021",
                "Verification Prending"
        ));

        preOrderHistoryList.add(new ModelPreOrderHistory(
                "Pre3242",
                "Bogurar Doi",
                "24 Sep 2021",
                "Verification Prending"
        ));


    }*/


    @Override
    public void onDetailsClicked(int index) {
        Intent gotoPreOrderDetails =new Intent(ActivityPreOrderHistory.this,ActivityPreOrderDetails.class);
        //gotoHLogin.putExtra("key_int_value",152);
        startActivity(gotoPreOrderDetails);
    }
}
