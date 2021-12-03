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
import com.freshnin.userapplication.callbacks.AdapterEdibleOilFoodListRecyCallBacks;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterEdibleOilFoodListRecy extends RecyclerView.Adapter<AdapterEdibleOilFoodListRecy.ViewHolderAdapterEdibleOilFoodListRecy>{

    List<ModelRegularItem> edibleFoodItemList;
    Context context;
    AdapterEdibleOilFoodListRecyCallBacks adapterEdibleOilFoodListRecyCallBacks;

    public AdapterEdibleOilFoodListRecy(List<ModelRegularItem> edibleFoodItemList, Context context, AdapterEdibleOilFoodListRecyCallBacks adapterEdibleOilFoodListRecyCallBacks) {
        this.edibleFoodItemList = edibleFoodItemList;
        this.context = context;
        this.adapterEdibleOilFoodListRecyCallBacks = adapterEdibleOilFoodListRecyCallBacks;
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
        //holder.ivEdibleOil.setImageResource(edibleFoodItemList.get(position).getFoodImage());
        Picasso.with(context).load(edibleFoodItemList.get(position).getProductPicUrl()).into(holder.ivEdibleOil);

        holder.cdEdibleOil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterEdibleOilFoodListRecyCallBacks.onEdibleItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return edibleFoodItemList.size();
    }

    public class ViewHolderAdapterEdibleOilFoodListRecy extends RecyclerView.ViewHolder{

        ImageView ivEdibleOil;
        CardView cdEdibleOil;

        public ViewHolderAdapterEdibleOilFoodListRecy(@NonNull View itemView) {
            super(itemView);
            ivEdibleOil=itemView.findViewById(R.id.ah_normal_item_image);
            cdEdibleOil=itemView.findViewById(R.id.ah_regularFood_onClick);
        }
    }
}
