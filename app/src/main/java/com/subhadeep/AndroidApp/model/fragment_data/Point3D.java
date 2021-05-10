package com.subhadeep.AndroidApp.model.fragment_data;


/**
 * <h1> Point3D </h1>
 *
 * <p> This application displays 3D models in 3D space, thus we need to use 3D coordinates to define the position of the model and the camera in 3D space. </>
 *
 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 */



public class Point3D {

    /**
     * This private variable of length 3, stores the x, y and z-coordinate of a 3D point.
     *
     */
    private double xyz[];



    /**
     * <p> This a constructor without parameters which sets the point to undefined. </>
     * <p> Using this constructor to create an object requires calling of functions {@link #setX(double)}, {@link #setY(double)}, and {@link #setZ(double)} or similar functions later. </>
     *
     */
    public Point3D(){
        xyz = null;
    }



    /**
     * This constructor is used to create a 3D point using values contained in the array supplied.
     *
     * @param array is a double array of length 3, where the first, second, and the third elements denote the x-axis, y-axis, and z-axis values respectively.
     */
    public Point3D(double array[]){
         setPoint(array);
    }



    /**
     * This constructor is used to create an object of this class that represents a point in 3D space.
     *
     * @param x is a double value that denotes the x-coordinate of a point.
     * @param y is a double value that denotes the y-coordinate of a point.
     * @param z is a double value that denotes the z-coordinate of a point.
     */
    public Point3D(double x, double y, double z){
        xyz = new double[]{x, y, z};
    }



    /**
     * This method is used to set the x-coordinate of this point.
     *
     * @param x is a double value that denotes the x-coordinate of this point.
     */
    public void setX(double x){
        if(xyz == null){
            xyz = new double[3];
        }
        xyz[0] = x;
    }



    /**
     * This method is used to set the y-coordinate of this point.
     *
     * @param y is a double value that denotes the y-coordinate of this point.
     */
    public void setY(double y){
        if(xyz == null){
            xyz = new double[3];
        }
        xyz[1] = y;
    }



    /**
     * This method is used to set the z-coordinate of this point.
     *
     * @param z is a double value that denotes the z-coordinate of this point.
     */
    public void setZ(double z){
        if(xyz == null){
            xyz = new double[3];
        }
        xyz[2] = z;
    }



    /**
     * This method is used to set the x, y, and z-coordinate of a 3D point represented by an object of this class.
     *
     * @param array is a double array of length 3, where the first, second, and the third elements denote the x-axis, y-axis, and z-axis values respectively.
     */
    public void setPoint(double array[]){
        if(array.length == 3){
            xyz = array;
        }
    }



    /**
     * This method is used to set the x, y, and z-coordinate of a 3D point represented by an object of this class.
     *
     * @param x is the x-coordinate of a point in 3D space.
     * @param y is the y-coordinate of a point in 3D space.
     * @param z is the z-coordinate of a point in 3D space.
     */
    public void setPoint(double x, double y, double z){
        setX(x);
        setY(y);
        setZ(z);
    }


    /**
     * This method is used to retrieve the x-coordinate of this point.
     *
     * @return A double value representing x-coordinate of this point if it was previously defined, else returns null.
     * @throws NullPointerException
     */
    public double getX() throws NullPointerException{
        if(xyz == null){
            throw new NullPointerException("x-coordinate undefined!");
        }
        else {
            return xyz[0];
        }
    }


    /**
     * This method is used to retrieve the y-coordinate of this point.
     *
     * @return A double value representing y-coordinate of this point if it was previously defined, else returns null.
     * @throws NullPointerException
     */
    public double getY() throws NullPointerException{
        if(xyz == null){
            throw new NullPointerException("y-coordinate undefined!");
        }
        else {
            return xyz[1];
        }
    }


    /**
     * This method is used to retrieve the z-coordinate of this point.
     *
     * @return A double value representing z-coordinate of this point if it was previously defined, else returns null.
     * @throws NullPointerException
     */
    public double getZ() throws NullPointerException{
        if(xyz == null){
            throw new NullPointerException("z-coordinate undefined!");
        }
        else {
            return xyz[2];
        }
    }


    /**
     *  This method is used to retrieve the x, y, and z-coordinate of this point.
     *
     * @return Null if the point was not defined, else a double array of length 3 is returned, which contains value of the x, y, and z-axis of the point.
     */
    public double[] getPointAsDoubleArray(){
        return xyz;
    }
}
