package com.example.lenovo.athletesfood;

import android.os.AsyncTask;
import android.util.Log;

import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.models.dataBase.food.FoodDao;

public class FoodAsyncTask extends AsyncTask<Food, Void, Void> {
    private int TASK_KEY;

    public FoodAsyncTask(int TASK_KEY) {
        this.TASK_KEY = TASK_KEY;
    }

    @Override
    protected Void doInBackground(Food... foods) {
        DataBase dataBase = AthletesFoodApp.getInstance().getDataBase();
        FoodDao foodDao = dataBase.foodDao();

        switch (TASK_KEY) {
            case Constants.TASK_INSERT:
                foodDao.insertFood(foods[0]);
                Log.d("AAA", "Room Food: " + foodDao.getAll().toString());
                break;
            case Constants.TASK_DELETE:
                break;
        }

        return null;
    }
}
