package com.example.viewpagerproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewEmail;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private Button buttonBack;

    // Tên các tab
    private String[] tabTitles = {"Thông tin", "Hình ảnh", "Cài đặt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Khởi tạo views
        initViews();

        // Nhận dữ liệu từ Intent
        receiveData();

        // Thiết lập TabLayout với ViewPager2
        setupTabLayout();

        // Thiết lập button Back
        setupBackButton();
    }

    private void initViews() {
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        tabLayout = findViewById(R.id.tabLayoutSecond);
        viewPager2 = findViewById(R.id.viewPager2Second);
        buttonBack = findViewById(R.id.buttonBack);
    }

    private void receiveData() {
        Intent intent = getIntent();

        // Lấy dữ liệu từ Intent
        String name = intent.getStringExtra("USER_NAME");
        String email = intent.getStringExtra("USER_EMAIL");

        // Hiển thị dữ liệu
        if (name != null && !name.isEmpty()) {
            textViewName.setText(name);
        }
        if (email != null && !email.isEmpty()) {
            textViewEmail.setText(email);
        }
    }

    private void setupTabLayout() {
        // Tạo adapter cho ViewPager2
        SecondViewPagerAdapter adapter = new SecondViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        // Kết nối TabLayout với ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    tab.setText(tabTitles[position]);
                }
        ).attach();

        // Sự kiện khi chọn tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Có thể thêm logic khi tab được chọn
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Có thể thêm logic khi bỏ chọn tab
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Có thể thêm logic khi chọn lại tab
            }
        });
    }

    private void setupBackButton() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quay lại màn hình trước
                finish();
            }
        });
    }
}