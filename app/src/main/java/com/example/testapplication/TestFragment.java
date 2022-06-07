package com.example.testapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.testapplication.databinding.FragmentTestBinding;
import com.example.testapplication.ui.dashboard.DashboardFragment;


public class TestFragment extends Fragment {

    private FragmentTestBinding binding;
    private QuestionsAdapter adapter;
    int ind, ans;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new QuestionsAdapter(getActivity(), getArguments().getInt("pos"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTestBinding.inflate(inflater,container,false);
        binding.pager.setUserInputEnabled(false);
        binding.button2.setOnClickListener(view -> {
            binding.button2.setEnabled(false);
            binding.button2.setVisibility(View.INVISIBLE);
            binding.button3.setVisibility(View.VISIBLE);
            binding.pager.setAdapter(adapter);
            ind = 0; ans = 0;
            binding.button3.setOnClickListener(view1 -> {
                if(((QuestionFragment)adapter.fragments[ind]).getSelected()!=-1) {
                    if(ind==adapter.fragments.length-1) {
                        Toast.makeText(getContext(),"Тест пройден, правильных ответов "+ans+" из 20",Toast.LENGTH_SHORT).show();
                        NavController controller = Navigation.findNavController(getActivity(),R.id.nav_host_fragment_activity_main);
                        controller.popBackStack();
                    }
                    if(((QuestionFragment)adapter.fragments[ind]).getSelected()== DashboardFragment.tests[getArguments().getInt("pos")][ind].ind) ans++;
                    ind++;
                    binding.pager.setCurrentItem(ind);
                } else Toast.makeText(getContext(),"Укажите ответ",Toast.LENGTH_SHORT).show();
            });
        });
        return binding.getRoot();
    }
}