package com.subhadeep.AndroidApp.model.fragment_data;

public class ToggleSyncData {

    private boolean sync;
    private String fragmentName;

    public ToggleSyncData (String fragmentName, boolean bool) {
        this.sync = bool;
        this.fragmentName = fragmentName;
    }

    public boolean getData() {
        return sync;
    }

    public String getFragmentName() { return fragmentName; }
}
