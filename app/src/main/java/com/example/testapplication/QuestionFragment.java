package com.example.testapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.testapplication.databinding.FragmentQuestionBinding;


public class QuestionFragment extends Fragment {

    private Question question;
    private FragmentQuestionBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        question = (Question) getArguments().getSerializable("question");

    }

    public static QuestionFragment newInstance(Question question) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable("question",question);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuestionBinding.inflate(inflater,container,false);
        binding.setQuestion(question);
        binding.invalidateAll();
        return binding.getRoot();
    }

    public int getSelected() {
        for(int i = 0;i<binding.group.getChildCount();i++) if(((RadioButton)binding.group.getChildAt(i)).isChecked()) return i;
        return -1;
    }
}