package com.example.lenovo.athletesfood.adapters.expandableRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.models.expandableRecyclerView.Product;
import com.example.lenovo.athletesfood.viewHolders.expandableRecyclerView.ProductTypeViewHolder;
import com.example.lenovo.athletesfood.viewHolders.expandableRecyclerView.ProductViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class DatabaseRecyclerAdapter extends ExpandableRecyclerViewAdapter
        <ProductTypeViewHolder, ProductViewHolder> {
    public DatabaseRecyclerAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ProductTypeViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.expandable_recycler_item_product_type, parent, false);
        return new ProductTypeViewHolder(view);
    }

    @Override
    public ProductViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.expandable_recycler_item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ProductViewHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {
        Product product = (Product) group.getItems().get(childIndex);
        holder.setProductName(product.getmProductName());
        holder.setProductProteins(product.getmProductProteins());
        holder.setProductFats(product.getmProductFats());
        holder.setProductCarbohydrates(product.getmProductCarbohydrates());
        holder.setProductCalories(product.getmProductCalories());
    }

    @Override
    public void onBindGroupViewHolder(ProductTypeViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setProductType(group.getTitle());
    }
}
