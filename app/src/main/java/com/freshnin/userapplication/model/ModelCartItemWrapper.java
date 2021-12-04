package com.freshnin.userapplication.model;



import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ModelCartItemWrapper implements Parcelable {
    private  List<ModelMyCartItem> cartItems;

    public ModelCartItemWrapper(List<ModelMyCartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<ModelMyCartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ModelMyCartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public static Creator<ModelCartItemWrapper> getCREATOR() {
        return CREATOR;
    }

    protected ModelCartItemWrapper(Parcel in) {
        cartItems = in.createTypedArrayList(ModelMyCartItem.CREATOR);
    }

    public static final Creator<ModelCartItemWrapper> CREATOR = new Creator<ModelCartItemWrapper>() {
        @Override
        public ModelCartItemWrapper createFromParcel(Parcel in) {
            return new ModelCartItemWrapper(in);
        }

        @Override
        public ModelCartItemWrapper[] newArray(int size) {
            return new ModelCartItemWrapper[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(cartItems);
    }
}
