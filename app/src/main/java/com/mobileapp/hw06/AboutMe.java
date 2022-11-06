package com.mobileapp.hw06;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobileapp.hw06.databinding.FragmentAboutMeBinding;

public class AboutMe extends Fragment {
    private FragmentAboutMeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAboutMeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        return view;
    }
}