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
import com.freshnin.userapplication.model.ModelFoodItem;

import java.util.List;

public class AdapterFoodItemListRecy extends RecyclerView.Adapter<AdapterFoodItemListRecy.ViewHolderAdapterFoodItemListRecy> {

    List<ModelFoodItem> foodItemList;
    Context context;

    public AdapterFoodItemListRecy(List<ModelFoodItem> foodItemList, Context context) {
        this.foodItemList = foodItemList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolderAdapterFoodItemListRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context). inflate(R.layout.layout_food_item_cardview,parent,false);
        ViewHolderAdapterFoodItemListRecy viewHolderAdapterFoodItemListRecy=new ViewHolderAdapterFoodItemListRecy(view);

        return viewHolderAdapterFoodItemListRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterFoodItemListRecy holder, int position) {
        holder.ivFoodImage.setImageResource(foodItemList.get(position).getFoodImage());

        holder.tvFoodName.setText(foodItemList.get(position).getFoodName());
        holder.tvFoodPrice.setText(foodItemList.get(position).getFoodPrice());

        if(foodItemList.get(position).isFavourite()){
            holder.favouriteIcon.setVisibility(View.VISIBLE);
            holder.notFavouriteIcon.setVisibility(View.GONE);
        }else{
            holder.favouriteIcon.setVisibility(View.GONE);
            holder.notFavouriteIcon.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public class ViewHolderAdapterFoodItemListRecy extends RecyclerView.ViewHolder{
        ImageView ivFoodImage, notFavouriteIcon, favouriteIcon;
        TextView tvFoodName, tvFoodPrice,btnAddtoCart,priceWord;

        public ViewHolderAdapterFoodItemListRecy(@NonNull View itemView) {
            super(itemView);
            ivFoodImage=itemView.findViewById(R.id.afil_iv_food_picture);
            tvFoodName=itemView.findViewById(R.id.afil_tvFoodName);
            tvFoodPrice=itemView.findViewById(R.id.afil_tvFoodPrice);

            notFavouriteIcon=itemView.findViewById(R.id.afil_ivNotFavouriteFood);
            favouriteIcon =itemView.findViewById(R.id.afil_ivFavouriteFood);

            btnAddtoCart=itemView.findViewById(R.id.afil_btn_add_to_cart);
            priceWord=itemView.findViewById(R.id.afil_priceWord);


        }
    }
}