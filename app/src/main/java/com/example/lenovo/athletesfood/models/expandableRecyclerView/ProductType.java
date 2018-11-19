package com.example.lenovo.athletesfood.models.expandableRecyclerView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ProductType extends ExpandableGroup {
    public ProductType(String title, List items) {
        super(title, items);
    }
}
