package com.example.lenovo.athletesfood.viewHolders.expandableRecyclerView;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.athletesfood.R;
import com.squareup.picasso.Picasso;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class ProductTypeViewHolder extends GroupViewHolder {
    private TextView mTvProductType;

    public ProductTypeViewHolder(View itemView) {
        super(itemView);

        mTvProductType = (TextView) itemView.findViewById
                (R.id.expandable_recycler_item_product_type);
    }

    public void setProductType(String name) {
        mTvProductType.setText(name);
    }
}
