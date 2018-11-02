package com.example.lenovo.athletesfood.fragments;


import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.lenovo.athletesfood.AthletesFoodApp;
import com.example.lenovo.athletesfood.BodyAppActivity;
import com.example.lenovo.athletesfood.OnProductCategoriesClickListener;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.adapters.ProductCategoriesRecyclerAdapter;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.models.dataBase.food.FoodDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ProductCategoriesFragment extends Fragment implements OnProductCategoriesClickListener {
    private RecyclerView mRvProductCategories;
    private ArrayList<String> mAlFoodType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_categories, container,
                false);

        new ProductCategoriesAsyncTask().execute();
        mRvProductCategories = (RecyclerView) view.findViewById(
                R.id.recycler_view_product_categories);
        mRvProductCategories.setLayoutManager(new GridLayoutManager(getActivity(),
                Constants.GRID_LAYOUT_SPAN_COUNT));

        return view;
    }

    @Override
    public void onProductCategoriesClick(String foodType) {
        OnSelectedProductCategoriesListener onSelectedProductCategoriesListener =
                (OnSelectedProductCategoriesListener) getActivity();
        if (onSelectedProductCategoriesListener != null)
        onSelectedProductCategoriesListener.onProductCategoriesSelected(foodType);
    }

    class ProductCategoriesAsyncTask extends AsyncTask<Void, Void, List<Food>> {

        @Override
        protected List<Food> doInBackground(Void... voids) {
            DataBase dataBase = AthletesFoodApp.getInstance().getDataBase();
            FoodDao foodDao = dataBase.foodDao();
            List<Food> foods = foodDao.getAll();
            ArrayList<String> mAlAllFoodType = new ArrayList<>();

            for (int i = 0; i < foods.size(); i++) {
                String mFoodType = foods.get(i).getFoodType();
                mAlAllFoodType.add(mFoodType);
                mAlFoodType = new ArrayList<>(new HashSet<>(mAlAllFoodType));
            }
            return foodDao.getAll();
        }

        @Override
        protected void onPostExecute(List<Food> foods) {
            super.onPostExecute(foods);
            mRvProductCategories.setAdapter(new ProductCategoriesRecyclerAdapter(mAlFoodType,
                    ProductCategoriesFragment.this));
        }
    }

    public interface OnSelectedProductCategoriesListener {
        void onProductCategoriesSelected(String productCategories);
    }
}
