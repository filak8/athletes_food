package com.example.lenovo.athletesfood.viewHolders;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.athletesfood.R;

public class ProductCategoriesViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvProductCategoriesImage;
    private TextView mTvProductCategoriesName;
    private ConstraintLayout mClProductCategories;

    public ProductCategoriesViewHolder(@NonNull View itemView) {
        super(itemView);

        mIvProductCategoriesImage = itemView.findViewById(R.id.image_view_product_categories_image);
        mTvProductCategoriesName = itemView.findViewById(R.id.text_view_product_categories_name);
        mClProductCategories = itemView.findViewById(R.id.constraint_layout_recycler_item_product_categories);
    }

    public ImageView getmIvProductCategoriesImage() {
        return mIvProductCategoriesImage;
    }

    public void setmIvProductCategoriesImage(ImageView mIvProductCategoriesImage) {
        this.mIvProductCategoriesImage = mIvProductCategoriesImage;
    }

    public TextView getmTvProductCategoriesName() {
        return mTvProductCategoriesName;
    }

    public void setmTvProductCategoriesName(TextView mTvProductCategoriesName) {
        this.mTvProductCategoriesName = mTvProductCategoriesName;
    }

    public ConstraintLayout getmClProductCategories() {
        return mClProductCategories;
    }

    public void setmClProductCategories(ConstraintLayout mClProductCategories) {
        this.mClProductCategories = mClProductCategories;
    }
}
