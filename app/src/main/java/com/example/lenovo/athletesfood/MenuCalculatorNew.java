package com.example.lenovo.athletesfood;

import com.example.lenovo.athletesfood.models.dataBase.food.Food;

import java.util.ArrayList;

public class MenuCalculatorNew implements OnAsyncTaskFinishedListener {
    private Food mFood;
    private ArrayList<Food> mAlFoods;
    private ArrayList<Integer> mAlWeight;
    private ArrayList<Integer> mAlCalories;
    private OnMenuCalculatorNewFinishedListener onMenuCalculatorNewFinishedListener;

    public MenuCalculatorNew(ArrayList<Food> foods,
                             OnMenuCalculatorNewFinishedListener onMenuCalculatorNewFinishedListener) {
        this.mAlFoods = foods;
        this.onMenuCalculatorNewFinishedListener = onMenuCalculatorNewFinishedListener;

        mAlWeight = new ArrayList<>();
        mAlCalories = new ArrayList<>();

        EnergyPoolCalculator energyPoolCalculator = new EnergyPoolCalculator(
                this);
    }

    @Override
    public void onAsyncTaskFinished(int energyPool) {


        onMenuCalculatorNewFinishedListener.onMenuCalculatorNewFinished(mAlWeight, mAlCalories);
    }
}
