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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.adapter.AdapterMyCartItemListRecy;
import com.freshnin.userapplication.callbacks.AdapterMyCartItemListRecyCallBacks;
import com.freshnin.userapplication.model.ModelCartItemWrapper;
import com.freshnin.userapplication.model.ModelMyCartItem;
import com.freshnin.userapplication.viewmodel.ViewModelMyCartItem;

import java.util.ArrayList;
import java.util.List;

public class  ActivityMyCart extends AppCompatActivity implements AdapterMyCartItemListRecyCallBacks{

    private static final String TAG = "ActivityMyCart";

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

        init();

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        myCartRecyclerView.setLayoutManager(new LinearLayoutManager(ActivityMyCart.this));
        adapterMyCartItemListRecy=new AdapterMyCartItemListRecy(myCartItemList,ActivityMyCart.this, (AdapterMyCartItemListRecyCallBacks) ActivityMyCart.this);
        myCartRecyclerView.setAdapter(adapterMyCartItemListRecy);


        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ModelCartItemWrapper wrapper=new ModelCartItemWrapper(myCartItemList);
                Intent intent=new Intent(ActivityMyCart.this,ActivityCheckOut.class);
                intent.putExtra("cart-data",wrapper);

                myCartItemViewModel.deleteAllItemFromMyCart();
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

    @Override
    public void onIncreaseClicked(int index) {
        int tempQuantity= Integer.parseInt(myCartItemList.get(index).getFoodQuantity());
        int price=Integer.parseInt(myCartItemList.get(index).getFoodPrice());
        price=price/tempQuantity;

        myCartItemList.get(index).setFoodQuantity((++tempQuantity)+"");
        myCartItemList.get(index).setFoodPrice((price*tempQuantity)+"");
        adapterMyCartItemListRecy.notifyDataSetChanged();
    }

    @Override
    public void onDecreaseClicked(int index) {
        int tempQuantity= Integer.parseInt(myCartItemList.get(index).getFoodQuantity());
        int price=Integer.parseInt(myCartItemList.get(index).getFoodPrice());
        price=price/tempQuantity;
        
        if(tempQuantity<=1){
            myCartItemList.get(index).setFoodQuantity(1+"");
            adapterMyCartItemListRecy.notifyDataSetChanged();
        }else{

            myCartItemList.get(index).setFoodQuantity((--tempQuantity)+"");
            myCartItemList.get(index).setFoodPrice((price*tempQuantity)+"");
            adapterMyCartItemListRecy.notifyDataSetChanged();
        }
    }


    private void init() {
        myCartRecyclerView=findViewById(R.id.amc_myCart_recyclerView);
        btnCheckOut=findViewById(R.id.amc_btnConstrain);
        myCartItemViewModel = new ViewModelProvider(this).get(ViewModelMyCartItem.class);
        myCartItemList = new ArrayList<>();


        /*myCartItemViewModel.insertNewMyCartItem(new ModelMyCartItem(
                "Bogurar Doi",
                "200 Tk",
                "3",
                "1"
        ));
        myCartItemViewModel.insertNewMyCartItem(new ModelMyCartItem(
                "Khirsha",
                "330 Tk",
                "1",
                "2"
        ));
        myCartItemViewModel.insertNewMyCartItem(new ModelMyCartItem(
                "malai kari",
                "200 Tk",
                "2",
                "3"
        ));
        myCartItemViewModel.insertNewMyCartItem(new ModelMyCartItem(
                "Bogurar Doi",
                "200 Tk",
                "3",
                "4"
        ));*/

        toolbar=findViewById(R.id.amc_cart_main_toolbar);
        setSupportActionBar(toolbar);
    }
}