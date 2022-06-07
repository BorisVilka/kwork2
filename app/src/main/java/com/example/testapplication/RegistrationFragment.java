package com.example.testapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapplication.databinding.FragmentLoginBinding;
import com.example.testapplication.databinding.FragmentRegistrationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


public class RegistrationFragment extends Fragment {

   private FragmentRegistrationBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater,container,false);
        binding.regButton.setOnClickListener(view -> {
            if(binding.emailReg.getText().length()>0 &&
            binding.nameReg.getText().length()>0 && binding.passReg.getText().length()>0) {
                binding.regButton.setEnabled(false);
                FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(binding.emailReg.getText().toString(),
                                binding.passReg.getText().toString())
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()) {
                                FirebaseUser user = task.getResult().getUser();
                                UserProfileChangeRequest request = new UserProfileChangeRequest
                                        .Builder()
                                        .setDisplayName(binding.nameReg.getText().toString()).build();
                                user.updateProfile(request).addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()) {
                                        FirebaseAuth.getInstance().updateCurrentUser(user)
                                        .addOnCompleteListener(task2 -> {
                                            getActivity().startActivity(new Intent(getActivity(),MainActivity.class));
                                            getActivity().finish();
                                        });
                                    } else binding.regButton.setEnabled(true);
                                 });
                            } else binding.regButton.setEnabled(true);
                        });
            }
        });
        return binding.getRoot();
    }
}