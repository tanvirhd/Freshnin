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

import org.w3c.dom.Text;

import java.util.List;

public class AdapterOnGoingOrderDetailsFoodListRecy extends RecyclerView.Adapter<AdapterOnGoingOrderDetailsFoodListRecy.ViewHolderAdapterOnGoingOrderDetailsFoodListRecy> {

    List<ModelFoodItem> foodItemList;
    Context context;

    public AdapterOnGoingOrderDetailsFoodListRecy(List<ModelFoodItem> foodItemList, Context context) {
        this.foodItemList = foodItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterOnGoingOrderDetailsFoodListRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_on_going_order_details_product_list_cardview,parent,false);
        ViewHolderAdapterOnGoingOrderDetailsFoodListRecy viewHolderAdapterOnGoingOrderDetailsFoodListRecy=new ViewHolderAdapterOnGoingOrderDetailsFoodListRecy(view);

        return viewHolderAdapterOnGoingOrderDetailsFoodListRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterOnGoingOrderDetailsFoodListRecy holder, int position) {
        holder.tvFoodName.setText(foodItemList.get(position).getFoodName());
        holder.tvQuantityOfFood.setText(foodItemList.get(position).getQuantityOfFood());

        holder.ivFoodImage.setImageResource(foodItemList.get(position).getFoodImage());
    }

    @Override
    public int getItemCount() {
        return foodItemList.size();
    }

    public class ViewHolderAdapterOnGoingOrderDetailsFoodListRecy extends RecyclerView.ViewHolder{
        ImageView ivFoodImage;
        TextView tvFoodName, tvQuantityOfFood;

        public ViewHolderAdapterOnGoingOrderDetailsFoodListRecy(@NonNull View itemView) {
            super(itemView);
            ivFoodImage=itemView.findViewById(R.id.aogod_ivItemImage);
            tvFoodName=itemView.findViewById(R.id.aogod_tvItemName);
            tvQuantityOfFood=itemView.findViewById(R.id.aogod_tvItemQuantity);
        }
    }
}
