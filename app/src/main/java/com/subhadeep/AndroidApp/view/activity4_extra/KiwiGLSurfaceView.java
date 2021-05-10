
package com.subhadeep.AndroidApp.view.activity4_extra;


import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.KeyEvent;
import android.content.Context;
import android.view.MotionEvent;
import android.util.AttributeSet;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;


import com.subhadeep.AndroidApp.model.fragment_data.Camera;
import com.subhadeep.AndroidApp.model.settings_data.Window;
import com.subhadeep.AndroidApp.utils.AppConstants;
import com.subhadeep.AndroidApp.R;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;


public class KiwiGLSurfaceView extends GLSurfaceView implements KiwiGLSurfaceViewInterface {

    private Camera defaultCamera;
    private Camera restoreCamera;


    private KiwiFragment kiwiFragment;
    private KiwiRenderer mRenderer = null;
    private GestureDetector mGestureDetector;
    private long lastMovementBroadcastTime = 0;
    private static boolean translucentSurface = true;
    private static boolean sync_movement = AppConstants.SYNCHRONIZED_MOVEMENT_INIT;

    private static String TAG = "KiwiGLSurfaceView";
    private static final boolean DEBUG = false;

    private AppConstants.ORIENTATION orientation = AppConstants.ORIENTATION.ZERO;

    
    public KiwiGLSurfaceView(Context context) {
        super(context);
    }


    public KiwiGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(KiwiFragment kiwiFragment, Window window, AppConstants.ORIENTATION currentOrientation) {
        this.kiwiFragment = kiwiFragment;
        this.orientation = currentOrientation;
        //not saving EGLContextOnPause improves performance
        //this app implememts a mechanism to restore the objects when the view resumes
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(false);
        /* By default, GLSurfaceView() creates a RGB_565 opaque surface.
         * If we want a translucent one, we should change the surface's
         * format here, using PixelFormat.TRANSLUCENT for GL Surfaces
         * is interpreted as any 32-bit surface with alpha by SurfaceFlinger.
         */
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        setEGLContextFactory(new ContextFactory());

        /* We need to choose an EGLConfig that matches the format of
         * our surface exactly. This is going to be done in our
         * custom config chooser. See ConfigChooser class definition
         * below.
         */
        setEGLConfigChooser( translucentSurface ?
                new ConfigChooser(8, 8, 8, 8, 8, 0) :
                new ConfigChooser(5, 6, 5, 0, 8, 0) );

        mGestureDetector = new GestureDetector(getContext(), new MyGestureDetector());
        mRenderer = new KiwiRenderer(this, window);
        setRenderer(mRenderer);
        setRenderMode(RENDERMODE_WHEN_DIRTY);
    }

    public void setDefaultCamera(Camera camera){
        defaultCamera = camera;
    }

    public Camera getDefaultCamera(){
        return defaultCamera;
    }

    public void restorePreviousCameraSettings(){
        if (restoreCamera != null && mRenderer != null)
            mRenderer.setVtkCamera(restoreCamera);
    }


    public void onOrientationChanged(AppConstants.ORIENTATION previousOrientation, AppConstants.ORIENTATION currentOrientation) {
        if (mRenderer != null)
            mRenderer.onOrientationChanged(previousOrientation, currentOrientation);
        this.orientation = currentOrientation;
    }



    public void generateRestoreCamera(){
        Camera temp = null;
        if(mRenderer.isInitialized())
            temp = mRenderer.getVtkCamera();
        restoreCamera = temp;
    }


    public void queueEvent(Runnable r) {
        if (mRenderer.isInitialized())
            super.queueEvent(r);
        else
            mRenderer.queuePostInitEvent(r);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final MotionEvent fe = event;
        if(!mGestureDetector.onTouchEvent(fe)) {
            queueEvent(new Runnable() {
                public void run() {
                    try {
                        mRenderer.onMotionEvent(fe, AppConstants.USE_RAW_POINTER_POSITION);
                    } catch (Exception excep) {
                        Log.i("TAGG", "MyGestureDetector::onTouchEvent::Exception");
                    }
                }
            });
            //now broadcast the event if move together is selected and over some current event times
            if (sync_movement && (event.getAction() == AppConstants.TOUCH_ACTION_START || event.getAction() == AppConstants.TOUCH_ACTION_END)) {
                //Action is the first or the last action event thus NEEDS to be broadcasted without second thought
                broadcastTouchEvent();
                lastMovementBroadcastTime = System.currentTimeMillis();
            } else if (sync_movement && Math.abs(lastMovementBroadcastTime - System.currentTimeMillis()) > AppConstants.MILLISECOND / AppConstants.FPS) {
                //Action is not the first or last event, thus may be broadcasted depending on the required FPS
                broadcastTouchEvent();
                lastMovementBroadcastTime = System.currentTimeMillis();
            } else ;
        }
        return true;
    }

