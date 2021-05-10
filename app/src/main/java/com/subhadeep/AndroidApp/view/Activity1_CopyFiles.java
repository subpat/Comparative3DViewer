package com.subhadeep.AndroidApp.view;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

import com.subhadeep.AndroidApp.R;
import com.subhadeep.AndroidApp.model.copy_files_data.CopyState;
import com.subhadeep.AndroidApp.view_model.ViewModel1_CopyFiles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


public class Activity1_CopyFiles extends AppCompatActivity implements Observer<CopyState> {

    private ViewModel1_CopyFiles viewModel1_copyFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        viewModel1_copyFiles = new ViewModelProvider(this).get(ViewModel1_CopyFiles.class);
        viewModel1_copyFiles.getCopyState().observe(this, this);
    }


    @Override
    public void onChanged(CopyState copyState) {
        if (copyState == CopyState.COMPLETE) {
            startActivity(new Intent(getApplicationContext(), Activity2_Settings.class));
        }
    }
}
