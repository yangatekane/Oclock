package com.oclock;

import android.app.Application;

import com.oclock.api.Remote;

/**
 * Created by yanga on 2013/08/11.
 */
public class OApplication extends Application {
    private Remote remote;
    public OApplication() {
        //remote = new Remote(OApplication.this);
    }

    public Remote getRemote() {
        return remote;
    }
}
