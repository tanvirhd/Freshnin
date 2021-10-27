package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.callbacks.AdapterOnGoingOrdersRecycCallBacks;
import com.freshnin.userapplication.model.ModelOrder;

import java.util.List;

public class AdapterOnGoingOrdersRecy extends RecyclerView.Adapter<AdapterOnGoingOrdersRecy.ViewHolderAdapterOnGoingOrdersRecy>{

    List<ModelOrder> onGoingOrderList;
    List<ModelOrder> onGoingOrderProductList;
    Context context;
    AdapterOnGoingOrdersRecycCallBacks adapterOnGoingOrdersRecycCallBacks;

    public AdapterOnGoingOrdersRecy(List<ModelOrder> onGoingOrderList, List<ModelOrder> onGoingOrderProductList, Context context, AdapterOnGoingOrdersRecycCallBacks adapterOnGoingOrdersRecycCallBacks) {
        this.onGoingOrderList = onGoingOrderList;
        this.onGoingOrderProductList = onGoingOrderProductList;
        this.context = context;
        this.adapterOnGoingOrdersRecycCallBacks = adapterOnGoingOrdersRecycCallBacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterOnGoingOrdersRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_on_going_order_cardview,parent,false);
        ViewHolderAdapterOnGoingOrdersRecy viewHolderAdapterOnGoingOrdersRecy=new ViewHolderAdapterOnGoingOrdersRecy(view);

        return viewHolderAdapterOnGoingOrdersRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterOnGoingOrdersRecy holder, int position) {
        holder.tvOnGoingOrderId.setText(onGoingOrderList.get(position).getOrderId());

        AdapterOngoingOrderProductListRecy adapterOngoingOrderProductListRecy = new AdapterOngoingOrderProductListRecy(onGoingOrderProductList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        holder.nestedRecyOnGoingOrderProductList.setLayoutManager(linearLayoutManager);
        holder.nestedRecyOnGoingOrderProductList.setAdapter(adapterOngoingOrderProductListRecy);

        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterOnGoingOrdersRecycCallBacks.onDetailsClicked(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return onGoingOrderList.size();
    }

    public class ViewHolderAdapterOnGoingOrdersRecy extends RecyclerView.ViewHolder{
        TextView tvOnGoingOrderId;
        RecyclerView nestedRecyOnGoingOrderProductList;
        TextView btnDetails;

        public ViewHolderAdapterOnGoingOrdersRecy(@NonNull View itemView) {
            super(itemView);
            tvOnGoingOrderId=itemView.findViewById(R.id.aogo_tvPreOrderId);
            nestedRecyOnGoingOrderProductList=itemView.findViewById(R.id.aogo_recyclerView_productList);
            btnDetails=itemView.findViewById(R.id.aogo_btnPreorderDetailsView);
        }
    }
}
