package com.example.lenovo.athletesfood.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.athletesfood.R;

public class ListMenuFragment extends Fragment implements View.OnClickListener {
    Button mBtnCreateNewMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        mBtnCreateNewMenu = (Button) view.findViewById(R.id.button_create_new_menu);
        mBtnCreateNewMenu.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        OnCreatedMenuListener onCreatedMenuListener = (OnCreatedMenuListener) getActivity();
        if (onCreatedMenuListener != null) {
            onCreatedMenuListener.onMenuCreated();
        }
    }

    public interface OnCreatedMenuListener {
        void onMenuCreated();
    }
}
