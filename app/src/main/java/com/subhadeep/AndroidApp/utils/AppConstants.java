package com.subhadeep.AndroidApp.utils;

import com.subhadeep.AndroidApp.view.Activity4_View3DModel;
import com.subhadeep.AndroidApp.view.activity4_extra.KiwiFragment;
import com.subhadeep.AndroidApp.view.activity4_extra.KiwiGLSurfaceView;

import java.util.Locale;

/**
 * <h1> AppUtils </h1>
 * <p> This class contains some definitions that may be put into use by the application. </>
 * <p> It contains some predefined important variables that are accessed by one or more classes belonging to the app. </>
 * <p> This class also defines the different file formats that can be used. </>
 * <p> Also, specifies the various screen orientations supported by the application. </>
 *
 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 */

public final class AppConstants {



    //Some default constants
    /**
     * This variable stores the default locale for the application and it is useful for String related operations.
     *
     */
    public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;



    //Application Settings so there are not final, may be changed
    /**
     * This boolean variable stores whether one or two 3D models are to be displayed.
     *
     */
    public static boolean TWO_MODELS = true;

    /**
     * <p> This variable defines whether models should be loaded in the same or separate windows. </>
     * <p> Thus it is particularly useful when the user wants two 3D models to be loaded. </>
     *
     */
    public static boolean OVERLAPPING_MODE = false;//true;//

    /**
     * <p> This variable defines whether the models should move synchronously. </>
     * <p> If this boolean variable is set to true, user input/ interactions are shared by the models. </>
     * <p> Thus it is particularly useful when the user wants two 3D models to be loaded. </>
     *
     */
    public static boolean SYNCHRONIZED_MOVEMENT_INIT = true;

    /**
     * <p> This variable stores the full path of the one of the chosen 3D models. </>
     * <p> Note that even thought this just stores just the filename for this version, it is replaced with the full path as the application executes. </>
     *
     */
    public static String CONTENT_FILE_ONE = "avatar.obj";//"modelo_left1.vtk";//

    /**
     * <p> This variable stores the opacity of the one of the chosen 3D models when loaded. </>
     * <p> Thus it is particularly useful when the user wants two overlapping 3D models to be loaded in the same windows. </>
     *
     */
    public static double OPACITY_FILE_ONE = 0.5;//1.0;

    /**
     * <p> This variable stores the position in 3D space of the one of the chosen 3D models when loaded. </>
     * <p> Thus it is particularly useful when the user wants two non-overlapping 3D models to be loaded in the same window. </>
     *
     */
    public static double POSITION_FILE_ONE[] = {0.0, 0.0, 0.0};

    /**
     * This variable stores the color of the one of the chosen 3D models when loaded.
     *
     */
    public static ColorCode.Color COLOR_FILE_ONE = ColorCode.Color.RED;//ColorCode.Color.WHITE;

    /**
     * This variable stores the color of the window background where one of the chosen 3D models would be loaded.
     *
     */
    public static ColorCode.Color BACKGROUND_COLOR_ONE = ColorCode.Color.YELLOW;//ColorCode.Color.WHITE;


    /**
     * <p> This variable stores the full path of the second chosen 3D model. </>
     * <p> Note that even thought this just stores just the filename for this version, it is replaced with the full path as the application executes. </>
     * <p> This variable is only used when the user wants two 3D models to be loaded. </>
     *
     */
    public static String CONTENT_FILE_TWO = "avatar.obj";//"modelo_right2.stl";//

    /**
     * <p> This variable stores the opacity of the second chosen 3D model when loaded. </>
     * <p> Thus it is particularly useful when the user wants two overlapping 3D models to be loaded in the same window. </>
     *
     */
    public static double OPACITY_FILE_TWO = 0.5;//1.0;

    /**
     * <p> This variable stores the position in 3D space of the second chosen 3D model when loaded. </>
     * <p> Thus it is particularly useful when the user wants two non-overlapping 3D models to be loaded in the same window. </>
     *
     */
    public static double POSITION_FILE_TWO[] = {0.0, 0.0, 0.0};

