package com.example.lenovo.athletesfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartGreetingActivity extends AppCompatActivity {

    private int mGrowth = 168;
    private double mWeight = 92.7;
    private int mAge = 24;
    private double mPhysicalActivity = 1.2;
    private int mStartingPool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_greeting);

        Button mBtnNextActivity = (Button) findViewById(R.id.next_activity);
        mBtnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartGreetingActivity.this,
                        EnterUserGrowthActivity.class));
            }
        });

        mStartingPool = (int)((655 + (mGrowth * 1.8) + (mWeight * 9.6) - (mAge * 4.7)) * mPhysicalActivity);
        Log.d("AAA", "StartingPool: " + mStartingPool);
    }
}
