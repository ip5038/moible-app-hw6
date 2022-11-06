package com.mobileapp.hw06;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mobileapp.hw06.databinding.FragmentColorSettingBinding;

public class ColorSetting extends Fragment {
    private FragmentColorSettingBinding binding;
    private RadioButton radioButton;
    private String color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentColorSettingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
//        String message = ColorSettingArgs.fromBundle(requireArguments()).getColor();
//        color = new StringBuilder(message).toString();

//        if(color.equals("Purple"))
//        {
//            binding.purpleRadioButton.setChecked(true);
//        } else if(color.equals("Yellow"))
//        {
//            binding.yellowRadioButton.setChecked(true);
//        } else
//        {
//            binding.redRadioButton.setChecked(true);
//        }

        binding.colorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton btn = view.findViewById(i);
                color = btn.getText().toString();
            }
        });

        binding.changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = ColorSettingDirections.actionColorSettingToGameBoardFragment(color);
                Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }
}