    /**
     * <p> This variable stores the color of the second chosen 3D model when loaded. </>
     * <p> This variable is only used when the user wants two 3D models to be loaded. </>
     *
     */
    public static ColorCode.Color COLOR_FILE_TWO = ColorCode.Color.BLUE;//ColorCode.Color.WHITE;

    /**
     * <p> This variable stores the color of the window background where the second chosen 3D model would be loaded. </>
     * <p> Thus it is particularly useful when the user wants two non-overlapping 3D models to be loaded in different windows. </>
     *
     */
    public static ColorCode.Color BACKGROUND_COLOR_TWO = ColorCode.Color.INDIANRED;//ColorCode.Color.WHITE;


    //Do not touch, these have been tried and tested
    /**
     * <p> This variable stores the number of times per second user input should be shared among windows if the models are to be displayed in a synchronous fashion. </>
     * <p> Only on receiving the shared user input, changes to the camera position is made which triggers the update of the GLSurafaceView. </>
     * <p> The value of 15 FPS has been tried and tested, lower values results in visually worse experience, while higher values degrades application performance. </>
     * <p> Note that this variable is particularly useful when the user wants two non-overlapping 3D models to be loaded in different windows. </>
     *
     */
    public static final int FPS = 15;

    /**
     * The definition of a second using milliseconds.
     *
     */
    public static final int MILLISECOND = 1000;

    /**
     * <p> This variable defines the integer value generated by Android when the user has just touched down on the screen. </>
     * <p> This value is Android specific. Please do not modify. </>
     *
     */
    public static final int TOUCH_ACTION_START = 0;

    /**
     * <p> This variable defines the integer value generated by Android when the user drags the finger to a particular direction, keeping it pressed on screen. </>
     * <p> This value is Android specific. Please do not modify. </>
     */
    public static final int TOUCH_ACTION_MOVE = 2;

    /**
     * <p> This variable defines the integer value generated by Android when the user has just released/ discontinued the touch gesture. </>
     * <p> This value is Android specific. Please do not modify. </>
     *
     */
    public static final int TOUCH_ACTION_END = 1;

    /**
     * <p> This boolean variable indicates whether absolute pointer position of touch is calculated or depends on MotionEvent.getX() and MotionEvent.getY()  </>
     * <p> By default we use absolute pointer position which causes less errors when two windows are used to display the two 3D models separately. </>
     * <p> DO NOT MODIFY.
     *
     */
    public static final boolean USE_RAW_POINTER_POSITION = true;


    //TAGS used in the application
    /**
     * <p> This variable stores the tag which should be used to query the name of the fragment. </>
     * <p> In this app we pass data to the {@link KiwiFragment} class from the {@link Activity4_View3DModel} class using a bundle. </>
     * <p> And this tag can be useful to retrieve the assigned name of the fragment from the data bundle. </>
     *
     */
    public static final String FRAGMENT_NAME_TAG = "FRAG-NAME";





    //other constants/names

    /**
     * <p> This variable stores the name of the first fragment. </>
     * <p> The application makes use of two different fragments, each housing one {@link KiwiGLSurfaceView} for displaying 3D models. </>
     * <p> And since sometimes we need to perform specific operation on just one of them, naming them allows us to distinguish between the two. </>
     *
     */
    public static final String FRAGMENT_ONE_NAME = "FRAGMENT-ONE";

    /**
     * <p> This variable stores the name of the second fragment. </>
     * <p> The application makes use of two different fragments, each housing one {@link KiwiGLSurfaceView} for displaying 3D models. </>
     * <p> And since sometimes we need to perform specific operation on just one of them, naming them allows us to distinguish between the two. </>
     *
     */
    public static final String FRAGMENT_TWO_NAME = "FRAGMENT-TWO";

