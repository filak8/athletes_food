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

import com.example.lenovo.athletesfood.fragments.CreateANewMenuFragment;
import com.example.lenovo.athletesfood.fragments.FoodDataBaseFragment;
import com.example.lenovo.athletesfood.fragments.HistoryFragment;
import com.example.lenovo.athletesfood.fragments.MenuFragment;
import com.example.lenovo.athletesfood.models.constant.Constants;

public class BodyAppActivity extends AppCompatActivity implements MenuFragment.OnCreatedMenuListener {

    private BottomNavigationView mBottomNavigationView;
    private FrameLayout mFrameLayout;
    private MenuFragment mFragmentMenu;
    private FoodDataBaseFragment mFragmentFoodDataBase;
    private HistoryFragment mFragmentHistory;
    private CreateANewMenuFragment mNewMenuFragment;
    private Fragment mActingFtagment;

    private int FRAGMENT_TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_app);

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        mFragmentMenu = new MenuFragment();
        mFragmentFoodDataBase = new FoodDataBaseFragment();
        mFragmentHistory = new HistoryFragment();
        mNewMenuFragment = new CreateANewMenuFragment();

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_menu:
                        setFragment(mFragmentMenu);
                        FRAGMENT_TAG = Constants.FRAGMENT_TAG_MENU;
                        return true;
                    case R.id.action_data:
                        setFragment(mFragmentFoodDataBase);
                        FRAGMENT_TAG = Constants.FRAGMENT_TAG_FOOD_DATABASE;
                        return true;
                    case R.id.action_history:
                        setFragment(mFragmentHistory);
                        FRAGMENT_TAG = Constants.FRAGMENT_TAG_HISTORY;
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
                mActingFtagment = mFragmentMenu;
                break;
            case Constants.FRAGMENT_TAG_FOOD_DATABASE:
                mActingFtagment = mFragmentFoodDataBase;
                break;
            case Constants.FRAGMENT_TAG_HISTORY:
                mActingFtagment = mFragmentHistory;
                break;
            default:
                break;
        }

        if (mActingFtagment == null) {
            setFragment(mFragmentMenu);
            mActingFtagment = mFragmentMenu;
        } else setFragment(mActingFtagment);
    }

    @Override
    public void onMenuCreated() {
        setFragment(mNewMenuFragment);
        Log.d("AAA", "Activity BodyAppActivity; method onMenuCreated worked.");
    }
}
