package com.example.lenovo.athletesfood.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.athletesfood.R;

public class NewMenuViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvProductName;
    private TextView mTvProductWeight;
    private TextView mTvProductKcal;
    private Button mBtnAddWeight;
    private Button mBtnLoseWeight;

    public NewMenuViewHolder(@NonNull View itemView) {
        super(itemView);

        mTvProductName = (TextView) itemView.findViewById(R.id.text_view_product_name);
        mTvProductWeight = (TextView) itemView.findViewById(R.id.text_view_product_weight);
        mTvProductKcal = (TextView) itemView.findViewById(R.id.text_view_product_kcal);
        mBtnAddWeight = (Button) itemView.findViewById(R.id.button_add_weight);
        mBtnLoseWeight = (Button) itemView.findViewById(R.id.button_lose_weight);
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

    public Button getmBtnAddWeight() {
        return mBtnAddWeight;
    }

    public void setmBtnAddWeight(Button mBtnAddWeight) {
        this.mBtnAddWeight = mBtnAddWeight;
    }

    public Button getmBtnLoseWeight() {
        return mBtnLoseWeight;
    }

    public void setmBtnLoseWeight(Button mBtnLoseWeight) {
        this.mBtnLoseWeight = mBtnLoseWeight;
    }
}