    public void broadcastTouchEvent() {
        if(mRenderer.isInitialized() && kiwiFragment != null)
            kiwiFragment.cameraChanged(mRenderer.getVtkCamera());
    }







    /*
    This function is used to simulate a touch event that moves the model slightly and sets it back to normal.
    Why is it necessary? Sometimes the screen is blacked out, this function helps bring back the image on screen.
     */
    public void simulateFixedTouchEvent()
    {
        // getWidth() and getHeight() returns the window size
        // here we have tried to use the center values for the window
        // note that this may not coincide with the absolute value of the center of the window
        // but this does not really matter in out case, this was done to avoid the use of fixed values
        final float xPosBegin = getWidth() / 2;
        final float yPosBegin = getHeight() / 2;
        final int idsBegin = 0; //0
        queueEvent(new Runnable() {
            public void run() {
                // finger down
                mRenderer.simulateTouchEvent(AppConstants.TOUCH_ACTION_START, xPosBegin, yPosBegin, idsBegin);
                // prepare to drag
                mRenderer.simulateTouchEvent(AppConstants.TOUCH_ACTION_MOVE, xPosBegin, yPosBegin, idsBegin);
                // drag to the next position (as little as possible to reduce vibrations)
                mRenderer.simulateTouchEvent(AppConstants.TOUCH_ACTION_MOVE, xPosBegin + Math.nextAfter(0.0f,1.0f),
                        yPosBegin + Math.nextAfter(0.0f,1.0f), idsBegin);
                // drag back to initial position
                mRenderer.simulateTouchEvent(AppConstants.TOUCH_ACTION_MOVE, xPosBegin, yPosBegin, idsBegin);
                // lift up finger
                mRenderer.simulateTouchEvent(AppConstants.TOUCH_ACTION_END, xPosBegin, yPosBegin, idsBegin);
            }
        });
        if(DEBUG) Log.i(TAG, "Simulate fixed touch event");
    }


    public void requestCameraToInitState() {
        if(mRenderer.isInitialized()) {
            mRenderer.setVtkCamera(defaultCamera);
            simulateFixedTouchEvent();
        }
    }

    public void setCamera(Camera camera) {
        if(mRenderer.isInitialized() && camera != null) {
            if(camera.getPosition() != null || camera.getPosition().getPointAsDoubleArray() != null) {
                try {
                    mRenderer.setVtkCamera(camera);
                    simulateFixedTouchEvent();
                } catch (Exception e) {
                }
            }
        }
    }





