package com.example.testapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapplication.databinding.FragmentLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {


    private FragmentLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false);
        binding.goToReg.setOnClickListener(view -> {
            NavController controller = Navigation.findNavController(getActivity(),R.id.fragmentContainerView);
            controller.navigate(R.id.reg_nav);
        });
        binding.logButton.setOnClickListener(view -> {
            if(binding.emailLog.getText().length()>0 && binding.passLog.getText().length()>0) {
                binding.logButton.setEnabled(false);
                FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.emailLog.getText().toString(), binding.passLog.getText().toString())
                        .addOnCompleteListener(task -> {
                            if(task.isSuccessful()) {
                                FirebaseAuth.getInstance().updateCurrentUser(task.getResult().getUser());
                                getActivity().startActivity(new Intent(getActivity(),MainActivity.class));
                            } else binding.logButton.setEnabled(true);
                        });
            }
        });
        return binding.getRoot();
    }
}