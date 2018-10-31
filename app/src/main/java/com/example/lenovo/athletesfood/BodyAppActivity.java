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
import android.widget.Toast;

import com.example.lenovo.athletesfood.fragments.ProductCategoriesFragment;
import com.example.lenovo.athletesfood.fragments.FoodDataBaseFragment;
import com.example.lenovo.athletesfood.fragments.HistoryFragment;
import com.example.lenovo.athletesfood.fragments.MenuFragment;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;

import java.util.ArrayList;

public class BodyAppActivity extends AppCompatActivity
        implements MenuFragment.OnCreatedMenuListener {

    private BottomNavigationView mBottomNavigationView;
    private FrameLayout mFrameLayout;
    private MenuFragment mMenuFragment;
    private FoodDataBaseFragment mFoodDataBaseFragment;
    private HistoryFragment mHistoryFragment;
    private ProductCategoriesFragment mProductCategoriesFragment;
    private Fragment mActingFragment;
    private ArrayList<Food> foods;

    private int FRAGMENT_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_app);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        mMenuFragment = new MenuFragment();
        mFoodDataBaseFragment = new FoodDataBaseFragment();
        mHistoryFragment = new HistoryFragment();
        mProductCategoriesFragment = new ProductCategoriesFragment();


        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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

      /*  creatingAListOfProducts();*/
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (mActingFragment == mProductCategoriesFragment) {
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
                mActingFragment = mMenuFragment;
                break;
            case Constants.FRAGMENT_TAG_FOOD_DATABASE:
                mActingFragment = mFoodDataBaseFragment;
                break;
            case Constants.FRAGMENT_TAG_HISTORY:
                mActingFragment = mHistoryFragment;
                break;
            default:
                break;
        }

        if (mActingFragment == null) {
            mActingFragment = mMenuFragment;
            setFragment(mMenuFragment);
        } else setFragment(mActingFragment);
    }

    @Override
    public void onMenuCreated() {
        mActingFragment = mProductCategoriesFragment;
        setFragment(mProductCategoriesFragment);
        Log.d("AAA", "Activity BodyAppActivity; method onMenuCreated worked.");
    }

    private void clearBackStackFragment(){
        if(getSupportFragmentManager().getBackStackEntryCount() > 0)
            getSupportFragmentManager().popBackStack();
    }
}
