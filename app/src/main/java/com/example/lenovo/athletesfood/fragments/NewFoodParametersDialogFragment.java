package com.example.lenovo.athletesfood.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.lenovo.athletesfood.R;
import com.example.lenovo.athletesfood.models.constant.Constants;

import java.util.ArrayList;

public class NewFoodParametersDialogFragment extends DialogFragment implements View.OnClickListener {
    private NumberPicker mNpValue;
    private NumberPicker mNpAdditionalValue;
    private TextView mTvMessage;
    private TextView mTvTitle;
    private TextView mTvPoint;
    private String mActualTag;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment, null);
        view.findViewById(R.id.button_ok).setOnClickListener(this);
        view.findViewById(R.id.button_cancel).setOnClickListener(this);
        mNpValue = (NumberPicker) view.findViewById(R.id.number_picker_main);
        mNpAdditionalValue = (NumberPicker) view.findViewById(R.id.number_picker_additional);
        mTvMessage = (TextView) view.findViewById(R.id.text_view_message);
        mTvTitle = (TextView) view.findViewById(R.id.text_view_title);
        mTvPoint = (TextView) view.findViewById(R.id.text_view_point);

        if (getArguments() != null) {
            mTvTitle.setText(getArguments().getString(Constants.ARGS_KEY_DIALOG_TITLE));
            mTvMessage.setText(getArguments().getString(Constants.ARGS_KEY_DIALOG_MESSAGE));
            mNpValue.setMinValue(getArguments().getInt(
                    Constants.ARGS_KEY_DIALOG_NUMBER_PICKER_MIN_VALUE));
            mNpValue.setMaxValue(getArguments().getInt(
                    Constants.ARGS_KEY_DIALOG_NUMBER_PICKER_MAX_VALUE));
            if (getArguments().getStringArrayList(Constants.ARGS_KEY_DIALOG_ALL_FOOD_TYPES) != null) {
                ArrayList<String> mAlFoodTypes = getArguments()
                        .getStringArrayList(Constants.ARGS_KEY_DIALOG_ALL_FOOD_TYPES);
                mNpValue.setDisplayedValues(mAlFoodTypes.toArray(new String[mAlFoodTypes.size()]));
            }
            mActualTag = getArguments().getString(Constants.ARGS_KEY_DIALOG_ACTUAL_TAG);

            if (getArguments().getInt(
                    Constants.ARGS_KEY_DIALOG_ADDITIONAL_NUMBER_PICKER) == Constants.NUMBER_NULL) {
                mNpAdditionalValue.setVisibility(View.GONE);
                mTvPoint.setVisibility(View.GONE);
            } else {
                mNpAdditionalValue.setMinValue(Constants.NUMBER_PICKER_WEIGHT_DECIMAL_MIN_VALUE);
                mNpAdditionalValue.setMaxValue(Constants.NUMBER_PICKER_WEIGHT_DECIMAL_MAX_VALUE);
            }
        }
        mNpValue.setWrapSelectorWheel(false);
        mNpAdditionalValue.setWrapSelectorWheel(false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ok:
                switch (mActualTag) {
                    case Constants.ARGS_DIALOG_TAG_CALORIES_SELECTED:
                        sendInfoInTargetFragment(Constants.ARGS_DIALOG_TAG_CALORIES_SELECTED,
                                mNpValue.getValue(), Constants.DIALOG_NOT_FLOAT_VALUE);
                        break;
                    case Constants.ARGS_DIALOG_TAG_TYPE_SELECTED:
                        sendInfoInTargetFragment(Constants.ARGS_DIALOG_TAG_TYPE_SELECTED,
                                mNpValue.getValue() - Constants.NUMBER_ONE,
                                Constants.DIALOG_NOT_FLOAT_VALUE);
                        break;
                    case Constants.ARGS_DIALOG_TAG_PROTEINS_SELECTED:
                        sendInfoInTargetFragment(Constants.ARGS_DIALOG_TAG_PROTEINS_SELECTED,
                                Constants.DIALOG_NOT_INT_VALUE, getResultFromExtendedNumberPicker(
                                        mNpValue.getValue(), mNpAdditionalValue.getValue()));
                        break;
                    case Constants.ARGS_DIALOG_TAG_FATS_SELECTED:
                        sendInfoInTargetFragment(Constants.ARGS_DIALOG_TAG_FATS_SELECTED,
                                Constants.DIALOG_NOT_INT_VALUE, getResultFromExtendedNumberPicker(
                                        mNpValue.getValue(), mNpAdditionalValue.getValue()));
                        break;
                    case Constants.ARGS_DIALOG_TAG_CARBOHYDRATES_SELECTED:
                        sendInfoInTargetFragment(Constants.ARGS_DIALOG_TAG_CARBOHYDRATES_SELECTED,
                                Constants.DIALOG_NOT_INT_VALUE, getResultFromExtendedNumberPicker(
                                        mNpValue.getValue(), mNpAdditionalValue.getValue()));
                        break;
                    default:
                        break;
                }
                break;
            case R.id.button_cancel:
                dismiss();
                break;
            default:
                break;
        }
    }

    private void sendInfoInTargetFragment(String mDialogKey, int mIntValue, float mFloatValue) {
        Intent intent = new Intent();
        if (mIntValue == Constants.DIALOG_NOT_INT_VALUE) {
            intent.putExtra(mDialogKey, mFloatValue);
        } else {
            intent.putExtra(mDialogKey, mIntValue);
        }

        if (getTargetFragment() != null)
            getTargetFragment().onActivityResult(getTargetRequestCode(),
                    Activity.RESULT_OK, intent);
        dismiss();
    }

    private float getResultFromExtendedNumberPicker(int mNpValue, int mNpAdditionalValue) {
        return (mNpValue + ((float) mNpAdditionalValue) / Constants.NUMBER_TEN);
    }
}
