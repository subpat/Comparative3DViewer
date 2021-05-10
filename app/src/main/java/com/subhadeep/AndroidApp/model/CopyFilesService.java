package com.subhadeep.AndroidApp.model;


import android.util.Log;
import android.content.Intent;
import android.app.IntentService;

import com.subhadeep.AndroidApp.utils.AppConstants;
import com.subhadeep.AndroidApp.model.copy_files_data.CopyFilesThread;
import com.subhadeep.AndroidApp.model.copy_files_data.CopyState;

import java.util.concurrent.CountDownLatch;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;


/**
 *
 * <h1> CopyService </h1>
 *
 * <p> This class is used to launch an {@link IntentService} to copy all the sample 3D models to disk. </>
 * <p> It uses a separate thread for operation, thus does not freeze the UI. </>
 *
 * @author  Subhadeep Patra
 * @version 1.0
 * @since   2019-01-15
 *
 */

public class CopyFilesService extends IntentService {



    /**
     * This variable should be set to true, if console debug messages related to this class are desired.
     *
     */
    private final boolean debug = false;

    /**
     * This variable stores the tag of the debug messages generated by this class.
     *
     */
    private final String debugTag = "Utils::CopyService";


    private static PublishSubject<CopyState> copyStatePublishSubject = PublishSubject.create();;


    /**
     * This is the default and only constructor of this class.
     *
     */
    public CopyFilesService() {
        super(AppConstants.COPY_FILES);
        copyStatePublishSubject.onNext(CopyState.COPYING);
    }



    /**
     * <p> This function is automatically called by the Android OS when the service is started. </>
     * <p> This function launches a new thread called {@link CopyFilesThread}, to copy all the sample 3D models provided with the app. </>
     * <p> After all files have been copied, this service sends a broadcast signal to the calling activity, and stops itself. </>
     * <p> It should be made sure that the calling activity is active and receives the broadcast message. </>
     *
     * @param intent is the intent using which this service is launched.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        if(debug)   Log.i(debugTag, "\tonStartCommand()");
        CountDownLatch latch = new CountDownLatch(1);
        try {
            //getAssets().list("") return the list of all files in the assets directory.
            new CopyFilesThread(this, getAssets().list(""), latch).start(); //
            latch.await();
        }catch(Exception e) {}

        copyStatePublishSubject.onNext(CopyState.COMPLETE);

        this.stopSelf();
    }

    public static Observable<CopyState> getObservableCopyState(){
        return copyStatePublishSubject;
    }

    /**
     * <p> This function is automatically called by the Android OS when the service is stopped. </>
     * <p> At the moment we take no action in this function. Should be removed at a later stage. </>
     *
     */
    @Override
    public void onDestroy() {
        if(debug)   Log.i(debugTag, "\tonDestroy()");
        super.onDestroy();
    }
}
