package com.example.lenovo.athletesfood.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.athletesfood.AthletesFoodApp;
import com.example.lenovo.athletesfood.MenuCalculator;
import com.example.lenovo.athletesfood.OnMenuCalculatorFinishedListener;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.adapters.NewMenuRecyclerAdapter;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.models.dataBase.food.FoodDao;

import java.util.ArrayList;
import java.util.List;

public class NewMenuFragment extends Fragment implements View.OnClickListener,
        OnMenuCalculatorFinishedListener {
    private Button mBtnAddNewProduct;
    private String mFoodName;
    private RecyclerView mRvProduct;
    private ArrayList<Food> mAlFood = new ArrayList<>();
    private int mIndexOfReiteration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_menu, container, false);

        mBtnAddNewProduct = view.findViewById(R.id.button_add_new_product);
        mBtnAddNewProduct.setOnClickListener(this);

        if (getArguments() != null) {
            mFoodName = getArguments().getString(
                    Constants.ARGS_KEY_FOOD_NAME);
        }

        new FoodAsyncTask().execute();

        mRvProduct = (RecyclerView) view.findViewById(R.id.recycler_view_new_menu_product);
        mRvProduct.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onClick(View view) {
        OnAddedNewProductListener onAddedNewProductListener =
                (OnAddedNewProductListener) getActivity();
        if (onAddedNewProductListener != null) {
            onAddedNewProductListener.onNewProductAdded();
        }
    }

    @Override
    public void onMenuCalculatorFinished(int mSumCalories, ArrayList<Integer> mAlWeight) {
        mRvProduct.setAdapter(new NewMenuRecyclerAdapter(mAlFood, mAlWeight, mSumCalories));
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

            MenuCalculator menuCalculator = new MenuCalculator(mAlFood,
                    NewMenuFragment.this);

            mIndexOfReiteration = Constants.INDEX_OF_REITERATION_NEGATIVE;
        }

        private void checkForReiteration(ArrayList<Food> mAlFood, String mFoodName) {
            for (int y = 0; y < mAlFood.size(); y++) {
                if (mAlFood.get(y).getFoodName().equals(mFoodName)) {
                    mIndexOfReiteration = Constants.INDEX_OF_REITERATION_POSITIVE;
                }
            }
        }

        private void addProductInMenuList(ArrayList<Food> foods) {
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).getFoodName().equals(mFoodName)) {
                    if (mAlFood.size() == Constants.NUMBER_NULL) {
                        mAlFood.add(foods.get(i));
                        mIndexOfReiteration = Constants.INDEX_OF_REITERATION_POSITIVE;
                    } else {
                        checkForReiteration(mAlFood, mFoodName);
                    }

                    if (mIndexOfReiteration != Constants.INDEX_OF_REITERATION_POSITIVE) {
                        mAlFood.add(foods.get(i));
                    }
                }
            }
        }
    }
}


