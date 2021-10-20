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

public class AdapterFavouriteItemRecy extends RecyclerView.Adapter<AdapterFavouriteItemRecy.ViewHolderAdapterFavouriteItemRecy>{

    List<ModelFoodItem> favouriteFoodList;
    Context context;

    public AdapterFavouriteItemRecy(List<ModelFoodItem> favouriteFoodList, Context context) {
        this.favouriteFoodList = favouriteFoodList;
        this.context = context;
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

        holder.ivFavFoodImage.setImageResource(favouriteFoodList.get(position).getFoodImage());
        holder.tvFavFoobName.setText(favouriteFoodList.get(position).getFoodName());
        holder.tvFavFoodPrice.setText(favouriteFoodList.get(position).getFoodPrice());

    }

    @Override
    public int getItemCount() {
        return favouriteFoodList.size();
    }

    public class ViewHolderAdapterFavouriteItemRecy extends RecyclerView.ViewHolder{

        ImageView ivFavFoodImage;
        TextView tvFavFoobName, tvFavFoodPrice;

        public ViewHolderAdapterFavouriteItemRecy(@NonNull View itemView) {
            super(itemView);

            ivFavFoodImage=itemView.findViewById(R.id.afi_iv_food_picture);

            tvFavFoobName=itemView.findViewById(R.id.afi_tvFoodName);
            tvFavFoodPrice=itemView.findViewById(R.id.afi_tvFoodPrice);

        }
    }
}
