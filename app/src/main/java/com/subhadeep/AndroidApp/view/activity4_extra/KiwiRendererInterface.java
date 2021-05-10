package com.subhadeep.AndroidApp.view.activity4_extra;

import android.view.KeyEvent;
import android.view.MotionEvent;

import com.subhadeep.AndroidApp.model.fragment_data.Camera;
import com.subhadeep.AndroidApp.utils.AppConstants;

public interface KiwiRendererInterface extends android.opengl.GLSurfaceView.Renderer {

     // this method is used by the surface view to notify the renderer of orientation changes.
     void onOrientationChanged (AppConstants.ORIENTATION previousOrientation,
                                AppConstants.ORIENTATION currentOrientation);

     void setVtkCamera(Camera camera); // used to set a set of camera parameters.

     boolean isInitialized(); // this method may be used to check if the renderer has been initialized.

     Camera getVtkCamera(); // this method is used by retrieve the current camera parameters.

     void onMotionEvent(final MotionEvent me, boolean useAbsolutePositions); // method to process user touch events.

     void simulateTouchEvent(int actionMasked, float xPos, float yPos, int ids); // used to artificially create simulate user input.

     void onKeyEvent(boolean down, KeyEvent ke); // method to process key press.

}
