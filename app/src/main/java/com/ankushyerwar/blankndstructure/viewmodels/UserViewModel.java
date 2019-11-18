package com.ankushyerwar.blankndstructure.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ankushyerwar.blankndstructure.application.BaseApp;
import com.ankushyerwar.blankndstructure.data.DataRepository;

public class UserViewModel extends AndroidViewModel {

    private DataRepository mDataRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);

        mDataRepository = ((BaseApp)application).getRepository();

    }
}
