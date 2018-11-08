package com.example.lenovo.athletesfood.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.athletesfood.MenuCalculator;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.viewHolders.NewMenuViewHolder;

import java.util.ArrayList;

public class NewMenuRecyclerAdapter extends RecyclerView.Adapter<NewMenuViewHolder> {
    private ArrayList<Food> mAlFood;
    private ArrayList<Integer> mAlWeight;
    private int mKcal;

    public NewMenuRecyclerAdapter(ArrayList<Food> foods, ArrayList<Integer> weight, int kcal) {
        mAlFood = foods;
        mAlWeight = weight;
        mKcal= kcal;
    }

    @NonNull
    @Override
    public NewMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_new_menu_product, viewGroup, false);
        return new NewMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewMenuViewHolder newMenuViewHolder, int i) {
        newMenuViewHolder.getmTvProductName().setText(mAlFood.get(i).getFoodName());
        newMenuViewHolder.getmTvProductWeight().setText(String.valueOf(mAlWeight.get(i)));
        newMenuViewHolder.getmTvProductKcal().setText(String.valueOf(mKcal));
    }

    @Override
    public int getItemCount() {
        return mAlFood.size();
    }
}
