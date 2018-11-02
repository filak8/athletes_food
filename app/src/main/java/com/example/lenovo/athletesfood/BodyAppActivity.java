package com.example.lenovo.athletesfood;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.lenovo.athletesfood.fragments.NewMenuFragment;
import com.example.lenovo.athletesfood.fragments.ProductCategoriesFragment;
import com.example.lenovo.athletesfood.fragments.FoodDataBaseFragment;
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
        NewMenuFragment.OnAddedNewProductListener {

    private BottomNavigationView mBottomNavigationView;
    private FrameLayout mFrameLayout;
    private ListMenuFragment mListMenuFragment;
    private FoodDataBaseFragment mFoodDataBaseFragment;
    private HistoryFragment mHistoryFragment;
    private ProductCategoriesFragment mProductCategoriesFragment;
    private ProductFragment mProductFragment;
    private NewMenuFragment mNewMenuFragment;
    private Fragment mActingFragment;
    private ArrayList<Food> foods;

    private int FRAGMENT_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_app);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        mListMenuFragment = new ListMenuFragment();
        mFoodDataBaseFragment = new FoodDataBaseFragment();
        mHistoryFragment = new HistoryFragment();
        mProductCategoriesFragment = new ProductCategoriesFragment();
        mProductFragment = new ProductFragment();
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
        if ((mActingFragment == mProductCategoriesFragment)||(mActingFragment == mProductFragment)
                ||(mActingFragment == mNewMenuFragment)) {
            mFragmentTransaction.addToBackStack(null);
        }
        mFragmentTransaction.replace(R.id.frame_layout, fragment);

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
                mActingFragment = mFoodDataBaseFragment;
                Log.d("AAA", "mActingFragment = mFoodDataBaseFragment;");
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
        if (getSupportFragmentManager().getBackStackEntryCount() > 0){
            for (int i = 0; i < getSupportFragmentManager().getBackStackEntryCount(); i++)
            getSupportFragmentManager().popBackStack();
            Log.d("AAA", "Backstack is null");
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
        //Use for added selected product in new menu.
    }

    @Override
    public void onNewProductAdded() {
        mActingFragment = mProductCategoriesFragment;
        setFragment(mProductCategoriesFragment);
    }
}
