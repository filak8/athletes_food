package com.example.lenovo.athletesfood.models.dataBase.Food;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.lenovo.athletesfood.models.constant.Constants;

@Dao
public interface FoodDao {
    @Insert
    void insertFood(Food food);

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE)
    Food getAll();
}
