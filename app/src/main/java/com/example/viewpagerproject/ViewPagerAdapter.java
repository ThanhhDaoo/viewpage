package com.example.viewpagerproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {

    private int[] layouts = {
            R.layout.page_one,
            R.layout.page_two,
            R.layout.page_three
    };

    private LayoutInflater inflater;
    private MainActivity context;

    public ViewPagerAdapter(MainActivity mainActivity) {
        this.context = mainActivity;
        this.inflater = LayoutInflater.from(mainActivity);
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(viewType, parent, false);
        return new ViewPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        // Thiết lập RecyclerView cho từng trang
        RecyclerView recyclerView = holder.itemView.findViewById(R.id.recyclerView);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            // Tạo dữ liệu khác nhau cho từng trang
            List<ItemModel> items = getDataForPage(position);

            // Set adapter
            ItemAdapter adapter = new ItemAdapter(items);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return layouts.length;
    }

    @Override
    public int getItemViewType(int position) {
        return layouts[position];
    }

    /**
     * Tạo dữ liệu mẫu cho từng trang
     */
    private List<ItemModel> getDataForPage(int position) {
        List<ItemModel> items = new ArrayList<>();

        switch (position) {
            case 0: // Trang Chào mừng
                items.add(new ItemModel("Giao diện đẹp", "Thiết kế hiện đại, thân thiện người dùng"));
                items.add(new ItemModel("Dễ sử dụng", "Tính năng đơn giản, dễ thao tác"));
                items.add(new ItemModel("Nhanh chóng", "Hiệu suất cao, phản hồi tức thì"));
                items.add(new ItemModel("Bảo mật", "Dữ liệu được mã hóa an toàn"));
                items.add(new ItemModel("Đa nền tảng", "Hỗ trợ nhiều thiết bị khác nhau"));
                break;

            case 1: // Trang Giới thiệu
                items.add(new ItemModel("Dịch vụ 1", "Tư vấn và hỗ trợ 24/7"));
                items.add(new ItemModel("Dịch vụ 2", "Đào tạo chuyên sâu"));
                items.add(new ItemModel("Dịch vụ 3", "Bảo trì và nâng cấp"));
                items.add(new ItemModel("Dịch vụ 4", "Tùy chỉnh theo nhu cầu"));
                items.add(new ItemModel("Dịch vụ 5", "Tích hợp hệ thống"));
                break;

            case 2: // Trang Bắt đầu
                items.add(new ItemModel("Bước 1", "Đăng ký tài khoản miễn phí"));
                items.add(new ItemModel("Bước 2", "Xác thực email của bạn"));
                items.add(new ItemModel("Bước 3", "Hoàn thiện thông tin cá nhân"));
                items.add(new ItemModel("Bước 4", "Khám phá các tính năng"));
                items.add(new ItemModel("Bước 5", "Bắt đầu sử dụng ngay"));
                break;
        }

        return items;
    }

    static class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}