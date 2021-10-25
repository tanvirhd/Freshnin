package com.freshnin.userapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelOrder;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterOldOrderHistoryProductListRecy extends RecyclerView.Adapter<AdapterOldOrderHistoryProductListRecy.ViewHolderAdapterOldOrderHistoryProductListRecy>{

    List<ModelOrder> oldOrderProductList;

    public AdapterOldOrderHistoryProductListRecy(List<ModelOrder> oldOrderProductList) {
        this.oldOrderProductList = oldOrderProductList;
    }

    @NonNull
    @Override
    public ViewHolderAdapterOldOrderHistoryProductListRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_old_order_history_productlist_cardview,parent,false);
        ViewHolderAdapterOldOrderHistoryProductListRecy viewHolderAdapterOldOrderHistoryProductListRecy=new ViewHolderAdapterOldOrderHistoryProductListRecy(view);

        return viewHolderAdapterOldOrderHistoryProductListRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterOldOrderHistoryProductListRecy holder, int position) {
        holder.tvProductName.setText(oldOrderProductList.get(position).getOrderedFoodName());
        holder.tvQuantityOfOrderedProduct.setText(oldOrderProductList.get(position).getOrderedFoodQuantity());
    }

    @Override
    public int getItemCount() {
        return oldOrderProductList.size();
    }

    public class ViewHolderAdapterOldOrderHistoryProductListRecy extends RecyclerView.ViewHolder{

        TextView tvProductName, tvQuantityOfOrderedProduct;

        public ViewHolderAdapterOldOrderHistoryProductListRecy(@NonNull View itemView) {
            super(itemView);
            tvProductName=itemView.findViewById(R.id.aooh_tvProductName);
            tvQuantityOfOrderedProduct=itemView.findViewById(R.id.aooh_tvProductQuantity);
        }
    }
}
