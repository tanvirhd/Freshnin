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
import com.freshnin.userapplication.model.ModelPreOrderFood;

import java.util.List;

public class AdapterPreOrderFoodRecy extends RecyclerView.Adapter<AdapterPreOrderFoodRecy.ViewHolderAdapterPreOrderFoodRecy>{

    List<ModelPreOrderFood> preOrderFoodList;
    Context context;

    public AdapterPreOrderFoodRecy(List<ModelPreOrderFood> preOrderFoodList, Context context) {
        this.preOrderFoodList = preOrderFoodList;
        this.context = context;
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
        holder.ivPreOrderFoodImage.setImageResource(preOrderFoodList.get(position).getPreOrderFoodImage());

        holder.tvPreOrderFoodTitle.setText(preOrderFoodList.get(position).getPreOrderFoodName());
        holder.tvOrderGoingOnTillDay.setText(preOrderFoodList.get(position).getOrderGoingTillDay());
    }

    @Override
    public int getItemCount() {
        return preOrderFoodList.size();
    }

    public class ViewHolderAdapterPreOrderFoodRecy extends RecyclerView.ViewHolder{
        TextView tvPreOrderFoodTitle, tvOrderGoingOnTillDay;
        ImageView ivPreOrderFoodImage;

        public ViewHolderAdapterPreOrderFoodRecy(@NonNull View itemView) {
            super(itemView);

            tvPreOrderFoodTitle =itemView.findViewById(R.id.apofl_tvFoodTitle);
            tvOrderGoingOnTillDay =itemView.findViewById(R.id.apofl_tvOrderRemainday);

            ivPreOrderFoodImage=itemView.findViewById(R.id.apofl_ivFoodImage);
        }
    }

}
