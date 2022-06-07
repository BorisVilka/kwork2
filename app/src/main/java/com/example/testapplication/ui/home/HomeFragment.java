package com.example.testapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.testapplication.Adapter;
import com.example.testapplication.R;
import com.example.testapplication.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Adapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        adapter = new Adapter(getContext(),(pos)->{
            NavController controller = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
            Bundle args = new Bundle();
            args.putString("text",getResources().getStringArray(R.array.text)[pos]);
            controller.navigate(R.id.navigation_lesson,args);
        });
        binding.list.setAdapter(adapter);
        binding.list.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}