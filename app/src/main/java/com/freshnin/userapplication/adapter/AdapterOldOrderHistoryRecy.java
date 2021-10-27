package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.callbacks.AdapterOldOrderHistoryRecycCallBacks;
import com.freshnin.userapplication.model.ModelOrder;

import java.util.List;

public class AdapterOldOrderHistoryRecy extends RecyclerView.Adapter<AdapterOldOrderHistoryRecy.ViewHolderAdapterOldOrderHistoryRecy>{

    List<ModelOrder> oldOrderList;
    List<ModelOrder> oldOrderProductList;
    Context context;
    AdapterOldOrderHistoryRecycCallBacks adapterOldOrderHistoryRecycCallBacks;

    public AdapterOldOrderHistoryRecy(List<ModelOrder> oldOrderList, List<ModelOrder> oldOrderProductList, Context context, AdapterOldOrderHistoryRecycCallBacks adapterOldOrderHistoryRecycCallBacks) {
        this.oldOrderList = oldOrderList;
        this.oldOrderProductList = oldOrderProductList;
        this.context = context;
        this.adapterOldOrderHistoryRecycCallBacks = adapterOldOrderHistoryRecycCallBacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterOldOrderHistoryRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_old_order_history_cardview,parent,false);
        ViewHolderAdapterOldOrderHistoryRecy viewHolderAdapterOldOrderHistoryRecy=new ViewHolderAdapterOldOrderHistoryRecy(view);

        return viewHolderAdapterOldOrderHistoryRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterOldOrderHistoryRecy holder, int position) {
        holder.tvOrderId.setText(oldOrderList.get(position).getOrderId());

        AdapterOldOrderHistoryProductListRecy adapterOldOrderHistoryProductListRecy=new AdapterOldOrderHistoryProductListRecy(oldOrderProductList);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(context);
        holder.nestedRecyProductList.setLayoutManager(linearLayoutManager);
        holder.nestedRecyProductList.setAdapter(adapterOldOrderHistoryProductListRecy);

        holder.btnOrderAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterOldOrderHistoryRecycCallBacks.onOrderAgainClicked(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return oldOrderList.size();
    }

    public class ViewHolderAdapterOldOrderHistoryRecy extends RecyclerView.ViewHolder{

        TextView tvOrderId;
        RecyclerView nestedRecyProductList;
        TextView btnOrderAgain;

        public ViewHolderAdapterOldOrderHistoryRecy(@NonNull View itemView) {
            super(itemView);
            tvOrderId=itemView.findViewById(R.id.aooh_tvPreOrderId);
            nestedRecyProductList=itemView.findViewById(R.id.aooh_recyclerView_productList);
            btnOrderAgain=itemView.findViewById(R.id.aooh_btnPreorderDetailsView);
        }
    }
}
