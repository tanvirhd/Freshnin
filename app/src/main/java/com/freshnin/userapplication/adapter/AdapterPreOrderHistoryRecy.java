package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.callbacks.AdapterPreOrderHistoryRecycCallbacks;
import com.freshnin.userapplication.model.ModelPreOrderHistory;

import java.util.List;

public class AdapterPreOrderHistoryRecy extends RecyclerView.Adapter<AdapterPreOrderHistoryRecy.ViewHolderAdapterPreOrderHistoryRecy> {

    List<ModelPreOrderHistory> preOrderHistoryList;
    Context context;
    AdapterPreOrderHistoryRecycCallbacks callbacks;

    public AdapterPreOrderHistoryRecy(List<ModelPreOrderHistory> preOrderHistoryList, Context context,AdapterPreOrderHistoryRecycCallbacks callbacks) {
        this.preOrderHistoryList = preOrderHistoryList;
        this.context = context;
        this.callbacks=callbacks;
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

        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onDetailsClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return preOrderHistoryList.size();
    }

    public class ViewHolderAdapterPreOrderHistoryRecy extends RecyclerView.ViewHolder{

        TextView tvPreOrderId, tvPreOrderProductName,tvPreOrderDeliveryDate,tvPreOrderPaymentStatus;
        TextView btnDetails;

        public ViewHolderAdapterPreOrderHistoryRecy(@NonNull View itemView) {
            super(itemView);
            tvPreOrderId=itemView.findViewById(R.id.tvPreOrderId);
            tvPreOrderProductName=itemView.findViewById(R.id.tvProductName);
            tvPreOrderDeliveryDate=itemView.findViewById(R.id.tvDeliveryDate);
            tvPreOrderPaymentStatus=itemView.findViewById(R.id.tvVerificationStatus);
            btnDetails=itemView.findViewById(R.id.btnPreorderDetailsView);
        }
    }
}
