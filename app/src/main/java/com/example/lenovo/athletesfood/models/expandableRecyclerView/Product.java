package com.example.lenovo.athletesfood.models.expandableRecyclerView;

public class Product {
    private String mProductName;
    private float mProductProteins;
    private float mProductFats;
    private float mProductCarbohydrates;
    private float mProductCalories;

    public Product(String mProductName, float mProductProteins, float mProductFats,
                   float mProductCarbohydrates, float mProductCalories) {
        this.mProductName = mProductName;
        this.mProductProteins = mProductProteins;
        this.mProductFats = mProductFats;
        this.mProductCarbohydrates = mProductCarbohydrates;
        this.mProductCalories = mProductCalories;
    }

    public String getmProductName() {
        return mProductName;
    }

    public float getmProductProteins() {
        return mProductProteins;
    }

    public float getmProductFats() {
        return mProductFats;
    }

    public float getmProductCarbohydrates() {
        return mProductCarbohydrates;
    }

    public float getmProductCalories() {
        return mProductCalories;
    }
}
