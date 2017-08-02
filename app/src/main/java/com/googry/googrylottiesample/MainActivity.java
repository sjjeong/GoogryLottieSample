package com.googry.googrylottiesample;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.lav_progress_success);
        animationView.setAnimation("progress_success.json");
//        animationView.loop(true);
//        animationView.playAnimation();

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                animationView.setProgress((float)progress/100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final LottieAnimationView lavHappyBirthday1 = (LottieAnimationView) findViewById(R.id.lav_happybirthday1);
        final LottieAnimationView lavHappyBirthday2 = (LottieAnimationView) findViewById(R.id.lav_happybirthday2);

        final ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f)
                .setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                lavHappyBirthday1.setProgress((Float) animation.getAnimatedValue());
            }
        });
        final ValueAnimator animator2 = ValueAnimator.ofFloat(0f, 1f)
                .setDuration(3000);
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                lavHappyBirthday2.setProgress((Float) animation.getAnimatedValue());
            }
        });

        Button btnStart = (Button)findViewById(R.id.btn_start_animator);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
                animator2.start();
            }
        });


    }
}
