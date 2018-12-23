package com.example.joychowdhory.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar probarID;
     private int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);



        probarID = (ProgressBar) findViewById(R.id.probarID);
        Thread thread = new Thread((new Runnable() {
            @Override
            public void run() {
               doWork();
            }
        }));
        thread.start();
    }

      public void doWork(){

         for (progress=20; progress<=100;progress = progress + 20 ){
             try {
                 Thread.sleep(1000);
                 probarID.setProgress(progress);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

      }
       private void startApp (){

         Intent intent = new Intent(SplashScreen.this,HomeActivity.class);
       }
}

