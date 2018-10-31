package com.example.lenovo.athletesfood;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.food.FoodDatabaseHelper;

public class SplashScreenActivity extends AppCompatActivity {

    private TextView mTvAppName;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mTvAppName = (TextView) findViewById(R.id.text_view_splash_screen);

        Typeface mTypeface = Typeface.createFromAsset(getAssets(),
                Constants.ARGS_KEY_ASSET_PATH);
        mTvAppName.setTypeface(mTypeface);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences
                        (Constants.ARGS_KEY_SHARED_PREFERENSES, MODE_PRIVATE);
                if (sharedPreferences.getInt(Constants.ARGS_KEY_SHARED_PREFERENSES_EDITOR_GROWTH,
                        Constants.NUMBER_NULL) == Constants.NUMBER_NULL) {
                    startActivity(new Intent(SplashScreenActivity.this,
                            StartGreetingActivity.class));

                    new FoodDatabaseHelper();
                } else
                    startActivity(new Intent(SplashScreenActivity.this,
                            BodyAppActivity.class));
            }

        }, Constants.HANDLER_DELAY_MILLIS);

        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progress_bar_splash_screen);

        ObjectAnimator mObjectAnimator = ObjectAnimator.ofInt(mProgressBar,
                Constants.ARGS_KEY_OBJECT_ANIMATOR_PROGRESS, Constants.NUMBER_NULL,
                Constants.OBJECT_ANIMATOR_DURATION);
        mObjectAnimator.setDuration(Constants.OBJECT_ANIMATOR_DURATION);
        mObjectAnimator.start();
    }
}
