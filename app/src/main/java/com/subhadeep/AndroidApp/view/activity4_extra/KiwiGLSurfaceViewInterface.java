package com.subhadeep.AndroidApp.view.activity4_extra;

import com.subhadeep.AndroidApp.model.fragment_data.Camera;
import com.subhadeep.AndroidApp.model.settings_data.Window;
import com.subhadeep.AndroidApp.utils.AppConstants;

public interface KiwiGLSurfaceViewInterface {

    // used to initialize the surface view.
    void init(KiwiFragment kiwiFragment, Window window, AppConstants.ORIENTATION currentOrientation);

    // this method is used by the fragment to notify the surface view of orientation changes.
    void onOrientationChanged(AppConstants.ORIENTATION previousOrientation,
                              AppConstants.ORIENTATION currentOrientation);

    void setDefaultCamera(Camera camera); // to temporarily store the default camera settings.

    Camera getDefaultCamera(); // may be used to restore the default camera settings.

    void generateRestoreCamera(); // store camera settings when the activity is paused.

    void restorePreviousCameraSettings(); // to restore the previous camera settings if the activity was minimized and reopened.

    void simulateFixedTouchEvent(); // used to refresh the OpenGL surface view programmatically by simulating a touch event.

    void requestCameraToInitState(); // uses the camera settings using getDefaultCamera() and imposes these settings on the current model.

    void setCamera(Camera camera); // use this method to impose a set of camera parameters on the current model.

    void broadcastTouchEvent(); // this method may be used to share the camera parameters between fragments.
}
