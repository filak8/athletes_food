package com.example.lenovo.athletesfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.example.lenovo.athletesfood.constant.Constants;

public class EnterUserAgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_user_age);

        final NumberPicker mNpAge = (NumberPicker) findViewById(R.id.number_picker_age);
        Button mBtnNextActivity = (Button) findViewById(R.id.next_activity);

        mNpAge.setMinValue(10);
        mNpAge.setMaxValue(80);
        mNpAge.setValue(30);
        mNpAge.setWrapSelectorWheel(false);

        mBtnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataAge(mNpAge);
                startActivity(new Intent(EnterUserAgeActivity.this, UserPickCoeffOfMobilityActivity.class));
            }
        });
    }

    private void saveDataAge(NumberPicker mNpAge) {
        SharedPreferences mShpSetGrowth = getSharedPreferences
                (Constants.ARGS_KEY_SHARED_PREFERENSES, MODE_PRIVATE);
        SharedPreferences.Editor editor = mShpSetGrowth.edit();
        editor.putInt(Constants.ARGS_KEY_SHARED_PREFERENSES_EDITOR_AGE, mNpAge.getValue());
        Log.d("AAA", "SharedPreferenses Age: " + mNpAge.getValue());
        editor.apply();
    }
}
