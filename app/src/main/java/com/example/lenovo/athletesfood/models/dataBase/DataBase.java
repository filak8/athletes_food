package com.example.lenovo.athletesfood.models.dataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract UserDao userDao();
}
