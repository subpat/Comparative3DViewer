package com.subhadeep.AndroidApp.view.activity4_extra;

import java.util.ArrayList;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.util.Log;
import android.view.KeyEvent;
import android.graphics.Point;
import android.view.MotionEvent;

import com.subhadeep.AndroidApp.model.fragment_data.Camera;
import com.kitware.KiwiApp.Viewer.KiwiNativeVtk;
import com.subhadeep.AndroidApp.model.settings_data.Window;
import com.subhadeep.AndroidApp.model.fragment_data.Point3D;
import com.subhadeep.AndroidApp.utils.AppConstants;
import com.subhadeep.AndroidApp.utils.ColorCode;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


class KiwiRenderer implements KiwiRendererInterface {

    private Window window;
    private long vtkContext;
    private boolean initialized;
    private KiwiGLSurfaceView parentView;

    public ArrayList<Runnable> mPostInitRunnables = new ArrayList<Runnable>();
    private static final Method NATIVE_GET_RAW_AXIS_VALUE = getNativeGetRawAxisValue();

    private static final boolean DEBUG = false;
    private static final String TAG = "MyRenderer";


    public KiwiRenderer(KiwiGLSurfaceView kiwiGLSurfaceView, Window window) {
        parentView = kiwiGLSurfaceView;
        this.window = window;
    }

    synchronized void queuePostInitEvent(Runnable runnable) {
        mPostInitRunnables.add(runnable);
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        initialized = false;
        if (DEBUG) Log.d(TAG, "onSurfaceCreated");
    }


    public void onSurfaceChanged(GL10 gl, int width, int height) {
        try {
            vtkContext = KiwiNativeVtk.init(width, height, window.getBackground().getR_By_RMAX(),
                    window.getBackground().getG_By_GMAX(), window.getBackground().getB_By_BMAX());
            loadDataset(window.getModelsPath(), window.getModelsColor(), window.getModelsOpacity(), window.getModelsPositionAsDoubleMatrix());
            KiwiNativeVtk.resetCamera(vtkContext);
            KiwiNativeVtk.render(vtkContext);
            initialized = true; //test by Subhadeep Patra 30-01-2019
            parentView.setDefaultCamera(getVtkCamera());
            parentView.restorePreviousCameraSettings();

        } catch (Exception except) {
            if (DEBUG) Log.d(TAG, "onSurfaceChanged::Exception");
        } finally {
            while (mPostInitRunnables.size() > 0) {
                mPostInitRunnables.remove(0).run();
            }
            parentView.simulateFixedTouchEvent();
            if (DEBUG)
                Log.d(TAG, "onSurfaceChanged :: width x height :: " + width + " x " + height);
        }
    }

    public void onDrawFrame(GL10 gl) {}

    private void loadDataset(final String files[], final ColorCode.Color colors[], final double opacity[], final double position[][]) {
        try {
            //convert colors to rgb matrix :
            //  r1, g1, b1,
            //  r2, g2, b2,
            //  .., .., ..,
            double rgb_mat[][] = new double[colors.length][3];
            for (int i = 0; i < colors.length; i++) {
                rgb_mat[i][0] = colors[i].getR_By_RMAX();
                rgb_mat[i][1] = colors[i].getG_By_GMAX();
                rgb_mat[i][2] = colors[i].getB_By_BMAX();
            }

            KiwiNativeVtk.loadMultipleModels(vtkContext, files, rgb_mat, opacity, position);
        } catch (Exception except) {
            Log.i("TAGG", "KiwiGLSurfaceView::loadDataset::Exception");
        }
    }

    private boolean setCameraRollForOrientationChange(final double previousAngle, final double currentAngle){
        if(isInitialized()) {
            try {
                double temp = currentAngle - previousAngle + KiwiNativeVtk.getCameraRoll(vtkContext);
                while(temp > 360){
                    temp -= 360;
                }
                while(temp < 0){
                    temp += 360;
                }
                Log.i(window.getName() + "\tPrevious Camera roll: ", "" + (int) KiwiNativeVtk.getCameraRoll(vtkContext));
                Log.i(window.getName() + "\tRequired Camera roll: ", "" + (int) temp);
                KiwiNativeVtk.setCameraRoll(vtkContext, temp);
                return true;
            } catch (Exception except) {
                Log.i("TAGG", "KiwiGLSurfaceView::rotateCameraRoll::Exception");
            }
        }
        return false;
    }

