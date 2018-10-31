package com.example.lenovo.athletesfood.models.dataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.models.dataBase.food.FoodDao;
import com.example.lenovo.athletesfood.models.dataBase.user.User;
import com.example.lenovo.athletesfood.models.dataBase.user.UserDao;

@Database(entities = {User.class, Food.class}, version = 1, exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract FoodDao foodDao();
}
