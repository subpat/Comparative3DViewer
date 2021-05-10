package com.subhadeep.AndroidApp.model.settings_data;

import com.subhadeep.AndroidApp.model.fragment_data.Point3D;
import com.subhadeep.AndroidApp.utils.ColorCode;



/**
 * <h1> Window </h1>
 *
 * <p> An object of this class is used to store all the information about the window displaying 3D model(s). </>
 * <p> Note that on the same screen you could have multiple loaded windows, and within each window, you could have up to two models loaded. </>
 * <p> An object of this class holds information of one such window, thus multiple objects of this class is to be created when more than one window is displayed on screen. </>
 *
 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 */



public class Window {


    /**
     * This {@link String} variable is used to store the name of the window which is used to identify it.
     *
     */
    private String name;


    /**
     * This variable is used to store an enum constant of type {@link ColorCode.Color}, used to generate the background colour of the window.
     *
     */
    private ColorCode.Color background;


    /**
     * This variable holds an object of the class {@link ThreeDModel} which stores different properties of a 3D model to be displayed.
     *
     */
    private ThreeDModel modelOne;


    /**
     * This variable holds an object of the class {@link ThreeDModel} which stores different properties of the second 3D model, if any.
     *
     */
    private ThreeDModel modelTwo;


    /**
     * <p> This a constructor without parameters which sets all global variables of this class to null. </>
     * <p> Using this constructor to create an object requires calling of functions {@link #setName(String)}, {@link #setBackground(ColorCode.Color)}, and {@link #setModelOne(ThreeDModel)} at least or similar functions later. </>
     *
     */
    public Window(){
        name = null;
        background = null;
        modelOne = null;
        modelTwo = null;
    }


    /**
     * This constructor is used to create an object of this class with the help of the parameters passed.
     *
     * @param name is the {@link String} name of this object.
     * @param background
     * @param model
     */
    public Window(String name, ColorCode.Color background, ThreeDModel model){
        this.name = name;
        this.background = background;
        this.modelOne = model;
        this.modelTwo = null;
    }

    public Window(String name, ColorCode.Color background, ThreeDModel modelOne, ThreeDModel modelTwo){
        this.name = name;
        this.background = background;
        this.modelOne = modelOne;
        this.modelTwo = modelTwo;
    }

    public Window(String name, ColorCode.Color background,
                  String fileOnePath, double fileOneOpacity, ColorCode.Color fileOneColor, Point3D fileOnePosition,
                  String fileTwoPath, double fileTwoOpacity, ColorCode.Color fileTwoColor, Point3D fileTwoPosition){
        this.name = name;
        this.background = background;
        this.modelOne = new ThreeDModel(fileOnePath, fileOneOpacity, fileOneColor, fileOnePosition);
        this.modelTwo = new ThreeDModel(fileTwoPath, fileTwoOpacity, fileTwoColor, fileTwoPosition);
    }

