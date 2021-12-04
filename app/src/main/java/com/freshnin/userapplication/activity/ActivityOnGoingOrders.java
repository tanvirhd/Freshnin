package com.freshnin.userapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterOnGoingOrdersRecy;
import com.freshnin.userapplication.callbacks.AdapterOnGoingOrdersRecycCallBacks;
import com.freshnin.userapplication.model.ModelOnGoingOrder;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.tools.GlobalKey;
import com.freshnin.userapplication.tools.Utils;
import com.freshnin.userapplication.viewmodel.ViewModelRegularItem;

import java.util.ArrayList;
import java.util.List;

public class ActivityOnGoingOrders extends AppCompatActivity implements AdapterOnGoingOrdersRecycCallBacks{

    private Toolbar toolbar;
    private List<ModelOnGoingOrder> onGoingOrderList;
    private List<ModelRegularItem> onGoingOrderProductList;
    private RecyclerView onGoingOrderRecy;
    private AdapterOnGoingOrdersRecy adapterOnGoingOrdersRecy;

    private ViewModelRegularItem viewModelRegularItem;
    private ModelUser modelUser;
    private Dialog dialogLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_going_orders);

        init();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getOngoingOrderInformationByUser();

    }



    void init(){
        toolbar=findViewById(R.id.aogo_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        onGoingOrderList=new ArrayList<>();
        onGoingOrderProductList=new ArrayList<>();

        onGoingOrderRecy=findViewById(R.id.aogo_on_oging_order_recy);

        onGoingOrderRecy.setLayoutManager(new LinearLayoutManager(ActivityOnGoingOrders.this));
        adapterOnGoingOrdersRecy=new AdapterOnGoingOrdersRecy(
                onGoingOrderList,onGoingOrderProductList,ActivityOnGoingOrders.this, (AdapterOnGoingOrdersRecycCallBacks) ActivityOnGoingOrders.this);
        onGoingOrderRecy.setAdapter(adapterOnGoingOrdersRecy);

        viewModelRegularItem=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelRegularItem.class);
        dialogLoading= Utils.setupLoadingDialog(this);
        modelUser=new ModelUser(Utils.getPref(GlobalKey.USER_ID,""));
    }

    private void getOngoingOrderInformationByUser() {
        dialogLoading.show();
        viewModelRegularItem.getOngoingOrderInformationByUser(modelUser).observe(this, new Observer<List<ModelOnGoingOrder>>() {
            @Override
            public void onChanged(List<ModelOnGoingOrder> modelOnGoingOrders) {
                if(modelOnGoingOrders!=null){
                    dialogLoading.dismiss();
                    onGoingOrderList.clear();
                    onGoingOrderProductList.clear();

                    onGoingOrderList.addAll(modelOnGoingOrders);
                    //onGoingOrderProductList.addAll(modelOnGoingOrders.);

                    adapterOnGoingOrdersRecy.notifyDataSetChanged();
                }else{
                    dialogLoading.dismiss();
                    Toast.makeText(ActivityOnGoingOrders.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onDetailsClicked(int index) {
        Intent intent=new Intent(ActivityOnGoingOrders.this,ActivityOnGoingOrderDetails.class);
        intent.putExtra("parcel-1",onGoingOrderList.get(index));
        intent.putExtra("parcel-2",onGoingOrderProductList.get(index));
        startActivity(intent);
    }

}