package com.freshnin.userapplication.viewholder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelNewUserRegistration;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.repository.RepositoryNewUserRegistration;

public class ViewModelNewUserRegistration extends AndroidViewModel {
    private RepositoryNewUserRegistration repositoryNewUserRegistration;


    public ViewModelNewUserRegistration(@NonNull Application application) {
        super(application);
        repositoryNewUserRegistration=new RepositoryNewUserRegistration();
    }

    public LiveData<ModelNewUserRegistration> newUserRegistration(ModelUser user){
        return repositoryNewUserRegistration.newUserRegistration(user);
    }
}
