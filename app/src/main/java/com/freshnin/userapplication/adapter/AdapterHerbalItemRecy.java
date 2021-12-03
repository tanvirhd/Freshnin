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
import com.freshnin.userapplication.callbacks.AdapterHerbalItemRecyCallBacks;
import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelRegularItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterHerbalItemRecy extends RecyclerView.Adapter<AdapterHerbalItemRecy.ViewHolderAdapterHerbalItemRecy> {

    List<ModelRegularItem> herbalItemList;
    Context context;
    AdapterHerbalItemRecyCallBacks adapterHerbalItemRecyCallBacks;

    public AdapterHerbalItemRecy(List<ModelRegularItem> herbalItemList, Context context, AdapterHerbalItemRecyCallBacks adapterHerbalItemRecyCallBacks) {
        this.herbalItemList = herbalItemList;
        this.context = context;
        this.adapterHerbalItemRecyCallBacks = adapterHerbalItemRecyCallBacks;
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
        //holder.ivHerbalOil.setImageResource(herbalItemList.get(position).getFoodImage());

        Picasso.with(context).load(herbalItemList.get(position).getProductPicUrl()).into(holder.ivHerbalOil);
        holder.cdHerbalItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterHerbalItemRecyCallBacks.onHerbalItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return herbalItemList.size();
    }

    public class ViewHolderAdapterHerbalItemRecy extends RecyclerView.ViewHolder{
        ImageView ivHerbalOil;
        CardView cdHerbalItem;

        public ViewHolderAdapterHerbalItemRecy(@NonNull View itemView) {
            super(itemView);
            ivHerbalOil=itemView.findViewById(R.id.ah_normal_item_image);
            cdHerbalItem=itemView.findViewById(R.id.ah_regularFood_onClick);
        }
    }

}
