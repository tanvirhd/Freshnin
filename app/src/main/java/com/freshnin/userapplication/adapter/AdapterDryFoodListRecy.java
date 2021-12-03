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
import com.freshnin.userapplication.callbacks.AdapterDryFoodListRecyCallBacks;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterDryFoodListRecy extends RecyclerView.Adapter<AdapterDryFoodListRecy.ViewHolderAdapterDryFoodRecy> {


    List<ModelRegularItem> foodItemList;
    Context context;
    AdapterDryFoodListRecyCallBacks adapterDryFoodListRecyCallBacks;

    public AdapterDryFoodListRecy(List<ModelRegularItem> foodItemList, Context context, AdapterDryFoodListRecyCallBacks adapterDryFoodListRecyCallBacks) {
        this.foodItemList = foodItemList;
        this.context = context;
        this.adapterDryFoodListRecyCallBacks = adapterDryFoodListRecyCallBacks;
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
        Picasso.with(context).load(foodItemList.get(position).getProductPicUrl()).into(holder.ivDryFood);

        holder.cdDryFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterDryFoodListRecyCallBacks.onDryFoodItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public class ViewHolderAdapterDryFoodRecy extends RecyclerView.ViewHolder{
        ImageView ivDryFood;
        CardView cdDryFood;

        public ViewHolderAdapterDryFoodRecy(@NonNull View itemView) {
            super(itemView);

            ivDryFood=itemView.findViewById(R.id.ah_normal_item_image);
            cdDryFood=itemView.findViewById(R.id.ah_regularFood_onClick);
        }
    }
}
