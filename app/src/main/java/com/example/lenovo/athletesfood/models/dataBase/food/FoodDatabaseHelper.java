package com.example.lenovo.athletesfood.models.dataBase.food;

import android.util.Log;

import com.example.lenovo.athletesfood.FoodAsyncTask;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;

import java.util.ArrayList;

public class FoodDatabaseHelper {

    private ArrayList<Food> foods;

    public FoodDatabaseHelper() {
        creatingAListOfProducts();
    }

    private void insertFoodInDatabase(ArrayList<Food> foods) {
        for (int i = 0; i < foods.size(); i++) {
            new FoodAsyncTask(Constants.TASK_INSERT).execute(foods.get(i));
            Log.d("AAA", "Food Database; insert " + foods.get(i).getFoodName());
        }
    }

    private void creatingAListOfProducts() {
        foods = new ArrayList<>();

        createNewFood("buckwheat", "porridge", 137);
        createNewFood("semolina", "porridge", 77);
        createNewFood("ricePorrige", "porridge", 79);
        createNewFood("mutton", "meat", 201);
        createNewFood("beef", "meat", 191);

        insertFoodInDatabase(foods);
    }

    private void createNewFood(String foodName, String foodType, int kcal) {
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodType(foodType);
        food.setKcal(kcal);
        foods.add(food);
    }
}
