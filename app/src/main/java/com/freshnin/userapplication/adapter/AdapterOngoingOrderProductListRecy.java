package com.freshnin.userapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelOrder;
import com.freshnin.userapplication.model.ModelRegularItem;

import java.util.List;

public class AdapterOngoingOrderProductListRecy extends RecyclerView.Adapter<AdapterOngoingOrderProductListRecy.ViewHolderAdapterOngoingOrderProductListRecy> {

    List<ModelRegularItem> onGoingOrderProductList;

    public AdapterOngoingOrderProductListRecy(List<ModelRegularItem> onGoingOrderProductList) {
        this.onGoingOrderProductList = onGoingOrderProductList;
    }

    @NonNull
    @Override
    public ViewHolderAdapterOngoingOrderProductListRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_on_going_order_product_list_cardview,parent,false);
        ViewHolderAdapterOngoingOrderProductListRecy viewHolderAdapterOngoingOrderProductListRecy=new ViewHolderAdapterOngoingOrderProductListRecy(view);

        return viewHolderAdapterOngoingOrderProductListRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterOngoingOrderProductListRecy holder, int position) {
        //holder.tvProductName.setText(onGoingOrderProductList.get(position).getOrderedFoodName());
       // holder.tvQuantityOfProduct.setText(onGoingOrderProductList.get(position).getOrderedFoodQuantity());

        holder.tvProductName.setText(onGoingOrderProductList.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return onGoingOrderProductList.size();
    }

    public class ViewHolderAdapterOngoingOrderProductListRecy extends RecyclerView.ViewHolder{

        TextView tvProductName, tvQuantityOfProduct;

        public ViewHolderAdapterOngoingOrderProductListRecy(@NonNull View itemView) {
            super(itemView);
            tvProductName=itemView.findViewById(R.id.aogo_tvProductName);
            tvQuantityOfProduct=itemView.findViewById(R.id.aogo_tvProductQuantity);
        }
    }
}
