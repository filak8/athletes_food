package com.example.lenovo.athletesfood.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.athletesfood.R;

public class CreateANewMenuFragment extends Fragment {

    public CreateANewMenuFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_created_new_menu, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("AAA", "Fragment CreateANewMenuFragment; Fragment in focus.");
    }
}
