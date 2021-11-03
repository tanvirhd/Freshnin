package com.freshnin.userapplication.viewholder;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.freshnin.userapplication.model.ModelLogIn;
import com.freshnin.userapplication.model.ModelUser;
import com.freshnin.userapplication.repository.RepositoryValidLogIn;

public class ViewModelCheckValidLogIn extends AndroidViewModel {
    private RepositoryValidLogIn repositoryValidLogIn;

    public ViewModelCheckValidLogIn(@NonNull Application application) {
        super(application);
        repositoryValidLogIn=new RepositoryValidLogIn();
    }

    public LiveData<ModelLogIn> checkValidLogIn(ModelUser user){
        return repositoryValidLogIn.checkValidLogIn(user);
    }
}
