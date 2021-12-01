package com.freshnin.userapplication.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterPreOrderHistoryRecy;
import com.freshnin.userapplication.callbacks.AdapterPreOrderHistoryRecycCallbacks;
import com.freshnin.userapplication.model.ModelOngoingOrder;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.tools.GlobalKey;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelPreOrderItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityPreOrderHistory extends AppCompatActivity implements AdapterPreOrderHistoryRecycCallbacks {

    private Toolbar toolbar;
    private RecyclerView preOrderHistoryRecy;
    private AdapterPreOrderHistoryRecy adapterPreOrderHistoryRecy;
    private List<ModelOngoingOrder> preOrderHistoryList;

    private ViewModelPreOrderItem viewModelPreOrderItem;
    private ModelUser userId;

    private Dialog dialogLoading;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_history);

        init();


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllPreOrder();
    }

    private void getAllPreOrder() {
        dialogLoading.show();
        viewModelPreOrderItem.getOngoingPreOrderInformationByUser(userId).observe(this, new Observer<List<ModelOngoingOrder>>() {
            @Override
            public void onChanged(List<ModelOngoingOrder> modelOngoingOrders) {
                if(modelOngoingOrders!=null){

                    preOrderHistoryList.clear();
                    preOrderHistoryList.addAll(modelOngoingOrders);
                    adapterPreOrderHistoryRecy.notifyDataSetChanged();
                    dialogLoading.dismiss();

                }else{
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityPreOrderHistory.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        toolbar=findViewById(R.id.apoh_preOrder_history_list_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        preOrderHistoryList=new ArrayList<>();

        preOrderHistoryRecy=findViewById(R.id.apoh_preOrderHistoryRecy);
        preOrderHistoryRecy.setLayoutManager(new LinearLayoutManager(ActivityPreOrderHistory.this));
        adapterPreOrderHistoryRecy=new AdapterPreOrderHistoryRecy(preOrderHistoryList, ActivityPreOrderHistory.this, ActivityPreOrderHistory.this);
        preOrderHistoryRecy.setAdapter(adapterPreOrderHistoryRecy);



        userId=new ModelUser(GlobalKey.USER_ID);

        viewModelPreOrderItem= new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelPreOrderItem.class);
        dialogLoading= Utils.setupLoadingDialog(ActivityPreOrderHistory.this);

    }


    @Override
    public void onDetailsClicked(int index) {
        Intent gotoPreOrderDetails =new Intent(ActivityPreOrderHistory.this,ActivityPreOrderDetails.class);
        //gotoHLogin.putExtra("key_int_value",152);
        gotoPreOrderDetails.putExtra("parcel",preOrderHistoryList.get(index));
        startActivity(gotoPreOrderDetails);


    }
}
