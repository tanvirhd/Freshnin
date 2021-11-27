package com.freshnin.userapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelLogIn;
import com.freshnin.userapplication.model.ModelNewUserRegistration;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.model.ModelUserVerify;
import com.freshnin.userapplication.repository.RepositoryUser;

public class ViewModelUser extends AndroidViewModel {
    private RepositoryUser repositoryUser;

    public ViewModelUser(@NonNull Application application) {
        super(application);
        repositoryUser = new RepositoryUser();
    }

    public LiveData<ModelLogIn> checkValidLogIn(ModelUser user){
        return repositoryUser.checkValidLogIn(user);
    }

    public LiveData<ModelNewUserRegistration> newUserRegistration(ModelUser user){
        return repositoryUser.newUserRegistration(user);
    }

    public LiveData<ModelUserVerify> checkUserValidation(ModelUser user){
        return repositoryUser.checkUserValidation(user);
    }

}