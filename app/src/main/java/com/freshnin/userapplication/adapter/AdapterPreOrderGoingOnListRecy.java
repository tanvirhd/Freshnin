package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPreOrderGoingOnListRecy extends RecyclerView.Adapter<AdapterPreOrderGoingOnListRecy.ViewHolderAdapterPreOrderGoingOnRecy>{

    List<ModelPreOrderItem> preOrderFoodList;
    Context context;

    public AdapterPreOrderGoingOnListRecy(List<ModelPreOrderItem> preOrderFoodList, Context context) {
        this.preOrderFoodList = preOrderFoodList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterPreOrderGoingOnRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.layout_home_page_ongoing_order_cardview,parent,false);
        ViewHolderAdapterPreOrderGoingOnRecy viewHolderAdapterPreOrderGoingOnRecy=new ViewHolderAdapterPreOrderGoingOnRecy(view);

        return viewHolderAdapterPreOrderGoingOnRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterPreOrderGoingOnRecy holder, int position) {
       // holder.ivPreOrderFoodImage.setImageResource(preOrderFoodList.get(position).getPreOrderFoodImage());
        Picasso.with(context)
                .load(preOrderFoodList.get(position).getProductPicUrl())
                .into(holder.ivPreOrderFoodImage);
    }

    @Override
    public int getItemCount() {
        return preOrderFoodList.size();
    }

    public class ViewHolderAdapterPreOrderGoingOnRecy extends RecyclerView.ViewHolder{
        ImageView ivPreOrderFoodImage;

        public ViewHolderAdapterPreOrderGoingOnRecy(@NonNull View itemView) {
            super(itemView);
            ivPreOrderFoodImage=itemView.findViewById(R.id.ah_preOrder_item_image);
        }
    }
}
