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

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Meat'")
    List<Food> getAllMeat();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Porridge'")
    List<Food> getAllPorridge();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Milk products'")
    List<Food> getAllMilkProducts();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Nuts'")
    List<Food> getAllNuts();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Vegetables'")
    List<Food> getAllVegetables();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Dried fruits'")
    List<Food> getAllDriedFruits();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Sea foods'")
    List<Food> getAllSeaFoods();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Fruits and berries'")
    List<Food> getAllFruitsAndBerries();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Eggs'")
    List<Food> getAllEggs();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Bakery products'")
    List<Food> getAllBakeryProducts();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Sweets'")
    List<Food> getAllSweets();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Butter, margarine, fats'")
    List<Food> getAllButterMargarineFats();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Sausages'")
    List<Food> getAllSausages();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Mushrooms'")
    List<Food> getAllMushrooms();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Soft drinks'")
    List<Food> getAllSoftDrinks();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Alcoholic beverages'")
    List<Food> getAllAlcoholicBeverages();

    @Query("SELECT * FROM " + Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE + " WHERE foodType = 'Other'")
    List<Food> getAllOther();
}