    public Window(String name, ColorCode.Color background,
                  String fileOnePath, double fileOneOpacity, ColorCode.Color fileOneColor, double fileOne_x, double fileOne_y, double fileOne_z,
                  String fileTwoPath, double fileTwoOpacity, ColorCode.Color fileTwoColor, double fileTwo_x, double fileTwo_y, double fileTwo_z){
        this.name = name;
        this.background = background;
        this.modelOne = new ThreeDModel(fileOnePath, fileOneOpacity, fileOneColor, fileOne_x, fileOne_y, fileOne_z);
        this.modelTwo = new ThreeDModel(fileTwoPath, fileTwoOpacity, fileTwoColor, fileTwo_x, fileTwo_y, fileTwo_z);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBackground(ColorCode.Color background){
        this.background = background;
    }

    public void setModelOne(ThreeDModel modelOne){
        this.modelOne = modelOne;
    }

    public void setModelOne(String filePath, double opacity, ColorCode.Color color, Point3D position){
        this.modelOne = new ThreeDModel(filePath, opacity, color, position);
    }

    public void setModelOne(String filePath, double opacity, ColorCode.Color color, double position_x, double position_y, double position_z){
        this.modelOne = new ThreeDModel(filePath, opacity, color, position_x, position_y, position_z);
    }

    public void setModelTwo(ThreeDModel modelTwo){
        this.modelTwo = modelTwo;
    }

    public void setModelTwo(String filePath, double opacity, ColorCode.Color color, Point3D position){
        this.modelTwo = new ThreeDModel(filePath, opacity, color, position);
    }

    public void setModelTwo(String filePath, double opacity, ColorCode.Color color, double position_x, double position_y, double position_z){
        this.modelTwo = new ThreeDModel(filePath, opacity, color, position_x, position_y, position_z);
    }

    public String getName(){
        return name;
    }

    public ColorCode.Color getBackground(){
        return background;
    }

    public ThreeDModel getModelOne(){
        return modelOne;
    }

    public ThreeDModel getModelTwo(){
        return modelTwo;
    }

    public ThreeDModel[] getModelsAsArray(){
        ThreeDModel[] temp = null;
        if(modelOne == null && modelTwo == null){
            return null;
        }
        else if(modelOne == null || modelTwo == null){
            if(modelOne != null){
                temp = new ThreeDModel[]{modelOne};
            }
            else{
                temp = new ThreeDModel[]{modelTwo};
            }
        }
        else{
            temp = new ThreeDModel[]{modelOne, modelTwo};
        }
        return temp;
    }

    public String[] getModelsPath(){
        String[] temp = null;
        if(modelOne == null && modelTwo == null){
            return null;
        }
        else if(modelOne == null || modelTwo == null){
            if(modelOne != null){
                temp = new String[]{modelOne.getFilePath()};
            }
            else{
                temp = new String[]{modelTwo.getFilePath()};
            }
        }
        else{
            temp = new String[]{modelOne.getFilePath(), modelTwo.getFilePath()};
        }
        return temp;
    }

    public double[] getModelsOpacity(){
        double[] temp = null;
        if(modelOne == null && modelTwo == null){
            return null;
        }
        else if(modelOne == null || modelTwo == null){
            if(modelOne != null){
                temp = new double[]{modelOne.getOpacity()};
            }
            else{
                temp = new double[]{modelTwo.getOpacity()};
            }
        }
        else{
            temp = new double[]{modelOne.getOpacity(), modelTwo.getOpacity()};
        }
        return temp;
    }

    public ColorCode.Color[] getModelsColor(){
        ColorCode.Color[] temp = null;
        if(modelOne == null && modelTwo == null){
            return null;
        }
        else if(modelOne == null || modelTwo == null){
            if(modelOne != null){
                temp = new ColorCode.Color[]{modelOne.getColor()};
            }
            else{
                temp = new ColorCode.Color[]{modelTwo.getColor()};
            }
        }
        else{
            temp = new ColorCode.Color[]{modelOne.getColor(), modelTwo.getColor()};
        }
        return temp;
    }

    public Point3D[] getModelsPosition(){
        Point3D[] temp = null;
        if(modelOne == null && modelTwo == null){
            return null;
        }
        else if(modelOne == null || modelTwo == null){
            if(modelOne != null){
                temp = new Point3D[]{modelOne.getPosition()};
            }
            else{
                temp = new Point3D[]{modelTwo.getPosition()};
            }
        }
        else{
            temp = new Point3D[]{modelOne.getPosition(), modelTwo.getPosition()};
        }
        return temp;
    }

    public double[][] getModelsPositionAsDoubleMatrix(){
        double[][] temp = null;
        if(modelOne == null && modelTwo == null){
            return null;
        }
        else if(modelOne == null || modelTwo == null){
            if(modelOne != null){
                temp = new double[][]{modelOne.getPositionAsDoubleArray()};
            }
            else{
                temp = new double[][]{modelTwo.getPositionAsDoubleArray()};
            }
        }
        else{
            temp = new double[][]{modelOne.getPositionAsDoubleArray(), modelTwo.getPositionAsDoubleArray()};
        }
        return temp;
    }
}
