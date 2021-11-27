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
import com.freshnin.userapplication.callbacks.AdapterFavouriteFoodRecyCallBacks;
import com.freshnin.userapplication.model.ModelFoodItem;

import java.util.List;

public class AdapterFavouriteFoodRecy extends RecyclerView.Adapter<AdapterFavouriteFoodRecy.ViewHolderAdapterFavouriteItemRecy>{

    List<ModelFoodItem> favouriteFoodList;
    Context context;
    AdapterFavouriteFoodRecyCallBacks favouriteFoodRecyCallBacks;

    public AdapterFavouriteFoodRecy(List<ModelFoodItem> favouriteFoodList, Context context, AdapterFavouriteFoodRecyCallBacks favouriteFoodRecyCallBacks) {
        this.favouriteFoodList = favouriteFoodList;
        this.context = context;
        this.favouriteFoodRecyCallBacks = favouriteFoodRecyCallBacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterFavouriteItemRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_favourite_item_cardview,parent,false);
        ViewHolderAdapterFavouriteItemRecy viewHolderAdapterFavouriteItemRecy=new ViewHolderAdapterFavouriteItemRecy(view);

        return viewHolderAdapterFavouriteItemRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterFavouriteItemRecy holder, int position) {
        ModelFoodItem favouriteFood=favouriteFoodList.get(position);
        int index=position;

        holder.ivFavFoodImage.setImageResource(favouriteFoodList.get(position).getFoodImage());
        holder.tvFavFoobName.setText(favouriteFoodList.get(position).getFoodName());
        holder.tvFavFoodPrice.setText(favouriteFoodList.get(position).getFoodPrice());

        holder.btnRemoveFromFavouriteFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favouriteFoodRecyCallBacks.onUnFavouriteClicked(favouriteFood,index);
            }
        });

    }

    @Override
    public int getItemCount() {
        return favouriteFoodList.size();
    }

    public class ViewHolderAdapterFavouriteItemRecy extends RecyclerView.ViewHolder{

        ImageView ivFavFoodImage, btnRemoveFromFavouriteFood;
        TextView tvFavFoobName, tvFavFoodPrice;

        public ViewHolderAdapterFavouriteItemRecy(@NonNull View itemView) {
            super(itemView);

            ivFavFoodImage=itemView.findViewById(R.id.aff_iv_food_picture);

            tvFavFoobName=itemView.findViewById(R.id.aff_tvFoodName);
            tvFavFoodPrice=itemView.findViewById(R.id.aff_tvFoodPrice);
            btnRemoveFromFavouriteFood =itemView.findViewById(R.id.aff_ivFavouriteFood);

        }
    }
}
