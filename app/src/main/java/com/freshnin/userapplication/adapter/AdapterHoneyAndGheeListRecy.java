package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.callbacks.AdapterHoneyAndGheeListRecyCallBacks;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterHoneyAndGheeListRecy extends RecyclerView.Adapter<AdapterHoneyAndGheeListRecy.ViewHolderAdapterHoneyAndGheeListRecy>{

    List<ModelRegularItem> honeyAndGheeItemList;
    Context context;
    AdapterHoneyAndGheeListRecyCallBacks adapterHoneyAndGheeListRecyCallBacks;

    public AdapterHoneyAndGheeListRecy(List<ModelRegularItem> honeyAndGheeItemList, Context context, AdapterHoneyAndGheeListRecyCallBacks adapterHoneyAndGheeListRecyCallBacks) {
        this.honeyAndGheeItemList = honeyAndGheeItemList;
        this.context = context;
        this.adapterHoneyAndGheeListRecyCallBacks = adapterHoneyAndGheeListRecyCallBacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterHoneyAndGheeListRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout_home_page_food_cardview,parent,false);
        ViewHolderAdapterHoneyAndGheeListRecy viewHolderAdapterHoneyAndGheeListRecy=new ViewHolderAdapterHoneyAndGheeListRecy(view);
        return viewHolderAdapterHoneyAndGheeListRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterHoneyAndGheeListRecy holder, int position) {
        //holder.ivHoneyAndGhee.setImageResource(honeyAndGheeItemList.get(position).getFoodImage());

        Picasso.with(context).load(honeyAndGheeItemList.get(position).getProductPicUrl()).into(holder.ivHoneyAndGhee);
        holder.cdHoneyAndGhee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterHoneyAndGheeListRecyCallBacks.onHoneyAndGheeItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return honeyAndGheeItemList.size();
    }

    public class ViewHolderAdapterHoneyAndGheeListRecy extends RecyclerView.ViewHolder{
        ImageView ivHoneyAndGhee;
        CardView cdHoneyAndGhee;

        public ViewHolderAdapterHoneyAndGheeListRecy(@NonNull View itemView) {
            super(itemView);
            ivHoneyAndGhee=itemView.findViewById(R.id.ah_normal_item_image);
            cdHoneyAndGhee=itemView.findViewById(R.id.ah_regularFood_onClick);
        }
    }
}
