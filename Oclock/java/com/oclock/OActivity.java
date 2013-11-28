package com.oclock;

import android.app.Activity;
import android.os.Bundle;

import com.oclock.api.Remote;

/**
 * Created by yanga on 2013/11/04.
 */
public class OActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Remote getRemote(){
        return ((OApplication) getApplicationContext()).getRemote();
    }
}