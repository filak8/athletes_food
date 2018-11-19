package com.example.lenovo.athletesfood.viewHolders.expandableRecyclerView;

import android.view.View;
import android.widget.TextView;

import com.example.lenovo.athletesfood.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ProductViewHolder extends ChildViewHolder {
    private TextView mTvProductName;
    private TextView mTvProductProteins;
    private TextView mTvProductFats;
    private TextView mTvProductCarbohydrates;
    private TextView mTvProductCalories;

    public ProductViewHolder(View itemView) {
        super(itemView);

        mTvProductName = (TextView) itemView.findViewById
                (R.id.text_view_running_table_product__name);
        mTvProductProteins = (TextView) itemView.findViewById
                (R.id.text_view_running_table_product_proteins);
        mTvProductFats = (TextView) itemView.findViewById
                (R.id.text_view_running_table_product_fats);
        mTvProductCarbohydrates = (TextView) itemView.findViewById
                (R.id.text_view_running_table_product_carbohydrates);
        mTvProductCalories = (TextView) itemView.findViewById
                (R.id.text_view_running_table_product_calories);
    }

   public void setProductName(String name){
        mTvProductName.setText(name);
   }

   public void setProductProteins(float proteins){
        mTvProductProteins.setText(String.valueOf(proteins));
   }

   public void setProductFats(float fats){
        mTvProductFats.setText(String.valueOf(fats));
   }

   public void setProductCarbohydrates(float carbohydrates){
        mTvProductCarbohydrates.setText(String.valueOf(carbohydrates));
   }

   public void setProductCalories(float calories){
        mTvProductCalories.setText(String.valueOf(calories));
   }




}
