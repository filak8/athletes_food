package com.example.lenovo.athletesfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lenovo.athletesfood.constant.Constants;

public class UserPickCoeffOfMobilityActivity extends AppCompatActivity {

    private double mCoeffOfMobility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pick_coeff_of_mobility);

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
    }
}
