package com.subhadeep.AndroidApp.model.settings_data;


import java.io.File;

import com.subhadeep.AndroidApp.model.fragment_data.Point3D;
import com.subhadeep.AndroidApp.utils.ColorCode;


/**
 * <h1> ThreeDModel </h1>
 *
 * <p> This class is used to store the properties of the 3D model to be displayed with the help of <a href="https://vtk.org/" target="_blank">VTK</a>. </>
 * <p> Includes properties like file to be loaded, the requested opacity, colour, and position in 3D coordinates. </>
 * <p> Note that different properties should be set before the 3D model is loaded on screen. </>
 *
 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 */



public class ThreeDModel {

    /**
     * This variable stores the absolute path with filename and extension of the file containing the 3D model.
     *
     */
    private String filePath;

    /**
     * This variable stores the desired amount of opacity to be applied on loading the 3D model.
     *
     */
    private double opacity;

    /**
     * This variable stores an enum constant of type {@link ColorCode.Color} that defines the desired colour of the 3D model.
     *
     */
    private ColorCode.Color color;

    /**
     * This variable store an object of the {@link Point3D} class that describes the location of the model in 3D space when it is loaded.
     *
     */
    private Point3D position;



    /**
     * <p> This is a constructor of this class that takes in no parameters, thus creates an object with default values. </p>
     * <p> Default values include: setting a null file path, opacity to 1, colour of model to white, and position at (0,0,0). </p>
     * <p> If an object is created with this constructor, at least the file path has to be set later using the method: {@link #setFilePath(String)}. </p>
     *
     */
    public ThreeDModel(){
        filePath = null;
        opacity = 1.0;
        color = ColorCode.Color.WHITE;
        position = new Point3D(0,0,0);
    }



    /**
     * <p> This is a constructor of this class thus creates an object using the supplied parameters. </p>
     *
     * @param filePath is the absolute path with filename and extension of the file containing the 3D model.
     * @param opacity is the required opacity of the model.
     * @param color is an enum constant of type {@link ColorCode.Color}, describing the colour of the 3D model.
     * @param position is an object of the {@link Point3D} class representing the position of the model in 3D space.
     */
    public ThreeDModel(String filePath, double opacity, ColorCode.Color color, Point3D position){
        this.filePath = filePath;
        this.opacity = opacity;
        this.color = color;
        this.position = position;
    }



    /**
     * <p> This is a constructor of this class thus creates an object using the supplied parameters. </p>
     *
     * @param filePath is the absolute path with filename and extension of the file containing the 3D model.
     * @param opacity is the required opacity of the model.
     * @param color is an enum constant of type {@link ColorCode.Color}, describing the colour of the 3D model.
     * @param position_x is the value of x-axis of point where the 3D model is positioned.
     * @param position_y is the value of y-axis of point where the 3D model is positioned.
     * @param position_z is the value of z-axis of point where the 3D model is positioned.
     */
    public ThreeDModel(String filePath, double opacity, ColorCode.Color color, double position_x, double position_y, double position_z){
        this.filePath = filePath;
        this.opacity = opacity;
        this.color = color;
        this.position = new Point3D(position_x, position_y, position_z);
    }


    /**
     * This method is used to the set the absolute path of the file which contains the 3D model.
     *
     * @param filePath is the absolute path with the filename and extension of the file.
     */
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }


    /**
     * <p> This method is used to set the opacity of the 3D model. </p>
     * <p> Note this is opposite of transparency, thus possible values should be within 0 (completely transparent) to 1 (completely opaque). </p>
     *
     * @param opacity is the double value indicating the opacity of the displayed 3D model.
     */
    public void setOpacity(double opacity){
        this.opacity = opacity;
    }


    /**
     * This method is used to set the colour of the 3D model on display.
     *
     * @param color is an enum constant thus forces the selection of a predefined colour from {@link ColorCode.Color}.
     */
    public void setColor(ColorCode.Color color){
        this.color = color;
    }


    /**
     * This method is used to set the position of the model in 3D space.
     *
     * @param position is an object of the {@link Point3D} class containing the position information.
     */
    public void setPosition(Point3D position) {
        this.position = position;
    }


    /**
     * This method is used to set the position of the model in 3D space.
     *
     * @param position is a double array of length 3, containing the x, y, and z axis values of a point in 3D space that represents the position of the model.
     */
    public void setPosition(double position[]) {
        this.position = new Point3D(position);
    }


    /**
     * This method is used to set the position of the model in 3D space.
     *
     * @param x is the value of the x-coordinate of a point in 3D space that represents the position of the model.
     * @param y is the value of the y-coordinate of a point in 3D space that represents the position of the model.
     * @param z is the value of the z-coordinate of a point in 3D space that represents the position of the model.
     */
    public void setPosition(double x, double y, double z) {
        this.position = new Point3D(x, y, z);
    }


    /**
     * This method is used to retrieve only the name of the file on disk that contains the 3D model.
     *
     * @return A {@link String} object containing the filename with extension.
     */
    public String getFileName(){
        return filePath.substring(filePath.lastIndexOf(File.separator) + 1);
    }


    /**
     * This method is used to retrieve the absolute path along with the filename of the file on disk that contains the 3D model.
     *
     * @return A {@link String} object containing absolute path and the filename with extension.
     */
    public String getFilePath(){
        return filePath;
    }


    /**
     * This method is used to retrieve the opacity of the 3D model.
     *
     * @return A double value representing the opacity of the displayed 3D model.
     */
    public double getOpacity(){
        return opacity;
    }



    /**
     * This method is used to retrieve the colour of the 3D model.
     *
     * @return An enum constant of type {@link ColorCode.Color} that represents the colour of the 3D model.
     */
    public ColorCode.Color getColor(){
        return color;
    }



    /**
     * This method is used to retrieve the position of the model in 3D space.
     *
     * @return An object of the {@link Point3D} class that represents the position of the model.
     */
    public Point3D getPosition(){
        return position;
    }



    /**
     * This method is used to retrieve the position of the model in 3D space.
     *
     * @return An array of double of length 3, containing the x, y, z axis values of a point in 3D space that represents the position of the model.
     */
    public double[] getPositionAsDoubleArray(){
        return position.getPointAsDoubleArray();
    }
}
