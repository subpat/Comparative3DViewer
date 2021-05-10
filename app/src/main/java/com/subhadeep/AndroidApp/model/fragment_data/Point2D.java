package com.subhadeep.AndroidApp.model.fragment_data;


/**
 * <h1> Point2D </h1>
 *
 * <p> Even though we are working with 3D models displayed in 3D space, sometimes we still need to use 2D coordinates, this class becomes useful in those cases. </>
 * <p> Example use of this class can be in positioning android view objects on screen, read user touch events from screen, in these cases a point is expressed in 2D coordinates. </>
 *
 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 */



public class Point2D {

    /**
     * This private variable of length 2, stores the x and y-coordinate of a 2D point.
     *
     */
    private double xy[];

    /**
     * <p> This a constructor without parameters which sets the point to undefined. </>
     * <p> Using this constructor to create an object requires calling of functions {@link #setX(double)} and {@link #setY(double)} or similar functions later. </>
     *
     */
    public Point2D(){
        xy = null;
    }


    /**
     * This constructor is used to create a 2D point using values contained in the array supplied.
     *
     * @param array is a double array of length 2, where the first and the second elements denote the x-axis and y-axis values respectively.
     */
    public Point2D(double array[]){
        setPoint(array);
    }


    /**
     * This constructor is used to create an object of this class that represents a point in 2D space.
     *
     * @param x is a double value that denotes the x-coordinate of a point.
     * @param y is a double value that denotes the y-coordinate of a point.
     */
    public Point2D(double x, double y){
        xy = new double[]{x, y};
    }


    /**
     * This method is used to set the x-coordinate of this point.
     *
     * @param x is a double value that denotes the x-coordinate of this point.
     */
    public void setX(double x){
        if(xy == null){
            xy = new double[2];
        }
        xy[0] = x;
    }



    /**
     * This method is used to set the y-coordinate of this point.
     *
     * @param y is a double value that denotes the y-coordinate of this point.
     */
    public void setY(double y){
        if(xy == null){
            xy = new double[2];
        }
        xy[1] = y;
    }


    /**
     * This method is used to set the x-coordinate and y-coordinate of a 2D point represented by an object of this class.
     *
     * @param array is a double array of length 2, where the first and the second elements denotes the x-axis and y-axis values respectively.
     */
    public void setPoint(double array[]){
        if(array.length == 2){
            xy = array;
        }
    }


    /**
     * This method is used to set the x-coordinate and y-coordinate of a 2D point represented by an object of this class.
     *
     * @param x is the x-coordinate of a point in 2D space.
     * @param y is the y-coordinate of a point in 2D space.
     */
    public void setPoint(double x, double y){
        setX(x);
        setY(y);
    }


    /**
     * This method is used to retrieve the x-coordinate of this point.
     *
     * @return A double value representing x-coordinate of this point if it was previously defined, else returns null.
     * @throws NullPointerException
     */
    public double getX() throws NullPointerException{
        if(xy == null){
            throw new NullPointerException("x-coordinate undefined!");
        }
        else {
            return xy[0];
        }
    }


    /**
     * This method is used to retrieve the y-coordinate of this point.
     *
     * @return A double value representing y-coordinate of this point if it was previously defined, else returns null.
     * @throws NullPointerException
     */
    public double getY() throws NullPointerException{
        if(xy == null){
            throw new NullPointerException("y-coordinate undefined!");
        }
        else {
            return xy[1];
        }
    }


    /**
     *  This method is used to retrieve the x and y-coordinate of this point.
     *
     * @return Null if the point was not defined, else a double array of length 2 is returned, where the first element represents the x-axis and the second represents the y-axis of the point.
     */
    public double[] getPointAsDoubleArray(){
        return xy;
    }
}
