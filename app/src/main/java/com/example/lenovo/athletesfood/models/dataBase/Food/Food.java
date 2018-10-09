package com.example.lenovo.athletesfood.models.dataBase.Food;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.lenovo.athletesfood.models.constant.Constants;

@Entity(tableName = Constants.ARGS_KEY_DATABASE_TABLE_NAME_FOOD_DATABASE)
public class Food {
    @PrimaryKey @NonNull
    private String nameFood;
    private float kcal;

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public float getKcal() {
        return kcal;
    }

    public void setKcal(float kcal) {
        this.kcal = kcal;
    }
}
