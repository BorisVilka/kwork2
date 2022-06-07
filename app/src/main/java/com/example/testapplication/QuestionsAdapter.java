package com.example.testapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testapplication.ui.dashboard.DashboardFragment;

public class QuestionsAdapter extends FragmentStateAdapter {

    public Fragment[] fragments;

    public QuestionsAdapter(@NonNull FragmentActivity fragmentActivity, int num) {
        super(fragmentActivity);
        fragments = new Fragment[20];
        for(int i = 0;i<fragments.length;i++) fragments[i] = QuestionFragment.newInstance(DashboardFragment.tests[num][i]);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
