package com.example.lenovo.athletesfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.lenovo.athletesfood.models.constant.Constants;

public class EnterUserGrowthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_user_growth);

        final NumberPicker mNpGrowth = (NumberPicker) findViewById(R.id.number_picker_growth);
        mNpGrowth.setMaxValue(Constants.NUMBER_PICKER_GROWTH_MAX_VALUE);
        mNpGrowth.setMinValue(Constants.NUMBER_PICKER_GROWTH_MIN_VALUE);
        mNpGrowth.setValue(Constants.NUMBER_PICKER_GROWTH_VALUE);
        mNpGrowth.setWrapSelectorWheel(false);

        Button mBtnNextActivity = (Button) findViewById(R.id.next_activity);
        mBtnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataGrowth(mNpGrowth);
                startActivity(new Intent(EnterUserGrowthActivity.this,
                        EnterUserWeightActivity.class));
            }
        });
    }

    private void saveDataGrowth(NumberPicker mNpGrowth) {
        SharedPreferences mShpSetGrowth = getSharedPreferences
                (Constants.ARGS_KEY_SHARED_PREFERENSES, MODE_PRIVATE);
        SharedPreferences.Editor editor = mShpSetGrowth.edit();
        editor.putInt(Constants.ARGS_KEY_SHARED_PREFERENSES_EDITOR_GROWTH, mNpGrowth.getValue());
        editor.apply();
    }
}
