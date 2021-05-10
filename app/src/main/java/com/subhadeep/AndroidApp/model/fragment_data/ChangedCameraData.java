package com.subhadeep.AndroidApp.model.fragment_data;

public class ChangedCameraData {

    private String fragmentName;
    private Camera camera;

    public ChangedCameraData(String fragmentName, Camera camera) {
        this.fragmentName = fragmentName;
        this.camera = camera;
    }


    public String getFragmentName() {
        return fragmentName;
    }

    public Camera getCamera() {
        return camera;
    }

}
