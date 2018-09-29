package com.example.muhammadzubair.myapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent obj = new Intent(LauncherActivity.this,LoginActivity.class);
                    startActivity(obj);
                }
            }
        };
        t1.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
