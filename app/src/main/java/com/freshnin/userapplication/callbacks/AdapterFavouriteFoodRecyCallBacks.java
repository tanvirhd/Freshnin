package com.freshnin.userapplication.callbacks;

import com.freshnin.userapplication.model.ModelFoodItem;
import com.freshnin.userapplication.model.ModelRegularItem;

public interface AdapterFavouriteFoodRecyCallBacks {

    void onUnFavouriteClicked(ModelRegularItem modelFoodItem, int position);

    void onItemClicked(int index);

    void onAddToCartClicked(int index);
}
