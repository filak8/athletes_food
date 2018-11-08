package com.example.lenovo.athletesfood;

import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;

import java.util.ArrayList;

public class MenuCalculator implements OnAsyncTaskFinishedListener {
    /* float proteins = 0.3f;
     float fats = 0.2f;
     float carbohydrates = 0.5f;*/
    private float mPortionWeightInGrams = 100f;
    private float mSumCalories;
    private int mProductCalories;
    private ArrayList<Food> mAlAddedFood;
    private ArrayList<Integer> mAlProductWeight;
    private OnMenuCalculatorFinishedListener onMenuCalculatorFinishedListener;

    public MenuCalculator(ArrayList<Food> mAlAddedFood,
                          OnMenuCalculatorFinishedListener onMenuCalculatorFinishedListener) {
        this.onMenuCalculatorFinishedListener = onMenuCalculatorFinishedListener;
        this.mAlAddedFood = mAlAddedFood;

        mAlProductWeight = new ArrayList<>();
        EnergyPoolCalculator mEnergyPoolCalculator = new EnergyPoolCalculator(
                this);
    }

    @Override
    public void onAsyncTaskFinished(int energyPool) {
        for (int i = 0; i < mAlAddedFood.size(); i++) {
            mSumCalories += mAlAddedFood.get(i).getKcal();
        }

        if (mSumCalories > energyPool) {
            for (int i = 0; i < Constants.NUMBER_TWO_HUNDRED; i++) {
                if (mSumCalories > energyPool) {
                    mSumCalories = mSumCalories * Constants.COEFF_OF_REDUCTION;
                    mPortionWeightInGrams = mPortionWeightInGrams * Constants.COEFF_OF_REDUCTION;
                } else {
                    calculateFinalCaloriesAndWeight();
                }
            }
        }

        if (mSumCalories < energyPool) {
            for (int i = 0; i < Constants.NUMBER_TWO_HUNDRED; i++) {
                if (mSumCalories < energyPool) {
                    mSumCalories = mSumCalories * Constants.COEFF_OF_MAGNIFICATION;
                    mPortionWeightInGrams = mPortionWeightInGrams * Constants.COEFF_OF_MAGNIFICATION;
                } else {
                    calculateFinalCaloriesAndWeight();
                }
            }
        }

        if (mSumCalories == energyPool) {
            calculateFinalCaloriesAndWeight();
        }

        onMenuCalculatorFinishedListener.onMenuCalculatorFinished(mProductCalories, mAlProductWeight);
    }

    private void calculateFinalCaloriesAndWeight() {
        mProductCalories = (int) (mSumCalories / mAlAddedFood.size());

        for (int i = 0; i < mAlAddedFood.size(); i++) {
            int mFoodWeight = (int) ((mProductCalories / mAlAddedFood.get(i).getKcal()) *
                    Constants.NUMBER_HUNDRED);
            mAlProductWeight.add(mFoodWeight);
        }

    }


}
