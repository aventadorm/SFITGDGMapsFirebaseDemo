package com.mayurphadte.gdgmumbaifirebasemaps;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Delay Code
        Handler mHandler = new Handler();
        Runnable mLaunchTask = new Runnable() {
            public void run() {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        };
        mHandler.postDelayed(mLaunchTask,2000);





    }
}
