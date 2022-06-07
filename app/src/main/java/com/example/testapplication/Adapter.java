package com.example.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MainHolder> {

    private Context context;
    private ClickListener listener;

    public Adapter(Context context,ClickListener listener) {
        this.context = context;
        this.listener = listener;

    }
    public interface ClickListener {
        void click(int pos);
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        holder.bind(position,context);
        holder.itemView.setOnClickListener(view -> listener.click(position));
    }

    @Override
    public int getItemCount() {
        return context.getResources().getStringArray(R.array.text).length;
    }

    @Override
    public void onViewRecycled(@NonNull MainHolder holder) {
        holder.itemView.setOnClickListener(null);
        super.onViewRecycled(holder);
    }

    public static class MainHolder extends RecyclerView.ViewHolder {

        public MainHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(int pos,Context context) {
            ((TextView)itemView.findViewById(R.id.textView)).setText(context.getResources().getStringArray(R.array.title)[pos]);
        }
    }
}
