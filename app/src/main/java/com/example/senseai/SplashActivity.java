package com.example.senseai;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RelativeLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView logoImageView = findViewById(R.id.logoImageView);
        TextView centerTextView = findViewById(R.id.centerTextView);
        RelativeLayout mainLayout = findViewById(R.id.main);

        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(logoImageView, "rotation", 0f, 270f, 0f);
        rotateAnimator.setDuration(2500);

        ObjectAnimator moveAnimator = ObjectAnimator.ofFloat(logoImageView, "translationX", 0f, -300f);
        moveAnimator.setDuration(1500);

        moveAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                logoImageView.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });

        // Text appearance animation
        centerTextView.setVisibility(View.VISIBLE); // Ensure text is visible before animating
        ObjectAnimator textAlphaAnimator = ObjectAnimator.ofFloat(centerTextView, "alpha", 0f, 1f);
        textAlphaAnimator.setDuration(1000); // 1 second
//        textAlphaAnimator.setStartDelay(1000); // Start after the move animation

        // Background color change animation
//        ValueAnimator colorAnimator = ValueAnimator.ofArgb(Color.BLACK, Color.parseColor("#BA43CE")); // From black to pink
//        colorAnimator.setDuration(1000); // 1 second
//        colorAnimator.setStartDelay(1000); // Start after the move animation
//        colorAnimator.addUpdateListener(animator -> mainLayout.setBackgroundColor((int) animator.getAnimatedValue()));
        // Combine animations

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(rotateAnimator, moveAnimator, textAlphaAnimator);

        animatorSet.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                checkUserStatus();
            }
        },6000);

    }
    private void checkUserStatus() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(SplashActivity.this, Home.class));
        } else {
            startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
        }
        finish();
    }
}