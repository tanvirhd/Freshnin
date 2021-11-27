package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.callbacks.AdapterPreOrderFoodRecycCallBacks;
import com.freshnin.userapplication.model.ModelPreOrderFood;
import com.freshnin.userapplication.model.ModelPreOrderItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPreOrderFoodRecy extends RecyclerView.Adapter<AdapterPreOrderFoodRecy.ViewHolderAdapterPreOrderFoodRecy>{

    List<ModelPreOrderItem> preOrderFoodList;
    Context context;
    AdapterPreOrderFoodRecycCallBacks adapterPreOrderFoodRecycCallBacks;

    public AdapterPreOrderFoodRecy(List<ModelPreOrderItem> preOrderFoodList, Context context, AdapterPreOrderFoodRecycCallBacks adapterPreOrderFoodRecycCallBacks) {
        this.preOrderFoodList = preOrderFoodList;
        this.context = context;
        this.adapterPreOrderFoodRecycCallBacks = adapterPreOrderFoodRecycCallBacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterPreOrderFoodRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_preorder_item, parent, false);
        ViewHolderAdapterPreOrderFoodRecy viewHolderAdapterPreOrderFoodRecy=new ViewHolderAdapterPreOrderFoodRecy(view);

        return viewHolderAdapterPreOrderFoodRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterPreOrderFoodRecy holder, int position) {

        Picasso.with(context)
                .load(preOrderFoodList.get(position).getProductPicUrl())
                .into( holder.ivPreOrderFoodImage );

        holder.tvPreOrderFoodTitle.setText(preOrderFoodList.get(position).getPreOrderProductName());
        holder.tvOrderGoingOnTillDay.setText(preOrderFoodList.get(position).getProductShortDes());

        holder.itemDetailsOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterPreOrderFoodRecycCallBacks.onItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return preOrderFoodList.size();
    }

    public class ViewHolderAdapterPreOrderFoodRecy extends RecyclerView.ViewHolder{
        TextView tvPreOrderFoodTitle, tvOrderGoingOnTillDay;
        ImageView ivPreOrderFoodImage;
        CardView itemDetailsOnClick;

        public ViewHolderAdapterPreOrderFoodRecy(@NonNull View itemView) {
            super(itemView);

            tvPreOrderFoodTitle =itemView.findViewById(R.id.apofl_tvFoodTitle);
            tvOrderGoingOnTillDay =itemView.findViewById(R.id.apofl_tvOrderRemainday);
            ivPreOrderFoodImage=itemView.findViewById(R.id.apofl_ivFoodImage);

            itemDetailsOnClick=itemView.findViewById(R.id.apofl_item);

        }
    }

}
