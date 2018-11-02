package com.example.lenovo.athletesfood.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.athletesfood.OnProductCategoriesClickListener;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.viewHolders.ProductCategoriesViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductCategoriesRecyclerAdapter extends RecyclerView.Adapter<ProductCategoriesViewHolder> {
    private ArrayList<String> mAlProductCategoriesName;
    private int[] mAlProductCategoriesImage;
    private OnProductCategoriesClickListener productCategoriesClickListener;

    public ProductCategoriesRecyclerAdapter(ArrayList<String> mAlProductCategoriesName/*, int[] mAlProductCategoriesImage*/,
                                            OnProductCategoriesClickListener
                                                    productCategoriesClickListener) {
        this.mAlProductCategoriesName = mAlProductCategoriesName;
       /* this.mAlProductCategoriesImage = mAlProductCategoriesImage;*/
        this.productCategoriesClickListener = productCategoriesClickListener;
    }

    @NonNull
    @Override
    public ProductCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_product_categories, viewGroup, false);
        return new ProductCategoriesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductCategoriesViewHolder
                                             productCategoriesViewHolder, final int i) {
        productCategoriesViewHolder.getmTvProductCategoriesName()
                .setText(mAlProductCategoriesName.get(i));
        /*Picasso.get().load(mAlProductCategoriesImage[i]).into(productCategoriesViewHolder.getmIvProductCategoriesImage());*/
        productCategoriesViewHolder.getmClProductCategories().setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productCategoriesClickListener.onProductCategoriesClick(
                        mAlProductCategoriesName.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mAlProductCategoriesName.size();
    }
}
