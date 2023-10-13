package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class OptionDialogFragment extends DialogFragment {
    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbSaf, rbMou, rbLvg, rbMoyes;
    private OnOptionDialogListener optionDialogListener;
    public OptionDialogFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChoose = view.findViewById(R.id.btn_choose);
        btnClose = view.findViewById(R.id.btn_close);
        rgOptions = view.findViewById(R.id.rg_options);
        rbSaf = view.findViewById(R.id.rb_saf);
        rbLvg = view.findViewById(R.id.rb_lvg);
        rbMou = view.findViewById(R.id.rb_mou);
        rbMoyes = view.findViewById(R.id.rb_moyes);
        btnChoose.setOnClickListener(view1 -> {
            int checkRadioButtonId = rgOptions.getCheckedRadioButtonId();
            if (checkRadioButtonId != -1) {
                String coach = null;
                if (checkRadioButtonId == R.id.rb_saf) {
                    coach = rbSaf.getText().toString().trim();
                } else if (checkRadioButtonId == R.id.rb_mou) {
                    coach = rbMou.getText().toString().trim();
                } else if (checkRadioButtonId == R.id.rb_lvg) {
                    coach = rbLvg.getText().toString().trim();
                } else if (checkRadioButtonId == R.id.rb_moyes) {
                    coach = rbMoyes.getText().toString().trim();
                }
                if (optionDialogListener != null) {
                    optionDialogListener.onOptionChosen(coach);
                }
                getDialog().dismiss();
            }
        });
        btnClose.setOnClickListener(view1 -> getDialog().cancel());
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();

        if (fragment instanceof DetailCategoryFragment) {
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }
    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }
}
