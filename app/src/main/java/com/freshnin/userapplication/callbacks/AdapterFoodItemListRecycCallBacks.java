package com.freshnin.userapplication.callbacks;

import com.freshnin.userapplication.model.ModelRegularItem;

public interface AdapterFoodItemListRecycCallBacks {
    void onItemClick(int index);

    void onAddToCartClicked(int index);

    void onFavouriteClicked(int position);
}
