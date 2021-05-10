package com.subhadeep.AndroidApp.model.copy_files_data;

import android.content.Context;

import com.subhadeep.AndroidApp.utils.AppConstants;

import java.util.concurrent.CountDownLatch;


/**
 *
 * <h1> CopyThread </h1>
 *
 * <p> This class actually uses the {@link FileHandler} class to copy all the sample 3D models one by one to disk. </>
 * <p> It is launched by the {@link com.subhadeep.AndroidApp.model.CopyFilesService}. </>
 *
 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 *
 */

public class CopyFilesThread extends Thread{



    /**
     * This variable stores the {@link Context}.
     *
     */
    private Context context;

    /**
     * This variable stores the list of 3D models that will be copied to disk.
     *
     */
    private String fileList[];

    /**
     * This variable stores the {@link CountDownLatch} used to signal the caller that this thread has completed its goal.
     *
     */
    private CountDownLatch latch;


    /**
     * The default constructor.
     *
     * @param context is the application/activity {@link Context}.
     * @param fileList is the list of all important files present in the assets directory of the application.
     * @param latch is the object of {@link CountDownLatch} on which the caller is waiting.
     */
    public CopyFilesThread(Context context, String fileList[], CountDownLatch latch){
        this.context = context;
        this.fileList = fileList;
        this.latch = latch;
    }


    /**
     * <p> This function is automatically called when the thread is launched, and is used to copy 3D models from assets directory to disk. </>
     * <p> When all necessary files have been copied to disk, the {@link CountDownLatch} is released. </>
     * <p> This thread only copies files with extension: obj, stl and vtk. </>
     *
     */
    @Override
    public void run()
    {
        if(fileList != null) {
            for (int i = 0; i < fileList.length; i++)   {
                // Filenames are converted to lowercase before checking if they have extension of obj, stl or vtk.
                String temp = fileList[i].toLowerCase(AppConstants.DEFAULT_LOCALE);
                if(temp.endsWith(AppConstants.FORMAT3D.ATOBJ.toString()) ||
                        temp.endsWith(AppConstants.FORMAT3D.ATSTL.toString()) ||
                        temp.endsWith(AppConstants.FORMAT3D.ATVTK.toString())) {
                    FileHandler.copyAssetFileToStorage(context, fileList[i]);
                }
            }
        }
        // Once files have been copied the CountDownLatch is released.
        latch.countDown();
    }
}
