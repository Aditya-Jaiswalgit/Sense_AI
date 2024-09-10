package com.example.senseai;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        Button home_btn_sign = findViewById(R.id.home_btn_sign);
        Button home_btn_courses = findViewById(R.id.home_btn_courses);
        Button home_btn_profile = findViewById(R.id.home_btn_profile);
        Button home_btn_learn = findViewById(R.id.home_btn_learn);
        home_btn_sign.setOnClickListener(v -> {
            startActivity(new Intent(Home.this, MainActivity.class));
        });

        home_btn_courses.setOnClickListener(v -> {
            startActivity(new Intent(Home.this, LearnActivity.class));
        });

        home_btn_profile.setOnClickListener(v -> {
            startActivity(new Intent(Home.this, AdminActivity.class));
        });

        home_btn_learn.setOnClickListener(v -> {
            Toast.makeText(Home.this, "In Progress", Toast.LENGTH_SHORT).show();
        });

        // Apply window insets after initializing views
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bottom navigation view handling
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    return true;
                } else if (itemId == R.id.sign) {
                    startActivity(new Intent(Home.this, MainActivity.class));
                    return true;
                } else if (itemId == R.id.tutorial) {
                    startActivity(new Intent(Home.this, LearnActivity.class));
                    return true;
                } else if (itemId == R.id.profile) {
                    startActivity(new Intent(Home.this, AdminActivity.class));
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}
