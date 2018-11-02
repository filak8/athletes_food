package com.example.lenovo.athletesfood.viewHolders;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.athletesfood.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private TextView tvProductName;
    private ConstraintLayout clProduct;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        tvProductName = itemView.findViewById(R.id.text_view_product_name);
        clProduct = itemView.findViewById(R.id.constraint_layout_recycler_item_product);
    }

    public TextView getTvProductName() {
        return tvProductName;
    }

    public void setTvProductName(TextView tvProductName) {
        this.tvProductName = tvProductName;
    }

    public ConstraintLayout getClProduct() {
        return clProduct;
    }

    public void setClProduct(ConstraintLayout clProduct) {
        this.clProduct = clProduct;
    }
}