    public void setVtkCamera(Camera camera) {
        if(isInitialized() && camera.getPosition().getPointAsDoubleArray() != null) {
            KiwiNativeVtk.setCameraPosition(vtkContext, camera.getPosition().getX(), camera.getPosition().getY(), camera.getPosition().getZ());
            KiwiNativeVtk.setCameraFocalPoint(vtkContext, camera.getFocus().getX(), camera.getFocus().getY(), camera.getFocus().getZ());
            KiwiNativeVtk.setCameraViewUp(vtkContext, camera.getViewUp().getX(), camera.getViewUp().getY(), camera.getViewUp().getZ());
        }
    }

    public Camera getVtkCamera() {
        Camera temp = null;
        if(isInitialized()){
            temp = new Camera();
            temp.setPosition(new Point3D(KiwiNativeVtk.getCameraPosition(vtkContext)));
            temp.setFocus(new Point3D(KiwiNativeVtk.getCameraFocalPoint(vtkContext)));
            temp.setViewUp(new Point3D(KiwiNativeVtk.getCameraViewUp(vtkContext)));
        }
        return temp;
    }




    //FFOS forward events to VTK for it to handle
    public void onKeyEvent(boolean down, KeyEvent ke) {
        KiwiNativeVtk.onKeyEvent(vtkContext, down, ke.getKeyCode(), ke.getMetaState(), ke.getRepeatCount());
    }



    //-----------------------------------
    //BEGIN: simulated_touch_event
    //-----------------------------------

    public void simulateTouchEvent(int actionMasked, float xPos, float yPos, int ids) {
        int actionId = 0;
        int numPtrs = 1;
        int iMetaState = 0;
        float[] arr_xPos = new float[numPtrs];
        float[] arr_yPos = new float[numPtrs];
        int[] arr_ids = new int[numPtrs];

        try{
            //Log.i("TAGG", "MyRenderer::simulateTouchEventBegin::MotionEvent");
            arr_xPos[0] = xPos;
            arr_yPos[0] = yPos;
            arr_ids[0] = ids;

            KiwiNativeVtk.onMotionEvent(vtkContext,
                    actionMasked,
                    actionId,
                    numPtrs, arr_xPos, arr_yPos, arr_ids,
                    iMetaState);
        }
        catch (IllegalArgumentException e){
            if(DEBUG) Log.d(TAG, "simulateTouchEventBegin::Exception");
        }

    }

    //-----------------------------------
    //END: simulated_touch_event
    //-----------------------------------


    //FFOS forward events to VTK for it to handle
    public void onMotionEvent(final MotionEvent me) {
        try {
            int numPtrs = me.getPointerCount();
            float [] xPos = new float[numPtrs];
            float [] yPos = new float[numPtrs];
            int [] ids = new int[numPtrs];
            for (int i = 0; i < numPtrs; ++i) {
                ids[i] = me.getPointerId(i);
                xPos[i] = me.getX(i);
                yPos[i] = me.getY(i);
            }

            int actionIndex = me.getActionIndex();
            int actionMasked = me.getActionMasked();
            int actionId = me.getPointerId(actionIndex);
            KiwiNativeVtk.onMotionEvent(vtkContext,
                    actionMasked,
                    actionId,
                    numPtrs, xPos, yPos, ids,
                    me.getMetaState());

            if(DEBUG) {
                Log.d(TAG, "onMotionEvent :: actionMasked (int) = " + actionMasked);
                Log.d(TAG, "onMotionEvent :: actionId (int) = " + actionId);
                Log.d(TAG, "onMotionEvent :: numPtrs (int) = " + numPtrs);
                Log.d(TAG, "onMotionEvent :: arr_xPos[0] (float) = " + xPos[0]);
                Log.d(TAG, "onMotionEvent :: arr_yPos[0] (float) = " + yPos[0]);
                Log.d(TAG, "onMotionEvent :: arr_ids[0] (int) = " + ids[0]);
                Log.d(TAG, "onMotionEvent :: MetaState (int) = " + me.getMetaState());
            }
        }
        catch (IllegalArgumentException e){
            if(DEBUG) Log.d(TAG, "onMotionEvent::Exception");
        }

    }

