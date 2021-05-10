package com.subhadeep.AndroidApp.model.fragment_data;


/**
 * <h1> Camera </h1>
 *
 * <p> This class defines the various parameters of the camera that projects the 3D model on screen. </>
 * <p> Objects of this class may be shared between windows or stored locally for later replication of the defined parameters. </>
 *
 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 */

public class Camera {

    /**
     * This variable stores the position of the camera in 3D space.
     *
     */
    private Point3D position;

    /**
     * This variable stores the focal point of the camera in 3D space.
     *
     */
    private Point3D focus;

    /**
     * This variable stores the point in 3D space towards which the top of the camera is pointed.
     *
     */
    private Point3D viewUp;



    /**
     * This basic constructor of the Camera class is used to create an object, setting its global parameters to null.
     *
     */
    public Camera(){
        this.position = null;
        this.focus = null;
        this.viewUp = null;
    }

    /**
     * This basic constructor of the Camera class is used to create an object, setting its global parameters to null.
     *
     */
    public Camera(Camera camera){
        this.position = camera.getPosition();
        this.focus = camera.getFocus();
        this.viewUp = camera.getViewUp();
    }


    /**
     * This constructor creates an object of this class using the data supplied.
     * All data supplied to this constructor are of the type {@link Point3D}.
     *
     * @param position is the position of the camera in 3D space, expressed using an object of the {@link Point3D} class.
     * @param focus is the position of the focal point of the camera in 3D space, expressed using an object of the {@link Point3D} class.
     * @param viewUp is a point in 3D space towards which the top of the camera is positioned, expressed using an object of the {@link Point3D} class.
     */
    public Camera(Point3D position, Point3D focus, Point3D viewUp){
        this.position = position;
        this.focus = focus;
        this.viewUp = viewUp;
    }


    /**
     * This constructor creates an object of this class using the data supplied.
     * All data supplied to this constructor are of the type double.
     *
     * @param position_x is the value of the x axis of a point in 3D space corresponding to the position of the camera.
     * @param position_y is the value of the y axis of a point in 3D space corresponding to the position of the camera.
     * @param position_z is the value of the z axis of a point in 3D space corresponding to the position of the camera.
     * @param focus_x is the value of the x axis of a point in 3D space corresponding to the focal point of the camera.
     * @param focus_y is the value of the y axis of a point in 3D space corresponding to the focal point of the camera.
     * @param focus_z is the value of the z axis of a point in 3D space corresponding to the focal point of the camera.
     * @param viewUp_x is the value of the x axis of a point in 3D space towards which the top of the camera is pointed.
     * @param viewUp_y is the value of the y axis of a point in 3D space towards which the top of the camera is pointed.
     * @param viewUp_z is the value of the z axis of a point in 3D space towards which the top of the camera is pointed.
     */
    public Camera(double position_x, double position_y, double position_z,
                  double focus_x, double focus_y, double focus_z,
                  double viewUp_x, double viewUp_y, double viewUp_z){
        this.position = new Point3D(position_x, position_y, position_z);
        this.focus = new Point3D(focus_x, focus_y, focus_z);
        this.viewUp = new Point3D(viewUp_x, viewUp_y, viewUp_z);
    }


    /**
     * This function is used to set the position of the camera using a {@link Point3D} object.
     * It is specially useful when the object of this class has been created using {@link #Camera()} without any parameters.
     *
     * @param position is an object of the {@link Point3D} class that defines the position of the camera in 3D space.
     */
    public void setPosition(Point3D position){
        this.position = position;
    }


    /**
     * This function is used to set the position of the camera using the passed double values.
     * It is specially useful when the object of this class has been created using {@link #Camera()} without any parameters.
     *
     * @param x is the value of the x axis of a point in 3D space corresponding to the position of the camera.
     * @param y is the value of the y axis of a point in 3D space corresponding to the position of the camera.
     * @param z is the value of the z axis of a point in 3D space corresponding to the position of the camera.
     */
    public void setPosition(double x, double y, double z){
        this.position = new Point3D(x, y, z);
    }


    /**
     * This function is used to set the focal point of the camera in 3D space, using a {@link Point3D} object.
     * It is specially useful when the object of this class has been created using {@link #Camera()} without any parameters.
     *
     * @param focus is an object of the {@link Point3D} class that defines the focal point of the camera in 3D space.
     */
    public void setFocus(Point3D focus){
        this.focus = focus;
    }


    /**
     * This function is used to set the focal point of the camera in 3D space, making use of supplied double values.
     * It is specially useful when the object of this class has been created using {@link #Camera()} without any parameters.
     *
     * @param x is the value of the x axis of a point in 3D space corresponding to the focal point of the camera.
     * @param y is the value of the y axis of a point in 3D space corresponding to the focal point of the camera.
     * @param z is the value of the z axis of a point in 3D space corresponding to the focal point of the camera.
     */
    public void setFocus(double x, double y, double z){
        this.focus = new Point3D(x, y, z);
    }


    /**
     * This function is used to set the point in 3D space towards the which the top of the camera is pointed, using a {@link Point3D} object.
     * It is specially useful when the object of this class has been created using {@link #Camera()} without any parameters.
     *
     * @param viewUp is a point in 3D space towards which the top of the camera is positioned, expressed using an object of the {@link Point3D} class.
     */
    public void setViewUp(Point3D viewUp){
        this.viewUp = viewUp;
    }


    /**
     * This function is used to set the point in 3D space towards the which the top of the camera is pointed, using supplied double values.
     * It is specially useful when the object of this class has been created using {@link #Camera()} without any parameters.
     *
     * @param x is the value of the x axis of a point in 3D space towards which the top of the camera is pointed.
     * @param y is the value of the y axis of a point in 3D space towards which the top of the camera is pointed.
     * @param z is the value of the z axis of a point in 3D space towards which the top of the camera is pointed.
     */
    public void setViewUp(double x, double y, double z){
        this.viewUp = new Point3D(x, y, z);
    }



    /**
     * This function is used to query the position of the camera in 3D space.
     *
     * @return An object of the {@link Point3D} class denoting the position of the camera.
     */
    public Point3D getPosition(){
        return position;
    }



    /**
     * This function is used to query the position of the camera in 3D space.
     *
     * @return A double array of length 3, containing the x, y, z values of a point in 3D space denoting the position of the camera.
     */
    public double[] getPositionAsDoubleArray(){
        return position.getPointAsDoubleArray();
    }



    /**
     * This function is used to query the point in 3D space denoting the focal point of the camera.
     *
     * @return An object of the {@link Point3D} class representing the focal point of the camera.
     */
    public Point3D getFocus(){
        return focus;
    }



    /**
     * This function is used to query the point in 3D space denoting the focal point of the camera.
     *
     * @return A double array of length 3, containing the x, y, z values of a point in 3D space representing the focal point of the camera.
     */
    public double[] getFocusAsDoubleArray(){
        return focus.getPointAsDoubleArray();
    }


    /**
     * This function is used to query the point in 3D space towards the which the top of the camera is pointed.
     *
     * @return An object of the {@link Point3D} class representing the point in 3D space towards the which the top of the camera is pointed.
     */
    public Point3D getViewUp(){
        return viewUp;
    }



    /**
     * This function is used to query the point in 3D space towards the which the top of the camera is pointed.
     *
     * @return A double array of length 3, containing the x, y, z values of the point in 3D space towards the which the top of the camera is pointed.
     */
    public double[] getViewUpAsDoubleArray(){
        return viewUp.getPointAsDoubleArray();
    }

}
