package com.powerdev.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=findViewById(R.id.imag_splash);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.splashtransition);//لعمل animation
        imageView.startAnimation(animation);
        // splashScreen code
        Thread thread =new Thread()
        {
            @Override
            public void run() {
                // لازم وضع كود الانتقال داخل try and catch لتجنب حدوث مشاكل اثناء تشغيل التطبيق
                try {
                    sleep(4000); // وقت splash screen
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class); // الانتقال الي الاكتفيتي الرئيسى بعد انتهاء وقت ال splash screen
                    startActivity(intent); // to start intent
                    finish(); // to finish splash screen activity
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally{
                    finish();
                }
            }
        };
        thread.start();
    }}
