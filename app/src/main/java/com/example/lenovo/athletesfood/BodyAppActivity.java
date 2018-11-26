package com.example.lenovo.athletesfood;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.lenovo.athletesfood.fragments.NewFoodFragment;
import com.example.lenovo.athletesfood.fragments.NewMealFragment;
import com.example.lenovo.athletesfood.fragments.NewMenuFragment;
import com.example.lenovo.athletesfood.fragments.ProductCategoriesFragment;
import com.example.lenovo.athletesfood.fragments.FoodDatabaseFragment;
import com.example.lenovo.athletesfood.fragments.HistoryFragment;
import com.example.lenovo.athletesfood.fragments.ListMenuFragment;
import com.example.lenovo.athletesfood.fragments.ProductFragment;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;

import java.util.ArrayList;

public class BodyAppActivity extends AppCompatActivity implements
        ListMenuFragment.OnCreatedMenuListener,
        ProductCategoriesFragment.OnSelectedProductCategoriesListener,
        ProductFragment.OnSelectedProductListener,
        NewMealFragment.OnAddedNewProductListener,
        FoodDatabaseFragment.OnAddNewFoodClickListener,
        NewFoodFragment.OnSaveProductInDatabaseClickListener {

    private BottomNavigationView mBottomNavigationView;
    private ListMenuFragment mListMenuFragment;
    private FoodDatabaseFragment mFoodDatabaseFragment;
    private HistoryFragment mHistoryFragment;
    private ProductCategoriesFragment mProductCategoriesFragment;
    private ProductFragment mProductFragment;
    private NewMealFragment mNewMealFragment;
    private NewFoodFragment mNewFoodFragment;
    private NewMenuFragment mNewMenuFragment;
    private Fragment mActingFragment;

    private int FRAGMENT_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_app);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        FrameLayout mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        mListMenuFragment = new ListMenuFragment();
        mFoodDatabaseFragment = new FoodDatabaseFragment();
        mHistoryFragment = new HistoryFragment();
        mProductCategoriesFragment = new ProductCategoriesFragment();
        mProductFragment = new ProductFragment();
        mNewMealFragment = new NewMealFragment();
        mNewFoodFragment = new NewFoodFragment();
        mNewMenuFragment = new NewMenuFragment();

        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.action_menu:
                                FRAGMENT_TAG = Constants.FRAGMENT_TAG_MENU;
                                clearBackStackFragment();
                                showFragmentByTag(FRAGMENT_TAG);
                                return true;
                            case R.id.action_data:
                                FRAGMENT_TAG = Constants.FRAGMENT_TAG_FOOD_DATABASE;
                                clearBackStackFragment();
                                showFragmentByTag(FRAGMENT_TAG);
                                return true;
                            case R.id.action_history:
                                FRAGMENT_TAG = Constants.FRAGMENT_TAG_HISTORY;
                                clearBackStackFragment();
                                showFragmentByTag(FRAGMENT_TAG);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.frame_layout, fragment);
        if ((mActingFragment == mProductCategoriesFragment) || (mActingFragment == mProductFragment)
                || (mActingFragment == mNewMealFragment) || (mActingFragment == mNewFoodFragment)) {
            mFragmentTransaction.addToBackStack(null);
        }


        mFragmentTransaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Constants.ARGS_KEY_FRAGMENT_TAG, FRAGMENT_TAG);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FRAGMENT_TAG = savedInstanceState.getInt(Constants.ARGS_KEY_FRAGMENT_TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showFragmentByTag(FRAGMENT_TAG);
    }

    private void showFragmentByTag(int FRAGMENT_TAG) {
        switch (FRAGMENT_TAG) {
            case Constants.FRAGMENT_TAG_MENU:
                mActingFragment = mListMenuFragment;
                break;
            case Constants.FRAGMENT_TAG_FOOD_DATABASE:
                mActingFragment = mFoodDatabaseFragment;
                break;
            case Constants.FRAGMENT_TAG_HISTORY:
                mActingFragment = mHistoryFragment;
                break;
            default:
                break;
        }

        if (mActingFragment == null) {
            mActingFragment = mListMenuFragment;
            setFragment(mListMenuFragment);
        } else setFragment(mActingFragment);
    }

    @Override
    public void onMenuCreated() {
        mActingFragment = mNewMenuFragment;
        setFragment(mNewMenuFragment);
    }

    private void clearBackStackFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > Constants.NUMBER_NULL) {
            for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++)
                getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void onProductCategoriesSelected(String productCategories) {
        mActingFragment = mProductFragment;
        setFragment(mProductFragment);

        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS_KEY_BUNDLE_SELECTED_PRODUCT_CATEGORIES, productCategories);
        mProductFragment.setArguments(bundle);
    }

    @Override
    public void onProductSelected(Food food) {
        mActingFragment = mNewMealFragment;

        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS_KEY_FOOD_NAME, food.getFoodName());
        mNewMealFragment.setArguments(bundle);

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
            getSupportFragmentManager().popBackStack();
        }
    }

    @Override
    public void onNewProductAdded() {
        mActingFragment = mProductCategoriesFragment;
        setFragment(mProductCategoriesFragment);
    }

    @Override
    public void onAddNewFoodClick(ArrayList<String> mAlFoodType) {
        mActingFragment = mNewFoodFragment;
        setFragment(mNewFoodFragment);

        Bundle bundle = new Bundle();
        bundle.putStringArrayList(Constants.ARGS_KEY_BUNDLE_ARRAY_LIST_ALL_FOOD_TYPE, mAlFoodType);
        mNewFoodFragment.setArguments(bundle);
    }

    @Override
    public void onSaveProductInDatabase() {
        mActingFragment = mFoodDatabaseFragment;
        clearBackStackFragment();
        setFragment(mActingFragment);
    }
}
