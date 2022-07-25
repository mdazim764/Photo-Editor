package com.example.myapplicationphotoeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progress1,progress2;
    TextView text;
    Handler hdlr =new Handler();
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        progress1 = findViewById(R.id.progress1);
        progress2 = findViewById(R.id.progress2);
        text = findViewById(R.id.text);

        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();

            }
        }).start();
    }

    private void doWork() {
        for (int progress=0; progress<100; progress+=1) {
            try {
                Thread.sleep(50);
                progress1.setProgress(progress);
                progress2.setProgress(progress);
                text.setText(progress + "/"+progress1.getMax() );


            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}