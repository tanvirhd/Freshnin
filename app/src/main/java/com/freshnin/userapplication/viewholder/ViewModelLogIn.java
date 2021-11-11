package com.freshnin.userapplication.viewholder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelLogIn;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.repository.RepositoryLogIn;

public class ViewModelLogIn extends AndroidViewModel {
    private RepositoryLogIn repositoryLogIn;

    public ViewModelLogIn(@NonNull Application application) {
        super(application);
        repositoryLogIn =new RepositoryLogIn();
    }

    public LiveData<ModelLogIn> checkValidLogIn(ModelUser user){
        return repositoryLogIn.checkValidLogIn(user);
    }
}
