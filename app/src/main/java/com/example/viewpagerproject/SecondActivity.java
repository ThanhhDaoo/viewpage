package com.example.viewpagerproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewEmail;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Khởi tạo views
        initViews();

        // Nhận dữ liệu từ Intent
        receiveData();

        // Thiết lập button Back
        setupBackButton();
    }

    private void initViews() {
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);
        buttonBack = findViewById(R.id.buttonBack);
    }

    private void receiveData() {
        Intent intent = getIntent();

        // Lấy dữ liệu từ Intent
        String name = intent.getStringExtra("USER_NAME");
        String email = intent.getStringExtra("USER_EMAIL");

        // Hiển thị dữ liệu
        textViewName.setText(name);
        textViewEmail.setText(email);
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