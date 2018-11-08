package com.example.lenovo.athletesfood.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.athletesfood.R;

public class NewMenuViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvProductName;
    private TextView mTvProductWeight;
    private TextView mTvProductKcal;

    public NewMenuViewHolder(@NonNull View itemView) {
        super(itemView);

        mTvProductName = (TextView) itemView.findViewById(R.id.text_view_product_name);
        mTvProductWeight = (TextView) itemView.findViewById(R.id.text_view_product_weight);
        mTvProductKcal = (TextView) itemView.findViewById(R.id.text_view_product_kcal);
    }

    public TextView getmTvProductName() {
        return mTvProductName;
    }

    public void setmTvProductName(TextView mTvProductName) {
        this.mTvProductName = mTvProductName;
    }

    public TextView getmTvProductWeight() {
        return mTvProductWeight;
    }

    public void setmTvProductWeight(TextView mTvProductWeight) {
        this.mTvProductWeight = mTvProductWeight;
    }

    public TextView getmTvProductKcal() {
        return mTvProductKcal;
    }

    public void setmTvProductKcal(TextView mTvProductKcal) {
        this.mTvProductKcal = mTvProductKcal;
    }
}