    /**
     * <p> This variable stores the content of the message that is displayed, when the user requests for synchronized movement of models. </>
     * <p> It is only useful when there two different models have been loaded on screen and are displayed in the two different fragments. </>
     * <p> Activating the synchronized movement causes the camera to move in a similar manner for both the fragments. </>
     * <p> In other words, user gestures in one of {@link KiwiGLSurfaceView} is replicated in the other. </>
     *
     */
    public static final String TOAST_MESSAGE_SYNC = "Movement: Synchronized";

    /**
     * <p> This variable stores the content of the message that is displayed, when the user requests for non-synchronized movement of models. </>
     * <p> It is only useful when there two different models have been loaded on screen and are displayed in the two different fragments. </>
     * <p> Activating the non-synchronized movement causes the models in each of the fragment to only move when touched. </>
     * <p> In other words, user gestures in one of {@link KiwiGLSurfaceView} is NOT replicated in the other. </>
     *
     */
    public static final String TOAST_MESSAGE_UNSYNC = "Movement: Unsynchronized";

    /**
     * <p> This variable stores the content of the message that is displayed, when the user requests for a reset view of models. </>
     * <p> Activating reset causes the models in each of the fragment to positioned and enlarged as it was when the view was first launched, if they are synchronized. </>
     * <p> Reset action is NOT replicated in the other fragement, if models are not synchronized. </>
     *
     */
    public static final String TOAST_MESSAGE_RESET = "Reset 3DModel(s)";


    /**
     * <p> This variable stores the name of the service that copies to disk, the example 3d models supplied with the application. </>
     * <p> These models are displayed within the fragments for testing purposes, and may not be used in the release version. </>
     *
     */
    public static final String COPY_FILES = "KIWI_COPY_SERVICE";

    /**
     * <p> This variable stores the extension of the file on disk that houses the data stored by the application. </>
     * <p> The stored data is used to restore the previous state of the application on reopening. </>
     *
     */
    public static final String PREFERENCES_EXTENSION = ".xml";

    /**
     * This variable stores the relative path where the preference file is saved.
     *
     */
    public static final String PREFERENCES_DIR = "/shared_prefs/";

    /**
     * Default constructor.
     */
    public AppConstants() {
        //do nothing
    }


    /**
     * Defines the three different 3D file formats supported by the app, namely: VTK, STL and OBJ.
     */
    public enum FORMAT3D {
        /**
         * <p> AppConstant Type: Visualization Toolkit. </>
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "vtk" is returned. </>
         *
         */
        ATVTK{
            /**
             * Returns a string representation of ATVTK format.
             *
             * @return A {@link String} object containing "vtk".
             */
            public String toString() {
                return "vtk";
            }
        },

        /**
         * <p> AppConstant Type: Standard Triangle Language. </>
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "stl" is returned. </>
         */
        ATSTL{
            /**
             * Returns a string representation of ATSTL format.
             *
             * @return A {@link String} object containing "stl".
             */
            public String toString() {
                return "stl";
            }
        },

        /**
         * <p> AppConstant Type: Wavefront Object. </>
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "obj" is returned. </>
         */
        ATOBJ{
            /**
             * Returns a string representation of ATSTL format.
             *
             * @return A {@link String} object containing "obj".
             */
            public String toString() {
                return "obj";
            }
        }
    }




    /**
     * Defines the five supported orientation of the android device.
     */
    public enum ORIENTATION {

        /**
         * <p> This particular orientation has been assigned the value of -1, it signifies that the orientation is unknown. </>
         * <p> The orientation of the device is evaluated to be undefined or unknown when the value in angles returned by the sensor is within -1 to -1. </>
         * <p> Unknown orientation may represent cases when the device has been set down on a flat surface. </>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "-1" is returned. </>
         */
        UNDEFINED(-1, -1, -1){public String toString() {
            return "-1";
        }},

        /**
         * <p> This particular orientation has been assigned the value of 0, it signifies that the device is behind held vertically. </>
         * <p> The orientation of the device is evaluated to be ZERO when the value in angles returned by the sensor is within 315 to 45. </>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "0" is returned. </>
         */
        ZERO(0, 315, 45){ public String toString() {
            return "0";
        } },

