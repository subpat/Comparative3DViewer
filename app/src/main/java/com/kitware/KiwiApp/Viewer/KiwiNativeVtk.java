

package com.kitware.KiwiApp.Viewer;

public class KiwiNativeVtk {

     static {
         System.loadLibrary("KiwiNativeVtk");
     }

     public static native synchronized long init(int width, int height, double r, double g, double b);
     public static native synchronized void resize(long udp, int width, int height);
     public static native synchronized void render(long udp);
     public static native synchronized void loaddataset(long udp, String file);

     public static native synchronized void loaddatasetcol(long udp, String file, double r, double g, double b);

     public static native synchronized void loaddatasetstl(long udp, String file);
     public static native synchronized void loaddatasetobj(long udp, String file);
     public static native synchronized void resetCamera(long udp);
     public static native synchronized void setCameraPosition(long udp, double x, double y, double z);
     public static native synchronized void setCameraViewUp(long udp, double x, double y, double z);
     public static native synchronized void setCameraFocalPoint(long udp, double x, double y, double z);

     public static native synchronized void setBackground(long udp, double r, double g, double b);

     public static native synchronized void onKeyEvent(long udp, boolean down, int keyCode,
                                          int metaState,
                                          int repeatCount);

     public static native synchronized void onMotionEvent(long udp,
                                             int action,
                                             int eventPointer,
                                             int numPtrs,
                                             float [] xPos, float [] yPos, int [] ids,
                                             int metaState);

     public static native synchronized void rotateCameraAzimuth(long udp, double angle);

     public static native synchronized double[] getCameraPosition(long udp);
     public static native synchronized double[] getCameraViewUp(long udp);
     public static native synchronized double[] getCameraFocalPoint(long udp);

     public static native synchronized double getCameraRoll(long udp);
     public static native synchronized void setCameraRoll(long udp, double angle);

     public static native synchronized void loadMultipleModels(long udp, String files[], double rgb[][], double opacity[], double position[][]);
}
