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
import com.freshnin.userapplication.adapter.AdapterPreOrderFoodRecy;
import com.freshnin.userapplication.callbacks.AdapterPreOrderFoodRecycCallBacks;
import com.freshnin.userapplication.model.ModelPreOrderFood;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelPreOrderItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityPreOrderFoodList extends AppCompatActivity implements AdapterPreOrderFoodRecycCallBacks {

    private Toolbar toolbar;
    private RecyclerView preOrderFoodRecy;
    private AdapterPreOrderFoodRecy adapterPreOrderFoodRecy;
    private List<ModelPreOrderItem> preOrderFoodList;
    private Dialog loadingDialog;

    ViewModelPreOrderItem viewModelPreOrderItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_item_list);
        init();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        getAllPreOrderActiveSession();
    }

    private void init() {
        toolbar=findViewById(R.id.apofl_preOrder_list_toolbar);
        setSupportActionBar(toolbar);
        viewModelPreOrderItem=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelPreOrderItem.class);

        preOrderFoodList=new ArrayList<>();
        preOrderFoodRecy=findViewById(R.id.apofl_pre_Order_FoodRecy);
        preOrderFoodRecy.setLayoutManager(new LinearLayoutManager(ActivityPreOrderFoodList.this));

        adapterPreOrderFoodRecy=new AdapterPreOrderFoodRecy(preOrderFoodList,ActivityPreOrderFoodList.this,ActivityPreOrderFoodList.this);
        preOrderFoodRecy.setAdapter(adapterPreOrderFoodRecy);

        loadingDialog= Utils.setupLoadingDialog(ActivityPreOrderFoodList.this);
    }

    void  getAllPreOrderActiveSession(){
        loadingDialog.show();
        viewModelPreOrderItem.getAllActivePreOrderSession().observe(this, new Observer<List<ModelPreOrderItem>>() {
            @Override
            public void onChanged(List<ModelPreOrderItem> modelPreOrderItems) {
                if(modelPreOrderItems != null){
                    preOrderFoodList.clear();
                    preOrderFoodList.addAll(modelPreOrderItems);
                    adapterPreOrderFoodRecy.notifyDataSetChanged();
                    loadingDialog.dismiss();
                }else{
                    loadingDialog.dismiss();
                    Toast.makeText(ActivityPreOrderFoodList.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemClick(int index) {
        Intent intent=new Intent(ActivityPreOrderFoodList.this, ActivityPreOrderProductDetails.class);
        intent.putExtra("parcel",preOrderFoodList.get(index));
        startActivity(intent);
    }
}