    // forward events to rendering thread for it to handle
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        final KeyEvent keyEvent = event;
        queueEvent(new Runnable() {
            public void run() {
                if (mRenderer != null)
                    mRenderer.onKeyEvent(false, keyEvent);
            }
        });
        return true;
    }

    // forward events to rendering thread for it to handle
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        final KeyEvent keyEvent = event;
        queueEvent(new Runnable() {
            public void run() {
                if (mRenderer != null)
                    mRenderer.onKeyEvent(true, keyEvent);}
        });
        return true;
    }



    private class MyGestureDetector extends SimpleOnGestureListener {

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (kiwiFragment != null) {
                Log.i("TAGG", "PENDIENTE::MyGestureDetector::KiwiNative.handleDoubleTap");
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.toast_custom, findViewById(R.id.custom_toast_container));
                TextView text = layout.findViewById(R.id.textToast);
                text.setText(AppConstants.TOAST_MESSAGE_RESET);
                text.setRotation(0 - orientation.getOrientationInDeg());
                Toast toast = new Toast(getContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();

                requestCameraToInitState();
                kiwiFragment.broadcastResetModelSignal();
            }

            return true;
        }

        public void onLongPress(MotionEvent e) {
            if (kiwiFragment != null) {
                sync_movement = !sync_movement; //flip the values
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.toast_custom, findViewById(R.id.custom_toast_container));
                TextView text = layout.findViewById(R.id.textToast);
                if (sync_movement) {
                    text.setText(AppConstants.TOAST_MESSAGE_SYNC);
                } else {
                    text.setText(AppConstants.TOAST_MESSAGE_UNSYNC);
                }
                text.setRotation(0 - orientation.getOrientationInDeg());

                Toast toast = new Toast(getContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();

                kiwiFragment.toggleSynchronization();
            }
        }

        public boolean onSingleTapConfirmed(MotionEvent e) { return false; }

    }


    //-------------------------------------------------------------------
    //private static class ContextFactory
    //-------------------------------------------------------------------
    private static class ContextFactory implements EGLContextFactory {

        private static int EGL_CONTEXT_CLIENT_VERSION = 0x3098;

        public EGLContext createContext(EGL10 egl, EGLDisplay display, EGLConfig eglConfig) {
            //Log.w(TAG, "creating OpenGL ES 2.0 context");
            checkEglError("Before eglCreateContext", egl);
            int[] attrib_list = {EGL_CONTEXT_CLIENT_VERSION, 2, EGL10.EGL_NONE };
            //int[] attrib_list = {EGL_CONTEXT_CLIENT_VERSION, 3, EGL10.EGL_NONE };
            EGLContext context = egl.eglCreateContext(display, eglConfig, EGL10.EGL_NO_CONTEXT, attrib_list);
            checkEglError("After eglCreateContext", egl);
            return context;
        }

        public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context) {
            egl.eglDestroyContext(display, context);
        }

        private static void checkEglError(String prompt, EGL10 egl) {
            int error;
            while ((error = egl.eglGetError()) != EGL10.EGL_SUCCESS) {
                Log.e(TAG, String.format("%s: EGL error: 0x%x", prompt, error));
            }
        }
    }
    //-----------------------------------------------------------------







    //------------------------------------------------------------------------
    //private static class ConfigChooser
    //------------------------------------------------------------------------
    private static class ConfigChooser implements EGLConfigChooser {

        public ConfigChooser(int r, int g, int b, int a, int depth, int stencil) {
            mRedSize = r;
            mGreenSize = g;
            mBlueSize = b;
            mAlphaSize = a;
            mDepthSize = depth;
            mStencilSize = stencil;
        }

        /* This EGL config specification is used to specify 2.0 rendering.
         * We use a minimum size of 4 bits for red/green/blue, but will
         * perform actual matching in chooseConfig() below.
         */
        private static int EGL_OPENGL_ES2_BIT = 4;
        private static int[] s_configAttribs2 =
                {
                        EGL10.EGL_RED_SIZE, 4,
                        EGL10.EGL_GREEN_SIZE, 4,
                        EGL10.EGL_BLUE_SIZE, 4,
                        EGL10.EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT,
                        EGL10.EGL_NONE
                };

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {

            /* Get the number of minimally matching EGL configurations
             */
            int[] num_config = new int[1];
            egl.eglChooseConfig(display, s_configAttribs2, null, 0, num_config);

            int numConfigs = num_config[0];

            if (numConfigs <= 0)
                throw new IllegalArgumentException("No configs match configSpec");

            /* Allocate then read the array of minimally matching EGL configs
             */
            EGLConfig[] configs = new EGLConfig[numConfigs];
            egl.eglChooseConfig(display, s_configAttribs2, configs, numConfigs, num_config);

            if (DEBUG)
                printConfigs(egl, display, configs);
            /* Now return the "best" one
             */
            return chooseConfig(egl, display, configs);
        }



        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
            for(EGLConfig config : configs) {
                int d = findConfigAttrib(egl, display, config,
                        EGL10.EGL_DEPTH_SIZE, 0);
                int s = findConfigAttrib(egl, display, config,
                        EGL10.EGL_STENCIL_SIZE, 0);

                // We need at least mDepthSize and mStencilSize bits
                if (d < mDepthSize || s < mStencilSize)
                    continue;

                // We want an *exact* match for red/green/blue/alpha
                int r = findConfigAttrib(egl, display, config,
                        EGL10.EGL_RED_SIZE, 0);
                int g = findConfigAttrib(egl, display, config,
                        EGL10.EGL_GREEN_SIZE, 0);
                int b = findConfigAttrib(egl, display, config,
                        EGL10.EGL_BLUE_SIZE, 0);
                int a = findConfigAttrib(egl, display, config,
                        EGL10.EGL_ALPHA_SIZE, 0);

                if (r == mRedSize && g == mGreenSize && b == mBlueSize && a == mAlphaSize) {
                    printConfig(egl, display, config);
                    return config;
                }
            }
            return null;
        }


        private int findConfigAttrib(EGL10 egl, EGLDisplay display, EGLConfig config, int attribute, int defaultValue) {
            if (egl.eglGetConfigAttrib(display, config, attribute, mValue))
                return mValue[0];
            return defaultValue;
        }


        private void printConfigs(EGL10 egl, EGLDisplay display, EGLConfig[] configs) {
            int numConfigs = configs.length;
            Log.w(TAG, String.format("%d configurations", numConfigs));
            for (int i = 0; i < numConfigs; i++) {
                Log.w(TAG, String.format("Configuration %d:\n", i));
                printConfig(egl, display, configs[i]);
            }
        }


        private void printConfig(EGL10 egl, EGLDisplay display, EGLConfig config) {
            int[] attributes = {
                    EGL10.EGL_BUFFER_SIZE,
                    EGL10.EGL_ALPHA_SIZE,
                    EGL10.EGL_BLUE_SIZE,
                    EGL10.EGL_GREEN_SIZE,
                    EGL10.EGL_RED_SIZE,
                    EGL10.EGL_DEPTH_SIZE,
                    EGL10.EGL_STENCIL_SIZE,
                    EGL10.EGL_CONFIG_CAVEAT,
                    EGL10.EGL_CONFIG_ID,
                    EGL10.EGL_LEVEL,
                    EGL10.EGL_MAX_PBUFFER_HEIGHT,
                    EGL10.EGL_MAX_PBUFFER_PIXELS,
                    EGL10.EGL_MAX_PBUFFER_WIDTH,
                    EGL10.EGL_NATIVE_RENDERABLE,
                    EGL10.EGL_NATIVE_VISUAL_ID,
                    EGL10.EGL_NATIVE_VISUAL_TYPE,
                    0x3030, // EGL10.EGL_PRESERVED_RESOURCES,
                    EGL10.EGL_SAMPLES,
                    EGL10.EGL_SAMPLE_BUFFERS,
                    EGL10.EGL_SURFACE_TYPE,
                    EGL10.EGL_TRANSPARENT_TYPE,
                    EGL10.EGL_TRANSPARENT_RED_VALUE,
                    EGL10.EGL_TRANSPARENT_GREEN_VALUE,
                    EGL10.EGL_TRANSPARENT_BLUE_VALUE,
                    0x3039, // EGL10.EGL_BIND_TO_TEXTURE_RGB,
                    0x303A, // EGL10.EGL_BIND_TO_TEXTURE_RGBA,
                    0x303B, // EGL10.EGL_MIN_SWAP_INTERVAL,
                    0x303C, // EGL10.EGL_MAX_SWAP_INTERVAL,
                    EGL10.EGL_LUMINANCE_SIZE,
                    EGL10.EGL_ALPHA_MASK_SIZE,
                    EGL10.EGL_COLOR_BUFFER_TYPE,
                    EGL10.EGL_RENDERABLE_TYPE,
                    0x3042 // EGL10.EGL_CONFORMANT
            };
            String[] names = {
                    "EGL_BUFFER_SIZE",
                    "EGL_ALPHA_SIZE",
                    "EGL_BLUE_SIZE",
                    "EGL_GREEN_SIZE",
                    "EGL_RED_SIZE",
                    "EGL_DEPTH_SIZE",
                    "EGL_STENCIL_SIZE",
                    "EGL_CONFIG_CAVEAT",
                    "EGL_CONFIG_ID",
                    "EGL_LEVEL",
                    "EGL_MAX_PBUFFER_HEIGHT",
                    "EGL_MAX_PBUFFER_PIXELS",
                    "EGL_MAX_PBUFFER_WIDTH",
                    "EGL_NATIVE_RENDERABLE",
                    "EGL_NATIVE_VISUAL_ID",
                    "EGL_NATIVE_VISUAL_TYPE",
                    "EGL_PRESERVED_RESOURCES",
                    "EGL_SAMPLES",
                    "EGL_SAMPLE_BUFFERS",
                    "EGL_SURFACE_TYPE",
                    "EGL_TRANSPARENT_TYPE",
                    "EGL_TRANSPARENT_RED_VALUE",
                    "EGL_TRANSPARENT_GREEN_VALUE",
                    "EGL_TRANSPARENT_BLUE_VALUE",
                    "EGL_BIND_TO_TEXTURE_RGB",
                    "EGL_BIND_TO_TEXTURE_RGBA",
                    "EGL_MIN_SWAP_INTERVAL",
                    "EGL_MAX_SWAP_INTERVAL",
                    "EGL_LUMINANCE_SIZE",
                    "EGL_ALPHA_MASK_SIZE",
                    "EGL_COLOR_BUFFER_TYPE",
                    "EGL_RENDERABLE_TYPE",
                    "EGL_CONFORMANT"
            };
            int[] value = new int[1];
            for (int i = 0; i < attributes.length; i++) {
                int attribute = attributes[i];
                String name = names[i];
                if ( egl.eglGetConfigAttrib(display, config, attribute, value)) {
                    Log.w(TAG, String.format("  %s: %d\n", name, value[0]));
                }
                else {
                    // Log.w(TAG, String.format("  %s: failed\n", name));
                    while (egl.eglGetError() != EGL10.EGL_SUCCESS);
                }
            }
        }

        // Subclasses can adjust these values:
        protected int mRedSize;
        protected int mGreenSize;
        protected int mBlueSize;
        protected int mAlphaSize;
        protected int mDepthSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];
    }
    //-------------------------------------------

}




