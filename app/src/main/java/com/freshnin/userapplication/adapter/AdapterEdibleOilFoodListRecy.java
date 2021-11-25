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

public class AdapterEdibleOilFoodListRecy extends RecyclerView.Adapter<AdapterEdibleOilFoodListRecy.ViewHolderAdapterEdibleOilFoodListRecy>{

    List<ModelFoodItem> edibleFoodItemList;
    Context context;

    public AdapterEdibleOilFoodListRecy(List<ModelFoodItem> edibleFoodItemList, Context context) {
        this.edibleFoodItemList = edibleFoodItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterEdibleOilFoodListRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_home_page_food_cardview,parent,false);
        ViewHolderAdapterEdibleOilFoodListRecy viewHolderAdapterEdibleOilFoodListRecy=new ViewHolderAdapterEdibleOilFoodListRecy(view);
        return viewHolderAdapterEdibleOilFoodListRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterEdibleOilFoodListRecy holder, int position) {
        holder.ivEdibleOil.setImageResource(edibleFoodItemList.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {
        return edibleFoodItemList.size();
    }

    public class ViewHolderAdapterEdibleOilFoodListRecy extends RecyclerView.ViewHolder{

        ImageView ivEdibleOil;

        public ViewHolderAdapterEdibleOilFoodListRecy(@NonNull View itemView) {
            super(itemView);
            ivEdibleOil=itemView.findViewById(R.id.ah_normal_item_image);
        }
    }
}
