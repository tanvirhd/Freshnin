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

public class AdapterCanFoodListRecy extends RecyclerView.Adapter<AdapterCanFoodListRecy.ViewHolderAdapterCanFoodListRecy> {

    List<ModelFoodItem> canFoodList;
    Context context;

    public AdapterCanFoodListRecy(List<ModelFoodItem> canFoodList, Context context) {
        this.canFoodList = canFoodList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterCanFoodListRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_home_page_food_cardview,parent,false);
        ViewHolderAdapterCanFoodListRecy viewHolderAdapterCanFoodListRecy=new ViewHolderAdapterCanFoodListRecy(view);
        return viewHolderAdapterCanFoodListRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterCanFoodListRecy holder, int position) {
        holder.ivCanFood.setImageResource(canFoodList.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {
        return canFoodList.size();
    }

    public class ViewHolderAdapterCanFoodListRecy extends RecyclerView.ViewHolder{
        ImageView ivCanFood;
        public ViewHolderAdapterCanFoodListRecy(@NonNull View itemView) {
            super(itemView);
            ivCanFood=itemView.findViewById(R.id.ah_normal_item_image);
        }
    }
}
