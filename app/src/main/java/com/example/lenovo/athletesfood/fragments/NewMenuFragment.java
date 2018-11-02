package com.example.lenovo.athletesfood.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lenovo.athletesfood.R;

public class NewMenuFragment extends Fragment implements View.OnClickListener {
    private Button mBtnAddNewProduct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_menu, container, false);

        mBtnAddNewProduct = view.findViewById(R.id.button_add_new_product);
        mBtnAddNewProduct.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        OnAddedNewProductListener onAddedNewProductListener =
                (OnAddedNewProductListener) getActivity();
        if (onAddedNewProductListener != null) {
            onAddedNewProductListener.onNewProductAdded();
        }
    }

    public interface OnAddedNewProductListener{
        void onNewProductAdded();
    }
}
