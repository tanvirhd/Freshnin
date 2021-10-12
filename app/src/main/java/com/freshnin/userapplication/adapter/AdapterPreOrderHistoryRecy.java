package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelPreOrderHistory;

import java.util.List;

public class AdapterPreOrderHistoryRecy extends RecyclerView.Adapter<AdapterPreOrderHistoryRecy.ViewHolderAdapterPreOrderHistoryRecy> {

    List<ModelPreOrderHistory> preOrderHistoryList;
    Context context;

    public AdapterPreOrderHistoryRecy(List<ModelPreOrderHistory> preOrderHistoryList, Context context) {
        this.preOrderHistoryList = preOrderHistoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderAdapterPreOrderHistoryRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_proorder_history_cardview,parent,false);
        ViewHolderAdapterPreOrderHistoryRecy viewHolderAdapterPreOrderHistoryRecy=new ViewHolderAdapterPreOrderHistoryRecy(view);

        return viewHolderAdapterPreOrderHistoryRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterPreOrderHistoryRecy holder, int position) {
        holder.tvPreOrderId.setText(preOrderHistoryList.get(position).getPreOrdrId());
        holder.tvPreOrderProductName.setText(preOrderHistoryList.get(position).getPreOrderProductName());
        holder.tvPreOrderDeliveryDate.setText(preOrderHistoryList.get(position).getPreOrderProductDeliverDate());
        holder.tvPreOrderPaymentStatus.setText(preOrderHistoryList.get(position).getPreOrderPaymentStatus());
    }

    @Override
    public int getItemCount() {
        return preOrderHistoryList.size();
    }

    public class ViewHolderAdapterPreOrderHistoryRecy extends RecyclerView.ViewHolder{

        TextView tvPreOrderId, tvPreOrderProductName,tvPreOrderDeliveryDate,tvPreOrderPaymentStatus;

        public ViewHolderAdapterPreOrderHistoryRecy(@NonNull View itemView) {
            super(itemView);
            tvPreOrderId=itemView.findViewById(R.id.tvPreOrderId);
            tvPreOrderProductName=itemView.findViewById(R.id.tvProductName);
            tvPreOrderDeliveryDate=itemView.findViewById(R.id.tvDeliveryDate);
            tvPreOrderPaymentStatus=itemView.findViewById(R.id.tvVerificationStatus);


        }
    }
}
