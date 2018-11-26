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
import android.widget.ImageView;

import com.example.lenovo.athletesfood.AthletesFoodApp;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.adapters.expandableRecyclerView.DatabaseRecyclerAdapter;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.models.dataBase.food.FoodDao;
import com.example.lenovo.athletesfood.models.expandableRecyclerView.Product;
import com.example.lenovo.athletesfood.models.expandableRecyclerView.ProductType;
import com.squareup.picasso.Picasso;
import com.thoughtbot.expandablerecyclerview.listeners.GroupExpandCollapseListener;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FoodDatabaseFragment extends Fragment implements View.OnClickListener {
    private RecyclerView mRvFoodDatabase;
    private ArrayList<String> mAlFoodType;
    private List<ProductType> mListProductType;
    private Button mBtnAddNewFood;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_data_base, container, false);

        new FoodDatabaseAsyncTask().execute();

        mRvFoodDatabase = (RecyclerView) view.findViewById(R.id.recycler_view_database);
        mRvFoodDatabase.setLayoutManager(new LinearLayoutManager(getActivity()));

        mBtnAddNewFood = (Button) view.findViewById(R.id.button_add_new_food_in_database);
        mBtnAddNewFood.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        OnAddNewFoodClickListener onAddNewFoodClickListener =
                (OnAddNewFoodClickListener) getActivity();
        if (onAddNewFoodClickListener != null)
            onAddNewFoodClickListener.onAddNewFoodClick(mAlFoodType);
    }

    public interface OnAddNewFoodClickListener{
        void onAddNewFoodClick(ArrayList<String> mAlFoodType);
    }

    class FoodDatabaseAsyncTask extends AsyncTask<Void, Void, List<Food>> {

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
            return foods;
        }

        @Override
        protected void onPostExecute(List<Food> foods) {
            super.onPostExecute(foods);
            mListProductType = new ArrayList<>();
            for (int i = 0; i < mAlFoodType.size(); i++) {
                mListProductType.add(new ProductType(mAlFoodType.get(i), fillProductList(foods, i)));
            }
            mRvFoodDatabase.setAdapter(new DatabaseRecyclerAdapter(mListProductType));
        }

        private List<Product> fillProductList(List<Food> foods , int i){
            List<Product> mListProduct = new ArrayList<>();
            for (int y = 0; y < foods.size(); y++) {
                if (foods.get(y).getFoodType().equals(mAlFoodType.get(i)))
                    mListProduct.add(
                            new Product(
                                    foods.get(y).getFoodName(),
                                    foods.get(y).getProteins(),
                                    foods.get(y).getFats(),
                                    foods.get(y).getCarbohydrates(),
                                    foods.get(y).getKcal()));
            }

            return mListProduct;
        }
    }

}
