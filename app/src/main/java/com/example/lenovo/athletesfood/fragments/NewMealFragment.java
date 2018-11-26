package com.example.lenovo.athletesfood.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.athletesfood.AthletesFoodApp;
import com.example.lenovo.athletesfood.EnergyPoolCalculator;
import com.example.lenovo.athletesfood.OnAsyncTaskFinishedListener;
import com.example.lenovo.athletesfood.OnChangeWeightButtonClickListener;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.adapters.NewMenuRecyclerAdapter;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.models.dataBase.food.FoodDao;

import java.util.ArrayList;
import java.util.List;

public class NewMealFragment extends Fragment implements View.OnClickListener,
        OnChangeWeightButtonClickListener, OnAsyncTaskFinishedListener {
    private Button mBtnAddNewProduct;
    private Button mBtnSaveMenu;
    private TextView mTvEnergyPool;
    private String mFoodName;
    private String mArgumentFoodName;
    private int mDisplayedEnergyPool;
    private int mEnergyPool;
    private int mWeightInterval;
    private int mSavedEnergyPool;
    private RecyclerView mRvProduct;
    private ArrayList<Food> mAlFood = new ArrayList<>();
    private ArrayList<Integer> mAlWeight = new ArrayList<>();
    private ArrayList<Integer> mAlCalories = new ArrayList<>();
    private int mIndexOfReiteration;
    private NewMenuRecyclerAdapter mNewMenuRecyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_meal, container, false);

        mTvEnergyPool = (TextView) view.findViewById(R.id.text_view_energy_pool);
        mBtnAddNewProduct = (Button) view.findViewById(R.id.button_add_new_product);
        mBtnAddNewProduct.setOnClickListener(this);

        mBtnSaveMenu = (Button) view.findViewById(R.id.button_save_menu);
        mBtnSaveMenu.setOnClickListener(this);

        mRvProduct = (RecyclerView) view.findViewById(R.id.recycler_view_new_menu_product);
        mRvProduct.setLayoutManager(new LinearLayoutManager(getActivity()));

        addSelectedProduct();
        updateEnergyPoolValue();
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add_new_product:
                OnAddedNewProductListener onAddedNewProductListener =
                        (OnAddedNewProductListener) getActivity();
                if (onAddedNewProductListener != null) {
                    onAddedNewProductListener.onNewProductAdded();
                }
                break;
            case R.id.button_save_menu:
                break;
            default:
                break;
        }
    }

    @Override
    public void onChangeWeightButtonClick(int i, int calories, int flag, int weight) {
        changeEnergyPool(calories, flag, weight);
        mNewMenuRecyclerAdapter.changeProductWeight(i, calories, flag, mWeightInterval);
        mWeightInterval = Constants.WEIGHT_CHANGE_INTERVAL;
    }

    private void addSelectedProduct() {
        if (getArguments() != null) {
            mFoodName = getArguments().getString(
                    Constants.ARGS_KEY_FOOD_NAME);
        }
        new FoodAsyncTask().execute();
    }

    private void updateEnergyPoolValue() {
        Log.d("AAA", "mFoodName: " + mFoodName);
        if (mFoodName == null) {
            new EnergyPoolCalculator(this);
        }
        mWeightInterval = Constants.WEIGHT_CHANGE_INTERVAL;
        if (mDisplayedEnergyPool != Constants.NUMBER_NULL) {
            mTvEnergyPool.setText(String.valueOf(mDisplayedEnergyPool));
        } else {
            mTvEnergyPool.setText(String.valueOf(Constants.NUMBER_NULL));
        }
    }

    private void changeEnergyPool(int calories, int flag, int weight) {
        int mCaloriesChangeInterval =
                (calories * Constants.WEIGHT_CHANGE_INTERVAL) / Constants.NUMBER_HUNDRED;
        switch (flag) {
            case Constants.FLAG_ADD_WEIGHT:
                if ((mDisplayedEnergyPool - mCaloriesChangeInterval) < Constants.NUMBER_NULL) {
                    mWeightInterval = (mDisplayedEnergyPool * Constants.NUMBER_HUNDRED) / calories;
                    mDisplayedEnergyPool = Constants.NUMBER_NULL;
                } else {
                    if (mDisplayedEnergyPool != Constants.NUMBER_NULL)
                        mDisplayedEnergyPool = mDisplayedEnergyPool - mCaloriesChangeInterval;
                }
                break;
            case Constants.FLAG_LOSE_WEIGHT:
                if ((mDisplayedEnergyPool <= mEnergyPool) && (weight != Constants.NUMBER_NULL)) {
                    mDisplayedEnergyPool = mDisplayedEnergyPool + mCaloriesChangeInterval;
                }
                break;
        }

        mTvEnergyPool.setText(String.valueOf(mDisplayedEnergyPool));
    }

    @Override
    public void onAsyncTaskFinished(int energyPool) {
        mDisplayedEnergyPool = energyPool;
        mEnergyPool = energyPool;
        mTvEnergyPool.setText(String.valueOf(mDisplayedEnergyPool));
    }

    public interface OnAddedNewProductListener {
        void onNewProductAdded();
    }

    class FoodAsyncTask extends AsyncTask<Void, Void, ArrayList<Food>> {
        @Override
        protected ArrayList<Food> doInBackground(Void... voids) {
            DataBase dataBase = AthletesFoodApp.getInstance().getDataBase();
            FoodDao foodDao = dataBase.foodDao();
            List<Food> mLFood = foodDao.getAll();
            return new ArrayList<>(mLFood);
        }

        @Override
        protected void onPostExecute(ArrayList<Food> foods) {
            super.onPostExecute(foods);
            addProductInMenuList(foods);

            mNewMenuRecyclerAdapter = new NewMenuRecyclerAdapter(mAlFood, mAlWeight, mAlCalories,
                    NewMealFragment.this);
            mRvProduct.setAdapter(mNewMenuRecyclerAdapter);
            mIndexOfReiteration = Constants.INDEX_OF_REITERATION_NEGATIVE;
        }

        private void checkForReiteration(ArrayList<Food> mAlFood, String mFoodName) {
            for (int y = 0; y < mAlFood.size(); y++) {
                if (mAlFood.get(y).getFoodName().equals(mFoodName)) {
                    mIndexOfReiteration = Constants.INDEX_OF_REITERATION_POSITIVE;
                    if (!mFoodName.equals(Constants.ARGS_KEY_EMPTY_NAME)){}
                       /* Toast.makeText(getActivity(), getActivity().getResources()
                                        .getString(R.string.product_reiteration),
                                Toast.LENGTH_SHORT).show();*/
                }
            }
        }

        private void addProductInMenuList(ArrayList<Food> foods) {
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).getFoodName().equals(mFoodName)) {
                    if (mAlFood.size() == Constants.NUMBER_NULL) {
                        mAlFood.add(foods.get(i));
                        mAlWeight.add(Constants.NUMBER_NULL);
                        mAlCalories.add(Constants.NUMBER_NULL);
                        mIndexOfReiteration = Constants.INDEX_OF_REITERATION_POSITIVE;
                    } else {
                        checkForReiteration(mAlFood, mFoodName);
                    }

                    if (mIndexOfReiteration != Constants.INDEX_OF_REITERATION_POSITIVE) {
                        mAlFood.add(foods.get(i));
                        mAlWeight.add(Constants.NUMBER_NULL);
                        mAlCalories.add(Constants.NUMBER_NULL);
                    }
                }
            }
        }
    }
}


