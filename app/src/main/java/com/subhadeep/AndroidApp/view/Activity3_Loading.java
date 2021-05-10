package com.subhadeep.AndroidApp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.subhadeep.AndroidApp.R;


public class Activity3_Loading extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_model);
        new Handler(Looper.getMainLooper())
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivityForResult(new Intent(getApplicationContext(), Activity4_View3DModel.class), 0);
                    }
                }, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onBackPressed();
    }

}
