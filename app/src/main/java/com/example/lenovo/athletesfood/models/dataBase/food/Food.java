package com.example.lenovo.athletesfood.models.dataBase.food;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.lenovo.athletesfood.models.constant.Constants;

@Entity(tableName = Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE)
public class Food {
    @PrimaryKey @NonNull
    private String foodName;
    private String foodType;
    private float kcal;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getKcal() {
        return kcal;
    }

    public void setKcal(float kcal) {
        this.kcal = kcal;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
