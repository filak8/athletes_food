package com.example.lenovo.athletesfood.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.athletesfood.OnProductClickListener;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;
import com.example.lenovo.athletesfood.viewHolders.ProductViewHolder;

import java.util.ArrayList;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private ArrayList<Food> mAlFood;
    private OnProductClickListener onProductClickListener;

    public ProductRecyclerAdapter(ArrayList<Food> mAlFood,
                                  OnProductClickListener onProductClickListener) {
        this.mAlFood = mAlFood;
        this.onProductClickListener = onProductClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_product, viewGroup, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, final int i) {
        productViewHolder.getTvProductName().setText(mAlFood.get(i).getFoodName());
        productViewHolder.getClProduct().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onProductClickListener.onProductClick(mAlFood.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAlFood.size();
    }
}
