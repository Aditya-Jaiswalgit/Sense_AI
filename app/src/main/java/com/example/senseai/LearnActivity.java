package com.example.senseai;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.senseai.adapter.CourseAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class LearnActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CourseAdapter courseAdapter;
    private List<Course> courseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_learn);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    startActivity(new Intent(LearnActivity.this, Home.class));
                    return true;
                } else if (itemId == R.id.sign) {
                    startActivity(new Intent(LearnActivity.this, MainActivity.class));
                    return true;
                } else if (itemId == R.id.tutorial) {
                    startActivity(new Intent(LearnActivity.this, LearnActivity.class));
                    return true;
                } else if (itemId == R.id.profile) {
                    startActivity(new Intent(LearnActivity.this, AdminActivity.class));
                    return true;
                } else {
                    return false;
                }
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        courseList = new ArrayList<>();
        courseList.add(new Course("Alphabet", "Learn the basics of alphabet", R.raw.alphabet_video, "Alphabet content goes here..."));
        courseList.add(new Course("Basic Words", "Commonly used words", R.raw.basic_words_video, "Basic words content goes here..."));
        courseList.add(new Course("Sign of the Day", "Learn Unique", R.raw.basic_words_video, "content goes here..."));
        courseList.add(new Course("Learning Games", "Learning through Games", R.raw.basic_words_video, "Basic words content goes here..."));
        courseList.add(new Course("Learn Phase", "Small Sentences", R.raw.basic_words_video, "Basic words content goes here..."));
        courseList.add(new Course("Key Actions", "Focus on Some Actions", R.raw.basic_words_video, "Basic words content goes here..."));
        // Add more courses as needed

        courseAdapter = new CourseAdapter(courseList, this);
        recyclerView.setAdapter(courseAdapter);
    }
}