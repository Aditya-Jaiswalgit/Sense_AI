package com.example.senseai;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btneditprofile = findViewById(R.id.btneditprofile);
        btneditprofile.setOnClickListener(v->{
            startActivity(new Intent(AdminActivity.this, ProfileActivity.class));
        });
        Button addfrnd = findViewById(R.id.btnaddfriend);
        addfrnd.setOnClickListener(v->{
            Toast.makeText(AdminActivity.this,"In Progress",Toast.LENGTH_SHORT).show();
        });
    }
}