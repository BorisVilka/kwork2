package com.example.testapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapplication.databinding.FragmentLessonBinding;


public class LessonFragment extends Fragment {


    private String mParam2;
    private FragmentLessonBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam2 = getArguments().getString("text");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLessonBinding.inflate(inflater,container,false);
        binding.text.setText(mParam2);
        return binding.getRoot();
    }
}