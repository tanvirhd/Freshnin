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

    List<ModelMyCartItem> mycartItemList;
    Context context;
    AdapterMyCartItemListRecyCallBacks adapterMyCartItemListRecyCallBacks;

    public AdapterMyCartItemListRecy(List<ModelMyCartItem> mycartItemList, Context context, AdapterMyCartItemListRecyCallBacks adapterMyCartItemListRecyCallBacks) {
        this.mycartItemList = mycartItemList;
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

        ModelMyCartItem myCartItem=mycartItemList.get(position);
        int index=position;

        holder.tvCartPorductName.setText(mycartItemList.get(position).getProductName());
        holder.tvCartProductPrice.setText(mycartItemList.get(position).getProductPrice());
        holder.tvCartProductQuantity.setText(mycartItemList.get(position).getProductQuantity());

        holder.btnRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterMyCartItemListRecyCallBacks.onDeleteClicked(myCartItem,index);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mycartItemList.size();
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
//            btnIncreaseItem=itemView.findViewById(R.id.btn_cart_quantity_increment);
//            btnDecreaseItem=itemView.findViewById(R.id.btn_cart_quantity_decrement);
        }
    }
}
