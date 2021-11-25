package com.freshnin.userapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.model.ModelUserVerify;
import com.freshnin.userapplication.repository.RepositoryUserVerify;

public class ViewModelCheckUserVerify extends AndroidViewModel{
    private RepositoryUserVerify repositoryUserVerify;


    public ViewModelCheckUserVerify(@NonNull Application application) {
        super(application);
        repositoryUserVerify=new RepositoryUserVerify();
    }

    public LiveData<ModelUserVerify> checkUserValidation(ModelUser user){
        return repositoryUserVerify.checkUserValidation(user);
    }
}
