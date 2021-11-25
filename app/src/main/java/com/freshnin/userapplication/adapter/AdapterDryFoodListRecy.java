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

public class AdapterDryFoodListRecy extends RecyclerView.Adapter<AdapterDryFoodListRecy.ViewHolderAdapterDryFoodRecy> {


    List<ModelFoodItem> foodItemList;
    Context context;

    public AdapterDryFoodListRecy(List<ModelFoodItem> foodItemList, Context context) {
        this.foodItemList = foodItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterDryFoodRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_home_page_food_cardview,parent,false);
        ViewHolderAdapterDryFoodRecy viewHolderAdapterDryFoodRecy=new ViewHolderAdapterDryFoodRecy(view);
        return viewHolderAdapterDryFoodRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterDryFoodRecy holder, int position) {
        holder.ivDryFood.setImageResource(foodItemList.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public class ViewHolderAdapterDryFoodRecy extends RecyclerView.ViewHolder{
        ImageView ivDryFood;

        public ViewHolderAdapterDryFoodRecy(@NonNull View itemView) {
            super(itemView);
            ivDryFood=itemView.findViewById(R.id.ah_normal_item_image);
        }
    }
}
