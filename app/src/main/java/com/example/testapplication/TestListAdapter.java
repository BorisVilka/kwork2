package com.example.testapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.ui.dashboard.DashboardFragment;

public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.TestHolder> {

    private Adapter.ClickListener listener;

    public TestListAdapter(Adapter.ClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TestHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        holder.bind(position);
        holder.itemView.setOnClickListener(view -> listener.click(position));
    }

    @Override
    public void onViewRecycled(@NonNull TestHolder holder) {
        holder.itemView.setOnClickListener(null);
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return DashboardFragment.tests.length;
    }

    public static class TestHolder extends RecyclerView.ViewHolder {

        public TestHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(int pos) {
            ((TextView)itemView.findViewById(R.id.textView2)).setText("Тест номер "+(pos+1));
        }
    }
}
