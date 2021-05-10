package com.subhadeep.AndroidApp.view;


import android.os.Bundle;
import android.view.WindowManager;


import com.subhadeep.AndroidApp.utils.AppConstants;
import com.subhadeep.AndroidApp.view.activity4_extra.KiwiFragment;
import com.subhadeep.AndroidApp.R;
import com.subhadeep.AndroidApp.model.settings_data.SettingsData;
import com.subhadeep.AndroidApp.view_model.ViewModel4_View3DModel;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class Activity4_View3DModel extends FragmentActivity implements Observer<SettingsData> {

    private ViewModel4_View3DModel viewModel4_view3DModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //hide status bar

        viewModel4_view3DModel = new ViewModelProvider(this).get(ViewModel4_View3DModel.class);
        viewModel4_view3DModel.getSettingsData().observe(this, this);
        viewModel4_view3DModel.subscribeToSettingsData();
    }


    @Override
    public void onChanged(SettingsData settingsData) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentHolder1, new KiwiFragment(), AppConstants.FRAGMENT_ONE_NAME);

        if (settingsData.getDisplayTwoModels() && !settingsData.getDisplayOverlapModels()) {
            setContentView(R.layout.view3d_separate);
            fragmentTransaction.add(R.id.fragmentHolder2, new KiwiFragment(), AppConstants.FRAGMENT_TWO_NAME);
        }
        else
            setContentView(R.layout.view3d_overlap);

        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }


}

