package com.example.lenovo.athletesfood.models.dataBase.food;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.lenovo.athletesfood.models.constant.Constants;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FoodDao {
    @Insert
    void insertFood(Food food);

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE)
    List<Food> getAll();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'meat'")
    List<Food> getAllMeat();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'porridge'")
    List<Food> getAllPorridge();
}
