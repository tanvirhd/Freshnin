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

public class AdapterHerbalItemRecy extends RecyclerView.Adapter<AdapterHerbalItemRecy.ViewHolderAdapterHerbalItemRecy> {

    List<ModelFoodItem> herbalItemList;
    Context context;

    public AdapterHerbalItemRecy(List<ModelFoodItem> herbalItemList, Context context) {
        this.herbalItemList = herbalItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterHerbalItemRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_home_page_food_cardview,parent,false);
        ViewHolderAdapterHerbalItemRecy viewHolderAdapterHerbalItemRecy=new ViewHolderAdapterHerbalItemRecy(view);

        return viewHolderAdapterHerbalItemRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterHerbalItemRecy holder, int position) {
        holder.ivHerbalOil.setImageResource(herbalItemList.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {
        return herbalItemList.size();
    }

    public class ViewHolderAdapterHerbalItemRecy extends RecyclerView.ViewHolder{
        ImageView ivHerbalOil;
        public ViewHolderAdapterHerbalItemRecy(@NonNull View itemView) {
            super(itemView);
            ivHerbalOil=itemView.findViewById(R.id.ah_normal_item_image);
        }
    }

}
