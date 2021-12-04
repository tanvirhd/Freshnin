package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.callbacks.AdapterFoodItemListRecycCallBacks;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.freshnin.userapplication.viewmodel.ViewModelMyCartItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFoodItemListRecy extends RecyclerView.Adapter<AdapterFoodItemListRecy.ViewHolderAdapterFoodItemListRecy> {

    List<ModelRegularItem> foodItemList;
    Context context;
    AdapterFoodItemListRecycCallBacks adapterFoodItemListRecycCallBacks;


    public AdapterFoodItemListRecy(List<ModelRegularItem> foodItemList, Context context, AdapterFoodItemListRecycCallBacks adapterFoodItemListRecycCallBacks) {
        this.foodItemList = foodItemList;
        this.context = context;
        this.adapterFoodItemListRecycCallBacks = adapterFoodItemListRecycCallBacks;
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

        Picasso.with(context).load(foodItemList.get(position).getProductPicUrl()).into(holder.ivFoodImage);
        holder.tvFoodName.setText(foodItemList.get(position).getProductName());
        holder.tvFoodPrice.setText(foodItemList.get(position).getProductUnitPrice());

        /*if(foodItemList.get(position).isFavourite()){
            holder.favouriteIcon.setVisibility(View.VISIBLE);
            holder.notFavouriteIcon.setVisibility(View.GONE);
        }else{
            holder.favouriteIcon.setVisibility(View.GONE);
            holder.notFavouriteIcon.setVisibility(View.VISIBLE);
        }*/


        holder.onClickDetailsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterFoodItemListRecycCallBacks.onItemClick(holder.getAdapterPosition());
            }
        });

        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterFoodItemListRecycCallBacks.onAddToCartClicked(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public class ViewHolderAdapterFoodItemListRecy extends RecyclerView.ViewHolder{
        ImageView ivFoodImage, notFavouriteIcon, favouriteIcon;
        TextView tvFoodName, tvFoodPrice, btnAddToCart,priceWord;
        ConstraintLayout onClickDetailsView;

        public ViewHolderAdapterFoodItemListRecy(@NonNull View itemView) {
            super(itemView);
            ivFoodImage=itemView.findViewById(R.id.afil_iv_food_picture);
            tvFoodName=itemView.findViewById(R.id.afil_tvFoodName);
            tvFoodPrice=itemView.findViewById(R.id.afil_tvFoodPrice);

            notFavouriteIcon=itemView.findViewById(R.id.afil_ivNotFavouriteFood);
            favouriteIcon =itemView.findViewById(R.id.afil_ivFavouriteFood);

            btnAddToCart =itemView.findViewById(R.id.afil_btn_add_to_cart);
            priceWord=itemView.findViewById(R.id.afil_priceWord);


            onClickDetailsView =itemView.findViewById(R.id.afil_on_detailsView);

        }
    }
}