package com.freshnin.userapplication.callbacks;

import com.freshnin.userapplication.model.ModelMyCartItem;

public interface AdapterMyCartItemListRecyCallBacks {

    void onDeleteClicked(ModelMyCartItem myCartItem, int position);

    void onIncreaseClicked(int index);

    void onDecreaseClicked(int index);

}
