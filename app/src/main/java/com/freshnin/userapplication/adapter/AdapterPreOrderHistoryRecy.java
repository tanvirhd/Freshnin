package com.freshnin.userapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.callbacks.AdapterPreOrderHistoryRecycCallbacks;
import com.freshnin.userapplication.model.ModelOngoingPreOrder;

import java.util.List;

public class AdapterPreOrderHistoryRecy extends RecyclerView.Adapter<AdapterPreOrderHistoryRecy.ViewHolderAdapterPreOrderHistoryRecy> {

    List<ModelOngoingPreOrder> onGoingPreOrder;
    Context context;
    AdapterPreOrderHistoryRecycCallbacks callbacks;

    public AdapterPreOrderHistoryRecy(List<ModelOngoingPreOrder> onGoingPreOrder, Context context, AdapterPreOrderHistoryRecycCallbacks callbacks) {
        this.onGoingPreOrder = onGoingPreOrder;
        this.context = context;
        this.callbacks=callbacks;
    }

    @NonNull
    @Override
    public ViewHolderAdapterPreOrderHistoryRecy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_preorder_history_cardview,parent,false);
        ViewHolderAdapterPreOrderHistoryRecy viewHolderAdapterPreOrderHistoryRecy=new ViewHolderAdapterPreOrderHistoryRecy(view);

        return viewHolderAdapterPreOrderHistoryRecy;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterPreOrderHistoryRecy holder, int position) {
        holder.tvPreOrderId.setText(onGoingPreOrder.get(position).getOrderId());
        holder.tvPreOrderProductName.setText(onGoingPreOrder.get(position).getItemName());
        holder.tvPreOrderDeliveryDate.setText(onGoingPreOrder.get(position).getOrderDeliveryDate());

        switch (onGoingPreOrder.get(position).getAdvancePaymentStatus()){
            case "1":
                holder.tvPreOrderPaymentStatus.setText("Verification Pending");
                break;
            case "2":
                holder.tvPreOrderPaymentStatus.setText("Verified");
                break;
            case "3":
                holder.tvPreOrderPaymentStatus.setText("Declined");
                break;


        }
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onDetailsClicked(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return onGoingPreOrder.size();
    }

    public class ViewHolderAdapterPreOrderHistoryRecy extends RecyclerView.ViewHolder{

        TextView tvPreOrderId, tvPreOrderProductName,tvPreOrderDeliveryDate,tvPreOrderPaymentStatus;
        TextView btnDetails;

        public ViewHolderAdapterPreOrderHistoryRecy(@NonNull View itemView) {
            super(itemView);
            tvPreOrderId=itemView.findViewById(R.id.apoh_tvPreOrderId);
            tvPreOrderProductName=itemView.findViewById(R.id.apoh_tvProductName);
            tvPreOrderDeliveryDate=itemView.findViewById(R.id.apoh_tvDeliveryDate);
            tvPreOrderPaymentStatus=itemView.findViewById(R.id.apoh_tvVerificationStatus);
            btnDetails=itemView.findViewById(R.id.apoh_btnPreorderDetailsView);
        }
    }
}
