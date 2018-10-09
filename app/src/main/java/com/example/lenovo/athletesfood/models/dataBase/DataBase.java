package com.example.lenovo.athletesfood.models.dataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.lenovo.athletesfood.models.dataBase.Food.Food;
import com.example.lenovo.athletesfood.models.dataBase.Food.FoodDao;
import com.example.lenovo.athletesfood.models.dataBase.User.User;
import com.example.lenovo.athletesfood.models.dataBase.User.UserDao;

@Database(entities = {User.class, Food.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract FoodDao foodDao();
}
