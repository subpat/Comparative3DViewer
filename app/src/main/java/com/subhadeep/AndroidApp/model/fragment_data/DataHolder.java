package com.subhadeep.AndroidApp.model.fragment_data;


/**
 * <h1> DataHolder </h1>
 *
 * <p> This class is used to store, modify and return objects of other classes. </>
 * <p> The class is useful when an inner class need to modify an object declared in the outer class. </>
 * <p> An example use of this class is in cases where a {@link Thread} is used to operate on values, in such cases the changes are not always saved. </>
 * <p> In such case, this class can hold an object of any class and changes are made to the object by the {@link Thread}. </>
 *
 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 */


public class DataHolder<T> {

    /**
     * This variable stores the object of a class.
     *
     */
    private T data;



    /**
     * This is the default constructor of the class, requires a parameter.
     *
     * @param data is an object of any class.
     */
    public DataHolder(T data){
        setValue(data);
    }



    /**
     * This method is used to change the object that this class holds.
     *
     * @param data is the new object to be stored.
     */
    public void setValue(T data) {
        this.data = data;
    }



    /**
     * This method is used to retrieve the object that this class is holding.
     *
     * @return The object being stored.
     */
    public T getValue(){
        return data;
    }
}
