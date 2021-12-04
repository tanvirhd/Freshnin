package com.freshnin.userapplication.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.freshnin.userapplication.R;
import com.freshnin.userapplication.model.ModelOngoingPreOrder;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActivityPreOrderDetails extends AppCompatActivity {

    private static final String TAG = "ActivityPreOrderDetails";
    private Toolbar toolbar;
    private AppCompatTextView tvOrderId;
    private ImageView ivItemImage;
    private TextView tvItemName;
    private TextView tvTotalQuantity;
    private TextView tvTransactionId;
    private TextView tvAdvencedOrderStatus;
    private TextView tvBillingItemName;
    private TextView tvItemPrice, tvDeliveryCharge,tvPaidAmount;
    private TextView tvTotalBill;
    private TextView tvDeliveryAddress;
    private TextView tvDeliveryDate;
    private TextView tvPaymentType;


    private ModelOngoingPreOrder orderDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder_details);

        try {
            init();
        } catch (ParseException e) {
            Log.d(TAG, "onCreate: error"+e.getMessage());;
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    private void init() throws ParseException {
        toolbar=findViewById(R.id.apod_preOrder_Details_main_toolbar);
        setSupportActionBar(toolbar);

        tvOrderId=findViewById(R.id.apod_tvPreOrderId_fromHistoryDetails);
        ivItemImage=findViewById(R.id.apod_ivItemImage);
        tvItemName=findViewById(R.id.apod_tvItemName);
        tvTotalQuantity=findViewById(R.id.apod_tvItemQuantity);
        tvTransactionId=findViewById(R.id.apod_transaction_id);
        tvAdvencedOrderStatus =findViewById(R.id.apod_order_satus);
        tvBillingItemName=findViewById(R.id.apod_tv_billing_item_name);
        tvItemPrice=findViewById(R.id.apod_tvItemPrice);
        tvDeliveryCharge=findViewById(R.id.apod_tvItemDeliveryCharge);
        tvPaidAmount=findViewById(R.id.apod_tvPaidAmount);
        tvTotalBill=findViewById(R.id.apod_tvTotalBill);
        tvDeliveryAddress=findViewById(R.id.apod_tv_delivery_address);
        tvDeliveryDate=findViewById(R.id.apod_tv_delivery_date);
        tvPaymentType=findViewById(R.id.apod_tv_paymentType);

        orderDetails=getIntent().getExtras().getParcelable("parcel");
        if(orderDetails!=null){
            updateUi();
        }
    }

    private void updateUi() throws ParseException {
        tvOrderId.setText("OrderId: "+orderDetails.getOrderId());
        Picasso.with(this).load(orderDetails.getUrl()).into(ivItemImage);
        tvItemName.setText(orderDetails.getItemName());
        tvTotalQuantity.setText(orderDetails.getOrderQuantity());
        tvTransactionId.setText(orderDetails.getTransactionId());

        tvAdvencedOrderStatus.setText(getOrderStatus(orderDetails.getOrderStatus()));
        tvBillingItemName.setText(orderDetails.getItemName());

        int itemPrice=Integer.parseInt(orderDetails.getTotalBill())
                -Integer.parseInt(orderDetails.getDeliveryCharge());
        tvItemPrice.setText(String.valueOf(itemPrice));

        tvDeliveryCharge.setText(orderDetails.getDeliveryCharge());
        tvDeliveryAddress.setText(orderDetails.getDeliveryAddress());
        tvPaidAmount.setText(orderDetails.getAdvancePyamentAmount());
        tvTotalBill.setText(orderDetails.getTotalBill());
        tvDeliveryDate.setText(getDeliveryDate());
        tvPaymentType.setText(orderDetails.getPaymnetMethod());

    }

    private String getDeliveryDate() throws ParseException {

        SimpleDateFormat month_date = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        String actualDate = orderDetails.getOrderDeliveryDate();

        Date date = sdf.parse(actualDate);

        return month_date.format(date);
    }

    private String getOrderStatus(String orderStatus) {
        String status;
        switch(orderStatus){
            case "1":
                status=getString(R.string.verificationPending);
                break;
            case "2":
                status=getString(R.string.verified);
                break;
            case "3":
                status=getString(R.string.declined);
                break;
            default:
               status="--";
        }
        return status;
    }


}
