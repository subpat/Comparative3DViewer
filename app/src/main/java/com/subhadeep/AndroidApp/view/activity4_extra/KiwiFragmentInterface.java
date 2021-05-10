package com.subhadeep.AndroidApp.view.activity4_extra;

import com.subhadeep.AndroidApp.model.fragment_data.Camera;

public interface KiwiFragmentInterface {

    void toggleSynchronization() ; // used to notify the fragment is the user has chosen to syn model movements.
    void broadcastResetModelSignal(); // used to notify if the used wants to reset the 3d model.
    void cameraChanged(Camera camera); // used to notify the fragment of any changes in the camera params.
}
