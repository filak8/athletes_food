package com.example.lenovo.athletesfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.lenovo.athletesfood.models.constant.Constants;

public class EnterUserWeightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_user_weight);

        Button mBtnNextActivity = (Button) findViewById(R.id.next_activity);
        final NumberPicker mNpWeightInteger = (NumberPicker)
                findViewById(R.id.number_picker_weigth_integer);
        final NumberPicker mNpWeightDecimal = (NumberPicker)
                findViewById(R.id.number_picker_weigth_decimal);

        mNpWeightInteger.setMinValue(30);
        mNpWeightInteger.setMaxValue(180);
        mNpWeightInteger.setValue(90);
        mNpWeightInteger.setWrapSelectorWheel(false);

        mNpWeightDecimal.setMinValue(0);
        mNpWeightDecimal.setMaxValue(9);
        mNpWeightDecimal.setWrapSelectorWheel(false);

        mBtnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataWeight(mNpWeightInteger, mNpWeightDecimal);
                startActivity(new Intent(EnterUserWeightActivity.this,
                        EnterUserAgeActivity.class));
            }
        });
    }

    private void saveDataWeight(NumberPicker mNpWeightInteger, NumberPicker mNpWeightDecimal) {
        SharedPreferences mShpSetWeight = getSharedPreferences
                (Constants.ARGS_KEY_SHARED_PREFERENSES, MODE_PRIVATE);
        SharedPreferences.Editor editor = mShpSetWeight.edit();
        editor.putFloat(Constants.ARGS_KEY_SHARED_PREFERENSES_EDITOR_WEIGHT,
                (float) mNpWeightInteger.getValue() + ((float)(mNpWeightDecimal.getValue())/10));
        Log.d("AAA", "SharedPrefernses Weight: " +   ((float) mNpWeightInteger.getValue() + ((float)(mNpWeightDecimal.getValue())/10)));
        editor.apply();
    }
}
