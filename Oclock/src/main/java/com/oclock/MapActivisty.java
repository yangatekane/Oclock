package com.oclock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Created by yanga on 2013/06/22.
 */
public class MapActivisty extends Activity {
    //rivate GoogleMap mMap;
    public static final int ACTIVITY_REQUEST_NETWORKING = 0x100;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(MapActivisty.this,HomeActivity.class));
                finish();
                break;
            case R.id.action_settings:
                break;
            case R.id.home_action_bar_latest_diagnostics:
                break;
            case R.id.home_action_bar_reports:
                break;
            case R.id.home_action_bar_location:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
       // if (mMap != null) {
            //return;
        //}

        //mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        //if (mMap == null) {
            return;
        //}
        // Initialize map options. For example:
        // mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public void visitNetworkSettings() {
        Intent intent = new Intent(
                android.provider.Settings.ACTION_WIRELESS_SETTINGS);
        startActivityForResult(intent, ACTIVITY_REQUEST_NETWORKING);
    }
}