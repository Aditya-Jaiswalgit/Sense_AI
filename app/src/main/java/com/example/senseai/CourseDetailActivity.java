package com.example.senseai;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CourseDetailActivity extends AppCompatActivity {

    private VideoView courseVideo;
    private TextView courseTitle, courseContent;
    private MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        courseVideo = findViewById(R.id.courseVideo);
        courseTitle = findViewById(R.id.courseTitle);
        courseContent = findViewById(R.id.courseContent);

        // Get data from intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("courseTitle");
        String content = intent.getStringExtra("courseContent");
        int videoResource = intent.getIntExtra("courseVideo", 0);

        // Set data to views
        courseTitle.setText(title);
        courseContent.setText(content);

        // Set up the video
        String path = "android.resource://" + getPackageName() + "/" + videoResource;
        courseVideo.setVideoURI(Uri.parse(path));
        mediaController = new MediaController(this);
        mediaController.setAnchorView(courseVideo);
        courseVideo.setMediaController(mediaController);
//        courseVideo.start();
    }
}