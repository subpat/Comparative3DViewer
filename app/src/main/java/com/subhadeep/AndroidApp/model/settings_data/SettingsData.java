package com.subhadeep.AndroidApp.model.settings_data;

import com.subhadeep.AndroidApp.model.fragment_data.Point3D;
import com.subhadeep.AndroidApp.utils.ColorCode;

import java.io.Serializable;

public class SettingsData implements Serializable {

    private boolean displayTwoModels;
    private boolean displayOverlappingModels;
    private Window windowOne, windowTwo;

    public SettingsData () {
        displayTwoModels = false;
        displayOverlappingModels = false;
        windowOne = null;
        windowTwo = null;
    }

    public SettingsData (String filePath) {
        displayTwoModels = false;
        displayOverlappingModels = false;
        windowOne = new Window("Name", ColorCode.Color.WHITE, new ThreeDModel(
                filePath, //context.getExternalFilesDir(null).getAbsolutePath() + File.separator + "avatar.obj",
                1.0, ColorCode.Color.WHITE, new Point3D(0,0,0)));
        windowTwo = null;
    }

    public SettingsData (boolean displayTwoModels,
                         boolean displayOverlappingModels,
                         Window windowOne, Window windowTwo) {
        this.displayTwoModels = displayTwoModels;
        this.displayOverlappingModels = displayOverlappingModels;
        this.windowOne = windowOne;
        this.windowTwo = windowTwo;
    }


    public static SettingsData getDefaultSettings () {
        return new SettingsData();
    }

    public boolean getDisplayTwoModels() {
        return displayTwoModels;
    }

    public boolean getDisplayOverlapModels() {
        return displayOverlappingModels;
    }

    public Window getWindowOne() { return windowOne; }

    public Window getWindowTwo() { return windowTwo; }

    public void setDisplayTwoModels(boolean displayTwoModels) {
        this.displayTwoModels = displayTwoModels;
    }

    public void setDisplayOverlappingModels(boolean displayOverlappingModels) {
        this.displayOverlappingModels = displayOverlappingModels;
    }

    public void setWindowOne(Window windowOne) {
        this.windowOne = windowOne;
    }

    public void setWindowTwo(Window windowTwo) {
        this.windowTwo = windowTwo;
    }
}
