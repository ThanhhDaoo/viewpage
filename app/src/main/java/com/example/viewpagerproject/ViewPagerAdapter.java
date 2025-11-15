package com.example.viewpagerproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {

    // Mảng chứa layout của 3 trang
    private int[] layouts = {
            R.layout.page_one,
            R.layout.page_two,
            R.layout.page_three
    };

    private LayoutInflater inflater;

    public ViewPagerAdapter(MainActivity mainActivity) {
        this.inflater = LayoutInflater.from(mainActivity);
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout dựa vào viewType
        View view = inflater.inflate(viewType, parent, false);
        return new ViewPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        // Không cần bind gì vì layout đã có sẵn nội dung
    }

    @Override
    public int getItemCount() {
        return layouts.length;
    }

    @Override
    public int getItemViewType(int position) {
        // Trả về layout tương ứng với position
        return layouts[position];
    }

    // ViewHolder class
    static class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}