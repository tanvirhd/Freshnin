package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.callbacks.AdapterMyCartItemListRecyCallBacks;
import com.freshnin.userapplication.model.ModelMyCartItem;

import java.util.List;

public class AdapterMyCartItemListRecy extends RecyclerView.Adapter<AdapterMyCartItemListRecy.ViewHolderAdapterMyCartItemListRecy> {

    List<ModelMyCartItem> myCartItemList;
    Context context;
    AdapterMyCartItemListRecyCallBacks adapterMyCartItemListRecyCallBacks;

    public AdapterMyCartItemListRecy(List<ModelMyCartItem> myCartItemList, Context context, AdapterMyCartItemListRecyCallBacks adapterMyCartItemListRecyCallBacks) {
        this.myCartItemList = myCartItemList;
        this.context = context;
        this.adapterMyCartItemListRecyCallBacks = adapterMyCartItemListRecyCallBacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterMyCartItemListRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_mycart_item_cardview,parent,false);
        ViewHolderAdapterMyCartItemListRecy viewHolderAdapterMyCartItemListRecy=new ViewHolderAdapterMyCartItemListRecy(view);

        return viewHolderAdapterMyCartItemListRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterMyCartItemListRecy holder, int position) {

        ModelMyCartItem myCartItem= myCartItemList.get(position);
        int index=position;

        holder.tvCartPorductName.setText(myCartItemList.get(position).getFoodName());
        holder.tvCartProductPrice.setText(myCartItemList.get(position).getFoodPrice());
        holder.tvCartProductQuantity.setText(myCartItemList.get(position).getFoodQuantity());

        holder.btnRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterMyCartItemListRecyCallBacks.onDeleteClicked(myCartItem,index);
            }
        });

        holder.btnIncreaseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterMyCartItemListRecyCallBacks.onIncreaseClicked(index);
            }
        });

        holder.btnDecreaseItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterMyCartItemListRecyCallBacks.onDecreaseClicked(index);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myCartItemList.size();
    }

    public class ViewHolderAdapterMyCartItemListRecy extends RecyclerView.ViewHolder{

        TextView tvCartPorductName,tvCartProductPrice,tvCartProductQuantity;
        ImageView btnRemoveItem,btnIncreaseItem,btnDecreaseItem;

        public ViewHolderAdapterMyCartItemListRecy(@NonNull View itemView) {
            super(itemView);
            tvCartPorductName=itemView.findViewById(R.id.amc_tv_cart_food_name);
            tvCartProductPrice=itemView.findViewById(R.id.amc_tv_cart_food_pice);
            tvCartProductQuantity=itemView.findViewById(R.id.amc_tv_cart_food_quantity);

            btnRemoveItem=itemView.findViewById(R.id.amc_btn_cart_cancle_item);
            btnIncreaseItem=itemView.findViewById(R.id.amc_btn_cart_quantity_increment);
            btnDecreaseItem=itemView.findViewById(R.id.amc_btn_cart_quantity_decrement);
        }
    }
}
