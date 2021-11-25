package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelFoodItem;

import java.util.List;

public class AdapterHoneyAndGheeListRecy extends RecyclerView.Adapter<AdapterHoneyAndGheeListRecy.ViewHolderAdapterHoneyAndGheeListRecy>{

    List<ModelFoodItem> honeyAndGheeItemList;
    Context context;

    public AdapterHoneyAndGheeListRecy(List<ModelFoodItem> honeyAndGheeItemList, Context context) {
        this.honeyAndGheeItemList = honeyAndGheeItemList;
        this.context = context;
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
        holder.ivHoneyAndGhee.setImageResource(honeyAndGheeItemList.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {
        return honeyAndGheeItemList.size();
    }

    public class ViewHolderAdapterHoneyAndGheeListRecy extends RecyclerView.ViewHolder{
        ImageView ivHoneyAndGhee;
        public ViewHolderAdapterHoneyAndGheeListRecy(@NonNull View itemView) {
            super(itemView);
            ivHoneyAndGhee=itemView.findViewById(R.id.ah_normal_item_image);
        }
    }
}
