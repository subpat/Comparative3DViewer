package com.subhadeep.AndroidApp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.subhadeep.AndroidApp.model.settings_data.ThreeDModel;
import com.subhadeep.AndroidApp.model.settings_data.Window;
import com.subhadeep.AndroidApp.model.settings_data.SettingsData;
import com.subhadeep.AndroidApp.utils.ColorCode;
import com.subhadeep.AndroidApp.utils.AppConstants;
import com.subhadeep.AndroidApp.R;
import com.subhadeep.AndroidApp.view.activity2_extra.ConfigureSpinner;
import com.subhadeep.AndroidApp.view_model.ViewModel2_Settings;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class Activity2_Settings extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    private String offset[];
    private ViewModel2_Settings viewModel2_settings;

    private SettingsData settingsData;
    private Window windowOne, windowTwo;
    private ThreeDModel modelOne, modelTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        offset = getResources().getStringArray(R.array.offset);
        setupDisplay();

        viewModel2_settings = new ViewModelProvider(this).get(ViewModel2_Settings.class);
        viewModel2_settings.resetSettingsData();

        settingsData = new SettingsData();

        modelOne = new ThreeDModel();
        modelOne.setFilePath(getExternalFilesDir(null).getAbsolutePath() + File.separator + AppConstants.CONTENT_FILE_ONE);
        modelTwo = new ThreeDModel();
        modelTwo.setFilePath(getExternalFilesDir(null).getAbsolutePath() + File.separator + AppConstants.CONTENT_FILE_TWO);
        windowOne = new Window(AppConstants.FRAGMENT_ONE_NAME, ColorCode.Color.WHITE, modelOne);
        windowTwo = new Window(AppConstants.FRAGMENT_TWO_NAME, ColorCode.Color.WHITE, modelTwo);
    }

    private void setupDisplay() {
        Button mClickButton = findViewById(R.id.button_go);
        mClickButton.setOnClickListener(this);

        activateSecondFileOption(false);
        ConfigureSpinner.perform(this, findViewById(R.id.NumFiles), R.array.models, this);                                      //generate no of files spinner
        ConfigureSpinner.perform(this, findViewById(R.id.Mode), R.array.windows, this);                                         //generate mode of operation
        ConfigureSpinner.perform(this, findViewById(R.id.background_one_color_group), ColorCode.getColorGroupList(), this);     //generate color group for background one
        ConfigureSpinner.perform(this, findViewById(R.id.background_two_color_group), ColorCode.getColorGroupList(), this);     //generate color group for background two
        ConfigureSpinner.perform(this, findViewById(R.id.FileOneName), getListOfFiles(), this);                                 //generate mode of file list one
        ConfigureSpinner.perform(this, findViewById(R.id.FileOnePos), getPosList(), this);                                      //generate position spinner for file one
        ConfigureSpinner.perform(this, findViewById(R.id.FileOneOpacity), R.array.opacity, this);                               //generate opacity spinner for file one
        ConfigureSpinner.perform(this, findViewById(R.id.FileOneColorGroup), ColorCode.getColorGroupList(), this);              //generate mode of color group one
        ConfigureSpinner.perform(this, findViewById(R.id.FileTwoName), getListOfFiles(), this);                                 //generate mode of file list two
        ConfigureSpinner.perform(this, findViewById(R.id.FileTwoPos), getPosList(), this);                                      //generate position spinner for file one
        ConfigureSpinner.perform(this, findViewById(R.id.FileTwoOpacity), R.array.opacity, this);                               //generate opacity spinner for file one
        ConfigureSpinner.perform(this, findViewById(R.id.FileTwoColorGroup), ColorCode.getColorGroupList(), this);              //generate mode of color group two
    }


    private void activateSecondFileOption(boolean bool) {
        findViewById(R.id.FileTwoName).setEnabled(bool);
        findViewById(R.id.FileTwoPos).setEnabled(bool);
        findViewById(R.id.FileTwoOpacity).setEnabled(bool);
        findViewById(R.id.FileTwoColorGroup).setEnabled(bool);
        findViewById(R.id.FileTwoColor).setEnabled(bool);
    }

    private List<String> getListOfFiles() {
        String files[] = null;
        List<String> temp = new ArrayList<String>();
        try{
            files = getAssets().list("");
        }catch(Exception e){}
        for(int i = 0; i < files.length; i++){
            if(files[i].endsWith(AppConstants.FORMAT3D.ATOBJ.toString()) ||
                    files[i].endsWith(AppConstants.FORMAT3D.ATSTL.toString()) ||
                    files[i].endsWith(AppConstants.FORMAT3D.ATVTK.toString())) {
                temp.add(files[i]);
            }
        }
        return temp;
    }






    private List<String> getPosList() {
        List<String> temp = new ArrayList<>();
        if (offset != null && offset.length > 0) {
            for (int i = 0; i < offset.length; i++) {
                temp.add("XYZ(" + offset[i] + "," + offset[i] + "," + offset[i] + ")");
            }
        }
        return temp;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()){
            case R.id.NumFiles:
                switch(position){
                    case 0:
                        activateSecondFileOption(false);
                        AppConstants.TWO_MODELS = false;
                        settingsData.setDisplayTwoModels(false);
                        break;
                    case 1:
                        activateSecondFileOption(true);
                        AppConstants.TWO_MODELS = true;
                        settingsData.setDisplayTwoModels(true);
                        break;
                }
                break;
            case R.id.Mode:
                switch(position){
                    case 0:
                        AppConstants.OVERLAPPING_MODE = false;
                        settingsData.setDisplayOverlappingModels(false);
                        windowOne.setModelTwo(null);
                        findViewById(R.id.background_two_color_group).setEnabled(true);
                        findViewById(R.id.background_two_color).setEnabled(true);
                        break;
                    case 1:
                        AppConstants.OVERLAPPING_MODE = true;
                        settingsData.setDisplayOverlappingModels(true);
                        windowOne.setModelTwo(modelTwo);
                        findViewById(R.id.background_two_color_group).setEnabled(false);
                        findViewById(R.id.background_two_color).setEnabled(false);
                        break;
                }
                break;
            case R.id.background_one_color_group:
                //generate list of colors
                ConfigureSpinner.perform(this, findViewById(R.id.background_one_color), ColorCode.getColorList(parent.getItemAtPosition(position).toString()), this);
                break;
            case R.id.background_one_color:
                AppConstants.BACKGROUND_COLOR_ONE = ColorCode.getColorFromString(parent.getItemAtPosition(position).toString());
                windowOne.setBackground(ColorCode.getColorFromString(parent.getItemAtPosition(position).toString()));
                break;
            case R.id.background_two_color_group:
                //generate list of colors
                ConfigureSpinner.perform(this, findViewById(R.id.background_two_color), ColorCode.getColorList(parent.getItemAtPosition(position).toString()), this);
                break;
            case R.id.background_two_color:
                AppConstants.BACKGROUND_COLOR_TWO = ColorCode.getColorFromString(parent.getItemAtPosition(position).toString());
                windowTwo.setBackground(ColorCode.getColorFromString(parent.getItemAtPosition(position).toString()));
                break;
            case R.id.FileOneName:
                AppConstants.CONTENT_FILE_ONE = getExternalFilesDir(null).getAbsolutePath() + File.separator + parent.getItemAtPosition(position).toString();
                modelOne.setFilePath(getExternalFilesDir(null).getAbsolutePath() + File.separator + parent.getItemAtPosition(position).toString());
                break;
            case R.id.FileOnePos:
                AppConstants.POSITION_FILE_ONE = new double[]{Double.valueOf(offset[position]), Double.valueOf(offset[position]), Double.valueOf(offset[position])};
                modelOne.setPosition(new double[]{Double.valueOf(offset[position]), Double.valueOf(offset[position]), Double.valueOf(offset[position])});
                break;
            case R.id.FileOneOpacity:
                AppConstants.OPACITY_FILE_ONE = Double.parseDouble(parent.getItemAtPosition(position).toString());
                modelOne.setOpacity(Double.parseDouble(parent.getItemAtPosition(position).toString()));
                break;
            case R.id.FileOneColorGroup:
                //generate list of colors
                //generate opacity spinner for file one
                ConfigureSpinner.perform(this, findViewById(R.id.FileOneColor), ColorCode.getColorList(parent.getItemAtPosition(position).toString()), this);
                break;
            case R.id.FileOneColor:
                AppConstants.COLOR_FILE_ONE = ColorCode.getColorFromString(parent.getItemAtPosition(position).toString());
                modelOne.setColor(ColorCode.getColorFromString(parent.getItemAtPosition(position).toString()));
                break;
            case R.id.FileTwoName:
                AppConstants.CONTENT_FILE_TWO = getExternalFilesDir(null).getAbsolutePath() + File.separator + parent.getItemAtPosition(position).toString();
                modelTwo.setFilePath(getExternalFilesDir(null).getAbsolutePath() + File.separator + parent.getItemAtPosition(position).toString());
                break;
            case R.id.FileTwoPos:
                AppConstants.POSITION_FILE_TWO = new double[]{Double.valueOf(offset[position]), Double.valueOf(offset[position]), Double.valueOf(offset[position])};
                modelTwo.setPosition(new double[]{Double.valueOf(offset[position]), Double.valueOf(offset[position]), Double.valueOf(offset[position])});
                break;
            case R.id.FileTwoOpacity:
                AppConstants.OPACITY_FILE_TWO = Double.parseDouble(parent.getItemAtPosition(position).toString());
                modelTwo.setOpacity(Double.parseDouble(parent.getItemAtPosition(position).toString()));
                break;
            case R.id.FileTwoColorGroup:
                ConfigureSpinner.perform(this, findViewById(R.id.FileTwoColor), ColorCode.getColorList(parent.getItemAtPosition(position).toString()), this);
                break;
            case R.id.FileTwoColor:
                AppConstants.COLOR_FILE_TWO = ColorCode.getColorFromString(parent.getItemAtPosition(position).toString());
                modelTwo.setColor(ColorCode.getColorFromString(parent.getItemAtPosition(position).toString()));
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {}


    public void onClick(View view) {
        if (view.getId() == R.id.button_go) {
            if (settingsData.getDisplayTwoModels()) { // use two models
                if (settingsData.getDisplayOverlapModels()) { // use overlapping models
                    settingsData.setWindowOne(windowOne);
                    settingsData.setWindowTwo(null); // just use one window
                }
                else { // do not use overlapping models
                    settingsData.setWindowOne(windowOne);
                    settingsData.setWindowTwo(windowTwo);
                }
            }
            else { //use only one model
                settingsData.setDisplayOverlappingModels(false);
                settingsData.setWindowOne(windowOne);
                settingsData.setWindowTwo(null);
            }
            viewModel2_settings.saveSettingsData(settingsData);
            startActivity(new Intent(this, Activity3_Loading.class));
        }
    }


}
