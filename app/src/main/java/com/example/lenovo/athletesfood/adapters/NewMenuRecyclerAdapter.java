package com.example.lenovo.athletesfood.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.athletesfood.OnChangeWeightButtonClickListener;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.viewHolders.NewMenuViewHolder;

import java.util.ArrayList;

public class NewMenuRecyclerAdapter extends RecyclerView.Adapter<NewMenuViewHolder> {
    private ArrayList<Food> mAlFood;
    private ArrayList<Integer> mAlWeight;
    private ArrayList<Integer> mAlCalories;
    private OnChangeWeightButtonClickListener onChangeWeightButtonClickListener;
    private int mWeight;
    private int mCalories;

    public NewMenuRecyclerAdapter(ArrayList<Food> foods, ArrayList<Integer> mAlWeight,
                                  ArrayList<Integer> mAlCalories,
                                  OnChangeWeightButtonClickListener onChangeWeightButtonClickListener) {
        mAlFood = foods;
        this.mAlWeight = mAlWeight;
        this.mAlCalories = mAlCalories;
        this.onChangeWeightButtonClickListener = onChangeWeightButtonClickListener;
    }

    @NonNull
    @Override
    public NewMenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_new_menu_product, viewGroup, false);
        return new NewMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewMenuViewHolder newMenuViewHolder, final int i) {
        newMenuViewHolder.getmTvProductName().setText(mAlFood.get(i).getFoodName());
        newMenuViewHolder.getmTvProductWeight().setText(String.valueOf(mAlWeight.get(i)));
        newMenuViewHolder.getmTvProductKcal().setText(String.valueOf(mAlCalories.get(i)));
        newMenuViewHolder.getmBtnAddWeight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChangeWeightButtonClickListener.onChangeWeightButtonClick(i,
                        (int) mAlFood.get(i).getKcal(), Constants.FLAG_ADD_WEIGHT, mAlWeight.get(i));
            }
        });
        newMenuViewHolder.getmBtnLoseWeight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChangeWeightButtonClickListener.onChangeWeightButtonClick(i,
                        (int) mAlFood.get(i).getKcal(), Constants.FLAG_LOSE_WEIGHT, mAlWeight.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAlFood.size();
    }

    public void changeProductWeight(int i, int calories, int flag, int weight) {
        switch (flag) {
            case Constants.FLAG_ADD_WEIGHT:
                mWeight = mAlWeight.get(i) + weight;
                break;
            case Constants.FLAG_LOSE_WEIGHT:
                if (mAlWeight.get(i) > Constants.NUMBER_NULL)
                    mWeight = mAlWeight.get(i) - weight;
                break;
            default:
                break;
        }
        mAlWeight.set(i, mWeight);
        mCalories = (int) (((float) mWeight / Constants.NUMBER_HUNDRED) * calories);
        mAlCalories.set(i, mCalories);

        notifyItemChanged(i);
        mWeight = Constants.NUMBER_NULL;
    }
}
