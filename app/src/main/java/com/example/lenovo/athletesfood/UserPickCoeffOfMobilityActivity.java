package com.example.lenovo.athletesfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.DataBase;
import com.example.lenovo.athletesfood.models.dataBase.User.User;

import java.util.Random;

public class UserPickCoeffOfMobilityActivity extends AppCompatActivity {

    private float mCoeffOfMobility;
    private DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pick_coeff_of_mobility);

        Button mBtnNextActivity = (Button) findViewById(R.id.next_activity);

        RadioButton mRbLowActivity = (RadioButton) findViewById(R.id.radio_button_low_activity);
        mRbLowActivity.setChecked(true);
        mCoeffOfMobility = Constants.COEFF_OF_MOBILITY_LOW;

        RadioGroup mRgActivity = (RadioGroup) findViewById(R.id.radio_group_activity);
        mRgActivity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_button_low_activity:
                        mCoeffOfMobility = Constants.COEFF_OF_MOBILITY_LOW;
                        Log.d("AAA", "CoeffOfMobility: " + mCoeffOfMobility);
                        break;
                    case R.id.radio_button_small_activity:
                        mCoeffOfMobility = Constants.COEFF_OF_MOBILITY_SMALL;
                        Log.d("AAA", "CoeffOfMobility: " + mCoeffOfMobility);
                        break;
                    case R.id.radio_button_middle_activity:
                        mCoeffOfMobility = Constants.COEFF_OF_MOBILITY_MIDDLE;
                        Log.d("AAA", "CoeffOfMobility: " + mCoeffOfMobility);
                        break;
                    case R.id.radio_button_high_activity:
                        mCoeffOfMobility = Constants.COEFF_OF_MOBILITY_HIGH;
                        Log.d("AAA", "CoeffOfMobility: " + mCoeffOfMobility);
                        break;
                    default:
                        break;
                }
            }
        });

        mBtnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mSpParams = getSharedPreferences(Constants.ARGS_KEY_SHARED_PREFERENSES, MODE_PRIVATE);
                User mUser = new User();
                mUser.setId(new Random().nextInt());
                mUser.setGrowth(mSpParams.getInt(Constants.ARGS_KEY_SHARED_PREFERENSES_EDITOR_GROWTH, 0));
                mUser.setWeight(mSpParams.getFloat(Constants.ARGS_KEY_SHARED_PREFERENSES_EDITOR_WEIGHT, 0));
                mUser.setAge(mSpParams.getInt(Constants.ARGS_KEY_SHARED_PREFERENSES_EDITOR_AGE, 0));
                mUser.setCoeffOfMobility(mCoeffOfMobility);

                new UserAsyncTask(Constants.TASK_INSERT).execute(mUser);

                startActivity(new Intent(UserPickCoeffOfMobilityActivity.this, BodyAppActivity.class));
            }
        });
    }
}