    /*
    Method overloading due to enable synchronized movement
     */

    public void onMotionEvent(final MotionEvent me, boolean useAbsolutePositions) {
        if(!useAbsolutePositions) {
            onMotionEvent(me);
            return;
        }
        try {
            int numPtrs = me.getPointerCount();
            float [] xPos = new float[numPtrs];
            float [] yPos = new float[numPtrs];
            int [] ids = new int[numPtrs];
            for (int i = 0; i < numPtrs; ++i) {
                ids[i] = me.getPointerId(i);
                Point temp = calculateRawXY(me, i);
                xPos[i] = temp.x;
                yPos[i] = temp.y;
            }

            int actionIndex = me.getActionIndex();
            int actionMasked = me.getActionMasked();
            int actionId = me.getPointerId(actionIndex);

            KiwiNativeVtk.onMotionEvent(vtkContext,
                    actionMasked,
                    actionId,
                    numPtrs, xPos, yPos, ids,
                    me.getMetaState());

            if(DEBUG) {
                Log.d(TAG, "onMotionEvent :: actionMasked (int) = " + actionMasked);
                Log.d(TAG, "onMotionEvent :: actionId (int) = " + actionId);
                Log.d(TAG, "onMotionEvent :: numPtrs (int) = " + numPtrs);
                Log.d(TAG, "onMotionEvent :: arr_xPos[0] (float) = " + xPos[0]);
                Log.d(TAG, "onMotionEvent :: arr_yPos[0] (float) = " + yPos[0]);
                Log.d(TAG, "onMotionEvent :: arr_ids[0] (int) = " + ids[0]);
                Log.d(TAG, "onMotionEvent :: MetaState (int) = " + me.getMetaState());
            }
        }
        catch (IllegalArgumentException e) {
            if(DEBUG) Log.d(TAG, "onMotionEvent::Exception");
        }
    }

    public Point calculateRawXY(final MotionEvent event, final int pointerIndex) {
        try {
            Field nativePtrField = MotionEvent.class.getDeclaredField("mNativePtr");
            Field historyCurrentField = MotionEvent.class.getDeclaredField("HISTORY_CURRENT");
            nativePtrField.setAccessible(true);
            historyCurrentField.setAccessible(true);

            float x = (float) NATIVE_GET_RAW_AXIS_VALUE.invoke(null, nativePtrField.get(event),
                    MotionEvent.AXIS_X, pointerIndex, historyCurrentField.get(null));
            float y = (float) NATIVE_GET_RAW_AXIS_VALUE.invoke(null, nativePtrField.get(event),
                    MotionEvent.AXIS_Y, pointerIndex, historyCurrentField.get(null));
            return new Point((int)x, (int)y);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Method getNativeGetRawAxisValue() {
        for (Method method : MotionEvent.class.getDeclaredMethods()) {
            if (method.getName().equals("nativeGetRawAxisValue")) {
                method.setAccessible(true);
                return method;
            }
        }
        throw new RuntimeException("nativeGetRawAxisValue method not found.");
    }

    public void onOrientationChanged(AppConstants.ORIENTATION previousOrientation, AppConstants.ORIENTATION currentOrientation) {
        if(initialized && parentView != null){
            Camera defaultCamera = parentView.getDefaultCamera();
            if(defaultCamera != null && defaultCamera.getPosition().getPointAsDoubleArray() != null) {
                if (currentOrientation != AppConstants.ORIENTATION.UNDEFINED && currentOrientation != previousOrientation) {
                    if (setCameraRollForOrientationChange(previousOrientation.getOrientationInDeg(), currentOrientation.getOrientationInDeg())) {
                        Camera temp = getVtkCamera();
                        setVtkCamera(defaultCamera);
                        setCameraRollForOrientationChange(previousOrientation.getOrientationInDeg(), currentOrientation.getOrientationInDeg());
                        parentView.setDefaultCamera(getVtkCamera());
                        setVtkCamera(temp);
                        parentView.simulateFixedTouchEvent();
                    }
                }
            }
        }
    }

}
