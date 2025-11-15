package com.example.viewpagerproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    private EditText editTextName;
    private EditText editTextEmail;
    private Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các view
        initViews();

        // Thiết lập ViewPager2
        setupViewPager();

        // Thiết lập sự kiện click
        setupButtonClick();
    }

    private void initViews() {
        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonContinue = findViewById(R.id.buttonContinue);
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        // Kết nối TabLayout với ViewPager2 (tạo dots indicator)
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    // Không set text, chỉ hiển thị dots
                }
        ).attach();
    }

    private void setupButtonClick() {
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();

                // Validation
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Vui lòng nhập tên!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Vui lòng nhập email!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chuyển sang SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("USER_NAME", name);
                intent.putExtra("USER_EMAIL", email);
                startActivity(intent);
            }
        });
    }
}