        /**
         * <p> This particular orientation has been assigned the value of 90, it signifies that the device is behind held horizontally. </>
         * <p> The orientation of the device is evaluated to be NINETY when the value in angles returned by the sensor is within 45 to 135. </>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "90" is returned. </>
         */
        NINETY(90, 45, 135){ public String toString() {
            return "90";
        } },

        /**
         * <p> This particular orientation has been assigned the value of 180, it signifies that the device is being held vertically opposite to {@link #ZERO}. </>
         * <p> The orientation of the device is evaluated to be HUNDRED_EIGHTY when the value in angles returned by the sensor is within 135 to 225. </>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "180" is returned. </>
         */
        HUNDRED_EIGHTY(180, 135, 225){ public String toString() {
            return "180";
        } },

        /**
         * <p> This particular orientation has been assigned the value of 270, it signifies that the device is being held vertically opposite to {@link #NINETY}. </>
         * <p> The orientation of the device is evaluated to be TWO_SEVENTY when the value in angles returned by the sensor is within 225 to 315. </>
         *
         * <p> On calling method {@link #toString()} on this enum constant, the {@link String} value: "270" is returned. </>
         */
        TWO_SEVENTY(270, 225, 315){ public String toString() {
            return "270";
        } };



        /**
         * <p> This private variable stores the integer degree value denoting the orientation. </>
         * <p> Possible range values are -1, 0, 90, 180, and 270. </>
         *
         */
        private int orientation;

        /**
         * <p> This private variable stores the integer degree value denoting the lower bound for this particular orientation. </>
         * <p> Values from the orientation sensor are compared to this lower bound, and should be higher than the value stored in this variable if it belongs to this particular orientation. </>
         *
         */
        private int lowerLimit;

        /**
         * <p> This private variable stores the integer degree value denoting the upper bound for this particular orientation. </>
         * <p> Values from the orientation sensor are compared to this upper bound, and should be lower than or equal to the value stored in this variable if it belongs to this particular orientation. </>
         *
         */
        private int upperLimit;


        /**
         * The default constructor for this enum.
         *
         * @param orientation contains one of the four possible orientation values: -1, 0, 90, 180, and 270.
         * @param lowerLimit contains the lower bound value for a particular orientation. Possible values are: -1, 315, 45, 135, and 225 respectively.
         * @param upperLimit contains the upper bound value for a particular orientation. Possible values are: -1, 45, 135, 225, and 315 respectively.
         *
         */
        private ORIENTATION(int orientation, int lowerLimit, int upperLimit){
            this.orientation = orientation;
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        /**
         * This method return the a saved orientation value.
         *
         * @return An integer value in degrees corresponding to one of the five possible orientations: -1, 0, 90, 180, and 270.
         *
         */
        public int getOrientationInDeg(){
            return orientation;
        }

        /**
         * This method takes a value in degrees measured by the orientation sensor and groups it to one of five possible orientations.
         *
         * @param degree is the value generated by the orientation sensor in degrees.
         * @return An {@link ORIENTATION} enum object that defines an orientation evaluated from the supplied value from the orientation sensor.
         *
         */
        public static ORIENTATION findOrientation(double degree){
            if((degree > ZERO.lowerLimit && degree <= 360)||(degree >= 0 && degree <= ZERO.upperLimit)){
                return ZERO;
            }
            else if(degree > NINETY.lowerLimit && degree <= NINETY.upperLimit){
                return NINETY;
            }
            else if(degree > HUNDRED_EIGHTY.lowerLimit && degree <= HUNDRED_EIGHTY.upperLimit){
                return HUNDRED_EIGHTY;
            }
            else if(degree > TWO_SEVENTY.lowerLimit && degree <= TWO_SEVENTY.upperLimit){
                return TWO_SEVENTY;
            }
            else{
                return UNDEFINED;
            }
        }
    }

}



