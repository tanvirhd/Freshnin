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

import java.util.List;

public class AdapterCheckOutFoodItemRecy extends RecyclerView.Adapter<AdapterCheckOutFoodItemRecy.ViewHolderAdapterCheckOutFoodInCart> {

    List<ModelFoodItem> checkOutFoodItemList;
    Context context;

    public AdapterCheckOutFoodItemRecy(List<ModelFoodItem> checkOutFoodItemList, Context context) {
        this.checkOutFoodItemList = checkOutFoodItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterCheckOutFoodInCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_chechk_out_porduct_cardview,parent,false);
        ViewHolderAdapterCheckOutFoodInCart viewHolderAdapterCheckOutFoodInCart= new ViewHolderAdapterCheckOutFoodInCart(view);

        return viewHolderAdapterCheckOutFoodInCart;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterCheckOutFoodInCart holder, int position) {
        holder.tvProdectName.setText(checkOutFoodItemList.get(position).getFoodName());
        holder.tvProductPrice.setText(checkOutFoodItemList.get(position).getFoodPrice());
        holder.tvProductQuantity.setText(checkOutFoodItemList.get(position).getQuantityOfFood());
    }

    @Override
    public int getItemCount() {
        return checkOutFoodItemList.size();
    }

    public class ViewHolderAdapterCheckOutFoodInCart extends RecyclerView.ViewHolder{

        TextView tvProdectName, tvProductPrice, tvProductQuantity;

        public ViewHolderAdapterCheckOutFoodInCart(@NonNull View itemView) {
            super(itemView);

            tvProdectName=itemView.findViewById(R.id.aco_plist_tvPorductName);
            tvProductPrice=itemView.findViewById(R.id.aco_plist_tvProductPrice);
            tvProductQuantity=itemView.findViewById(R.id.aco_plist_tvProducQuantity);
        }
    }
}
