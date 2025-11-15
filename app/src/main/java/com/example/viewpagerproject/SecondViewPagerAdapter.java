package com.example.viewpagerproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SecondViewPagerAdapter extends RecyclerView.Adapter<SecondViewPagerAdapter.SecondViewHolder> {

    private int[] layouts = {
            R.layout.tab_info,
            R.layout.tab_gallery,
            R.layout.tab_settings
    };

    private LayoutInflater inflater;
    private SecondActivity context;

    public SecondViewPagerAdapter(SecondActivity activity) {
        this.context = activity;
        this.inflater = LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public SecondViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(viewType, parent, false);
        return new SecondViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecondViewHolder holder, int position) {
        if (position == 1) { // Tab Gallery
            setupGalleryTab(holder);
        } else if (position == 2) { // Tab Settings
            setupSettingsTab(holder);
        }
        // Tab Info (position 0) không cần setup gì thêm vì là static layout
    }

    /**
     * Thiết lập tab Gallery với RecyclerView
     */
    private void setupGalleryTab(SecondViewHolder holder) {
        RecyclerView recyclerView = holder.itemView.findViewById(R.id.recyclerViewGallery);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            // Tạo dữ liệu mẫu cho gallery
            List<ItemModel> galleryItems = new ArrayList<>();
            galleryItems.add(new ItemModel("Ảnh 1", "Phong cảnh thiên nhiên đẹp"));
            galleryItems.add(new ItemModel("Ảnh 2", "Kiến trúc hiện đại"));
            galleryItems.add(new ItemModel("Ảnh 3", "Món ăn ngon"));
            galleryItems.add(new ItemModel("Ảnh 4", "Du lịch khám phá"));
            galleryItems.add(new ItemModel("Ảnh 5", "Nghệ thuật sáng tạo"));
            galleryItems.add(new ItemModel("Ảnh 6", "Thể thao sôi động"));

            ItemAdapter adapter = new ItemAdapter(galleryItems);
            recyclerView.setAdapter(adapter);
        }
    }

    /**
     * Thiết lập tab Settings với các sự kiện click
     */
    private void setupSettingsTab(SecondViewHolder holder) {
        // Tìm các button trong tab settings
        View buttonEditProfile = holder.itemView.findViewById(R.id.buttonEditProfile);
        View buttonChangePassword = holder.itemView.findViewById(R.id.buttonChangePassword);
        View buttonLogout = holder.itemView.findViewById(R.id.buttonLogout);

        // Thiết lập sự kiện click
        if (buttonEditProfile != null) {
            buttonEditProfile.setOnClickListener(v ->
                    Toast.makeText(context, "Chức năng chỉnh sửa hồ sơ", Toast.LENGTH_SHORT).show()
            );
        }

        if (buttonChangePassword != null) {
            buttonChangePassword.setOnClickListener(v ->
                    Toast.makeText(context, "Chức năng đổi mật khẩu", Toast.LENGTH_SHORT).show()
            );
        }

        if (buttonLogout != null) {
            buttonLogout.setOnClickListener(v ->
                    Toast.makeText(context, "Đăng xuất thành công", Toast.LENGTH_SHORT).show()
            );
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

    static class SecondViewHolder extends RecyclerView.ViewHolder {
        public SecondViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}