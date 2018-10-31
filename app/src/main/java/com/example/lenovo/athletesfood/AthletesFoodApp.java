package com.example.lenovo.athletesfood;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;

public class AthletesFoodApp extends Application {
    public static AthletesFoodApp instance;
    public DataBase dataBase;

    public DataBase getDataBase() {
        return dataBase;
    }

    public static AthletesFoodApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dataBase = Room.databaseBuilder(this, DataBase.class, Constants.ARGS_KEY_DATABASE_NAME).build();
    }
}
