package com.example.testapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapplication.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false);
        binding.name.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        binding.button.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            getActivity().finish();
        });
        return binding.getRoot();
    }
}