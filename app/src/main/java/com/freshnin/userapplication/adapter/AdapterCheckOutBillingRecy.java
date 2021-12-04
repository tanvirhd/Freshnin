package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelMyCartItem;

import java.util.List;

public class AdapterCheckOutBillingRecy extends RecyclerView.Adapter<AdapterCheckOutBillingRecy.ViewHolderAdapterCheckOutBillingRecy>{

    List<ModelMyCartItem> checkOutBillingFoodItemList;
    Context context;

    public AdapterCheckOutBillingRecy(List<ModelMyCartItem> checkOutBillingFoodItemList, Context context) {
        this.checkOutBillingFoodItemList = checkOutBillingFoodItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterCheckOutBillingRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_check_out_billing_cardview,parent,false);
        ViewHolderAdapterCheckOutBillingRecy viewHolderAdapterCheckOutBillingRecy=new ViewHolderAdapterCheckOutBillingRecy(view);

        return viewHolderAdapterCheckOutBillingRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterCheckOutBillingRecy holder, int position) {
        holder.tvProductName.setText(checkOutBillingFoodItemList.get(position).getFoodName());
        //int temp=(Integer.parseInt(checkOutBillingFoodItemList.get(position).getFoodPrice()))*(Integer.parseInt(checkOutBillingFoodItemList.get(position).getFoodQuantity()));
        holder.tvProductPrice.setText(checkOutBillingFoodItemList.get(position).getFoodPrice());
    }

    @Override
    public int getItemCount() {
        return checkOutBillingFoodItemList.size();
    }

    public class ViewHolderAdapterCheckOutBillingRecy extends RecyclerView.ViewHolder {
        TextView tvProductName, tvProductPrice;

        public ViewHolderAdapterCheckOutBillingRecy(@NonNull View itemView) {
            super(itemView);

            tvProductName=itemView.findViewById(R.id.aco_billingList_tvProductName);
            tvProductPrice=itemView.findViewById(R.id.aco_billingList_tvProductPrice);
        }
    }
}
