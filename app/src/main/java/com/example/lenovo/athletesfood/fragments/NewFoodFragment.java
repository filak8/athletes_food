package com.example.lenovo.athletesfood.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.athletesfood.FoodAsyncTask;
import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.models.constant.Constants;
import com.example.lenovo.athletesfood.models.dataBase.food.Food;

import java.util.ArrayList;

public class NewFoodFragment extends Fragment implements View.OnClickListener {
    private DialogFragment dialogFragment;
    private Button mBtnAddCalories;
    private Button mBtnSelectType;
    private Button mBtnAddProteins;
    private Button mBtnAddFats;
    private Button mBtnAddCarbohydrates;
    private Button mBtnSaveProduct;
    private TextView mTvCalories;
    private TextView mTvProductType;
    private TextView mTvProteins;
    private TextView mTvFats;
    private TextView mTvCarbohydrates;
    private EditText mEtProductName;
    private String mProductType;
    private float mProductProteins;
    private float mProductFats;
    private float mProductCarbohydrates;
    private int mProductCalories;

    private ArrayList<String> mAlFoodTypes;
    private boolean mProductNameIsNotEmpty;
    private boolean mProductTypeIsNotEmpty;
    private boolean mProductProteinsIsNotEmpty;
    private boolean mProductFatsIsNotEmpty;
    private boolean mProductCarbohydratesIsNotEmpty;
    private boolean mProductCaloriesIsNotEmpty;
    private boolean mAllFieldsAreFilled;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_food, container, false);
        if (getArguments() != null)
            mAlFoodTypes = getArguments().getStringArrayList
                    (Constants.ARGS_KEY_BUNDLE_ARRAY_LIST_ALL_FOOD_TYPE);

        dialogFragment = new NewFoodParametersDialogFragment();

        mBtnAddCalories = (Button) view.findViewById(R.id.button_add_calories);
        mBtnAddCalories.setOnClickListener(this);
        mBtnSelectType = (Button) view.findViewById(R.id.button_select_food_type);
        mBtnSelectType.setOnClickListener(this);
        mBtnAddProteins = (Button) view.findViewById(R.id.button_add_edit_product_proteins);
        mBtnAddProteins.setOnClickListener(this);
        mBtnAddFats = (Button) view.findViewById(R.id.button_add_edit_product_fats);
        mBtnAddFats.setOnClickListener(this);
        mBtnAddCarbohydrates = (Button) view.findViewById(R.id.button_add_edit_product_carbohydrates);
        mBtnAddCarbohydrates.setOnClickListener(this);
        mBtnSaveProduct = (Button) view.findViewById(R.id.button_save_product);
        mBtnSaveProduct.setOnClickListener(this);

        mTvCalories = (TextView) view.findViewById(R.id.text_view_product_calories_value);
        mTvProductType = (TextView) view.findViewById(R.id.text_view_product_type_value);
        mTvProteins = (TextView) view.findViewById(R.id.text_view_product_proteins_value);
        mTvFats = (TextView) view.findViewById(R.id.text_view_product_fats_value);
        mTvCarbohydrates = (TextView) view.findViewById(R.id.text_view_product_carbohydrates_value);
        mEtProductName = (EditText) view.findViewById(R.id.edit_text_product_name);

        mProductNameIsNotEmpty = false;
        mProductTypeIsNotEmpty = false;
        mProductProteinsIsNotEmpty = false;
        mProductFatsIsNotEmpty = false;
        mProductCarbohydratesIsNotEmpty = false;
        mProductCaloriesIsNotEmpty = false;
        mAllFieldsAreFilled = false;
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.DIALOG_REQUEST_CALORIES:
                mProductCalories = data.getIntExtra(Constants.ARGS_DIALOG_TAG_CALORIES_SELECTED,
                        Activity.RESULT_OK);
                mTvCalories.setText(String.valueOf(mProductCalories)
                        + getActivity().getResources().getString(R.string.calories_abbreviation));
                break;
            case Constants.DIALOG_REQUEST_TYPE:
                int mFoodTypePosition = data.getIntExtra(Constants.ARGS_DIALOG_TAG_TYPE_SELECTED,
                        Activity.RESULT_OK);
                mProductType = mAlFoodTypes.get(mFoodTypePosition);
                mTvProductType.setText(mProductType);
                break;
            case Constants.DIALOG_REQUEST_PROTEINS:
                mProductProteins = data.getFloatExtra(Constants.ARGS_DIALOG_TAG_PROTEINS_SELECTED,
                        Activity.RESULT_OK);
                mTvProteins.setText(String.valueOf(mProductProteins)
                        + getActivity().getResources().getString(R.string.gramm_abbreviation));
                break;
            case Constants.DIALOG_REQUEST_FATS:
                mProductFats = data.getFloatExtra(Constants.ARGS_DIALOG_TAG_FATS_SELECTED,
                        Activity.RESULT_OK);
                mTvFats.setText(String.valueOf(mProductFats)
                        + getActivity().getResources().getString(R.string.gramm_abbreviation));
                break;
            case Constants.DIALOG_REQUEST_CARBOHYDRATES:
                mProductCarbohydrates = data.getFloatExtra(
                        Constants.ARGS_DIALOG_TAG_CARBOHYDRATES_SELECTED, Activity.RESULT_OK);
                mTvCarbohydrates.setText(String.valueOf(mProductCarbohydrates)
                        + getActivity().getResources().getString(R.string.gramm_abbreviation));
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_select_food_type:
                setArgumentsAndShowDialog(Constants.DIALOG_REQUEST_TYPE,
                        getActivity().getResources().getString(R.string.dialog_product_type),
                        getActivity().getResources().getString(R.string.dialog_select_product),
                        Constants.DIALOG_SELECT_TYPE_MIN_VALUE, mAlFoodTypes.size(), mAlFoodTypes,
                        Constants.ARGS_DIALOG_TAG_TYPE_SELECTED, Constants.NUMBER_NULL);
                break;
            case R.id.button_add_edit_product_proteins:
                setArgumentsAndShowDialog(Constants.DIALOG_REQUEST_PROTEINS,
                        getActivity().getResources().getString(R.string.dialog_product_proteins),
                        getActivity().getResources().getString(R.string.dialog_select_proteins),
                        Constants.NUMBER_NULL, Constants.DIALOG_NUMBER_PICKER_MAX_VALUE_PROTEINS,
                        null, Constants.ARGS_DIALOG_TAG_PROTEINS_SELECTED,
                        Constants.DIALOG_ADD_ADDITIONAL_NUMBER_PICKER);
                break;
            case R.id.button_add_edit_product_fats:
                setArgumentsAndShowDialog(Constants.DIALOG_REQUEST_FATS,
                        getActivity().getResources().getString(R.string.dialog_product_fats),
                        getActivity().getResources().getString(R.string.dialog_select_fats),
                        Constants.NUMBER_NULL, Constants.DIALOG_NUMBER_PICKER_MAX_VALUE_PROTEINS,
                        null, Constants.ARGS_DIALOG_TAG_FATS_SELECTED,
                        Constants.DIALOG_ADD_ADDITIONAL_NUMBER_PICKER);
                break;
            case R.id.button_add_edit_product_carbohydrates:
                setArgumentsAndShowDialog(Constants.DIALOG_REQUEST_CARBOHYDRATES,
                        getActivity().getResources().getString(R.string.dialog_product_carbohydrates),
                        getActivity().getResources().getString(R.string.dialog_select_carbohydrates),
                        Constants.NUMBER_NULL, Constants.DIALOG_NUMBER_PICKER_MAX_VALUE_PROTEINS,
                        null, Constants.ARGS_DIALOG_TAG_CARBOHYDRATES_SELECTED,
                        Constants.DIALOG_ADD_ADDITIONAL_NUMBER_PICKER);
                break;
            case R.id.button_add_calories:
                setArgumentsAndShowDialog(Constants.DIALOG_REQUEST_CALORIES,
                        getActivity().getResources().getString(R.string.dialog_product_calories),
                        getActivity().getResources().getString(R.string.dialog_select_calories),
                        Constants.NUMBER_NULL, Constants.NUMBER_THOUSAND, null,
                        Constants.ARGS_DIALOG_TAG_CALORIES_SELECTED, Constants.NUMBER_NULL);
                break;
            case R.id.button_save_product:
                checkEmptyFields();

                if (mAllFieldsAreFilled) {
                    Food food = new Food();
                    food.setFoodType(mProductType);
                    food.setFoodName(mEtProductName.getText().toString());
                    food.setProteins(mProductProteins);
                    food.setFats(mProductFats);
                    food.setCarbohydrates(mProductCarbohydrates);
                    food.setKcal(mProductCalories);
                    new FoodAsyncTask(Constants.TASK_INSERT).execute(food);

                    OnSaveProductInDatabaseClickListener mClickListener =
                            (OnSaveProductInDatabaseClickListener) getActivity();
                    if (mClickListener != null)
                        mClickListener.onSaveProductInDatabase();

                    Toast.makeText(getActivity(), getActivity().getResources()
                            .getString(R.string.message_product_successfully_added_to_database),
                            Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    private void setArgumentsAndShowDialog(int mRequestCode, String mDialogTitle,
                                           String mDialogMessage, int mNpMinValue, int mNpMaxValue,
                                           ArrayList<String> mAlFoodTypes,
                                           String mActualTag, int mFlagAdditionalNumberPicker) {
        dialogFragment.setTargetFragment(this, mRequestCode);

        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS_KEY_DIALOG_TITLE, mDialogTitle);
        bundle.putString(Constants.ARGS_KEY_DIALOG_MESSAGE, mDialogMessage);
        bundle.putInt(Constants.ARGS_KEY_DIALOG_NUMBER_PICKER_MIN_VALUE, mNpMinValue);
        bundle.putInt(Constants.ARGS_KEY_DIALOG_NUMBER_PICKER_MAX_VALUE, mNpMaxValue);
        bundle.putString(Constants.ARGS_KEY_DIALOG_ACTUAL_TAG, mActualTag);
        bundle.putStringArrayList(Constants.ARGS_KEY_DIALOG_ALL_FOOD_TYPES, mAlFoodTypes);
        bundle.putInt(Constants.ARGS_KEY_DIALOG_ADDITIONAL_NUMBER_PICKER, mFlagAdditionalNumberPicker);

        dialogFragment.setArguments(bundle);

        if (getFragmentManager() != null)
            dialogFragment.show(getFragmentManager(), mActualTag);
    }

    private void checkEmptyFields() {
        if (mEtProductName.getText().length() != Constants.NUMBER_NULL) {
            mProductNameIsNotEmpty = true;
        } else {
            mProductNameIsNotEmpty = false;
        }

        if (mTvProductType.getText().length() != Constants.NUMBER_NULL)
            mProductTypeIsNotEmpty = true;

        if (mTvProteins.getText().length() != Constants.NUMBER_NULL)
            mProductProteinsIsNotEmpty = true;

        if (mTvFats.getText().length() != Constants.NUMBER_NULL)
            mProductFatsIsNotEmpty = true;

        if (mTvCarbohydrates.getText().length() != Constants.NUMBER_NULL)
            mProductCarbohydratesIsNotEmpty = true;

        if (mTvCalories.getText().length() != Constants.NUMBER_NULL)
            mProductCaloriesIsNotEmpty = true;

        if (mProductNameIsNotEmpty && mProductTypeIsNotEmpty && mProductProteinsIsNotEmpty
                && mProductFatsIsNotEmpty && mProductCarbohydratesIsNotEmpty
                && mProductCaloriesIsNotEmpty){
            mAllFieldsAreFilled = true;
        } else {
            Toast.makeText(getActivity(), getActivity().getResources()
                    .getString(R.string.not_all_fields_are_filled), Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnSaveProductInDatabaseClickListener {
        void onSaveProductInDatabase();
    }

}
