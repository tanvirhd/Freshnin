package com.freshnin.userapplication.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterPreOrderHistoryRecy;
import com.freshnin.userapplication.model.ModelPreOrderHistory;

import java.util.ArrayList;
import java.util.List;

public class ActivityPreOrderHistory extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView preOrderHistoryRecy;
    private AdapterPreOrderHistoryRecy adapterPreOrderHistoryRecy;
    private List<ModelPreOrderHistory> preOrderHistoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_history);

        toolbar=findViewById(R.id.preOrder_history_list_main_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initList();

        preOrderHistoryRecy=findViewById(R.id.preOrderHistoryRecy);
        preOrderHistoryRecy.setLayoutManager(new LinearLayoutManager(ActivityPreOrderHistory.this));

        adapterPreOrderHistoryRecy=new AdapterPreOrderHistoryRecy(preOrderHistoryList,ActivityPreOrderHistory.this);
        preOrderHistoryRecy.setAdapter(adapterPreOrderHistoryRecy);
    }

    private void initList() {
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


    }
}
