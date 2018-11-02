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
import android.widget.TextView;

import com.example.lenovo.athletesfood.AthletesFoodApp;
import com.example.lenovo.athletesfood.BodyAppActivity;
import com.example.lenovo.athletesfood.OnProductClickListener;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.adapters.ProductRecyclerAdapter;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.models.dataBase.food.FoodDao;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment implements OnProductClickListener {
    private String mFoodType;
    private RecyclerView mRvProduct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        if (getArguments() != null) {
            mFoodType = getArguments().getString(
                    Constants.ARGS_KEY_BUNDLE_SELECTED_PRODUCT_CATEGORIES);
        }
        new ProductAsyncTask().execute();

        mRvProduct = (RecyclerView) view.findViewById(R.id.recycler_view_product);
        mRvProduct.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onProductClick(Food food) {
        OnSelectedProductListener onSelectedProductListener =
                (OnSelectedProductListener) getActivity();
        if (onSelectedProductListener != null) {
            onSelectedProductListener.onProductSelected(food);
        }
    }

    class ProductAsyncTask extends AsyncTask<Void, Void, List<Food>> {
        List<Food> foods;

        @Override
        protected List<Food> doInBackground(Void... voids) {
            DataBase dataBase = AthletesFoodApp.getInstance().getDataBase();
            FoodDao foodDao = dataBase.foodDao();

            switch (mFoodType) {
                case Constants.ARGS_KEY_FOOD_TYPE_MEAT:
                    foods = foodDao.getAllMeat();
                    break;
                case Constants.ARGS_KEY_FOOD_TYPE_PORRIDGE:
                    foods = foodDao.getAllPorridge();
                    break;
                default:
                    break;
            }
            return foods;
        }

        @Override
        protected void onPostExecute(List<Food> foods) {
            super.onPostExecute(foods);
            ArrayList<Food> mAlFood = new ArrayList<>(foods);
            mRvProduct.setAdapter(new ProductRecyclerAdapter(mAlFood,
                    ProductFragment.this));
        }
    }

    public interface OnSelectedProductListener {
        void onProductSelected(Food food);
    }
}
