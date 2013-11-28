package com.oclock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


/**
 * Created by yanga on 2013/06/22.
 */
public class MapActivisty extends FragmentActivity {
    private GoogleMap mMap;
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
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap != null) {
            return;
        }

        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_freg)).getMap();
        if (mMap == null) {
            return;
        }
        // Initialize map options. For example:
         mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    private void loadMapCenter(Location location) {
        GoogleMap mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_freg)).getMap();
        CameraUpdate center =
                CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(),
                        location.getLongitude()));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                GoogleMap mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_freg)).getMap();
                return true;
            }
        });
        getPins(mMap.getCameraPosition());
        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                getPins(cameraPosition);
            }
        });
    }

    private void getPins(CameraPosition cameraPosition) {
        showLoadingPins();
        GoogleMap mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_freg)).getMap();
        float[] t = new float[100];
        Location.distanceBetween(cameraPosition.target.latitude, cameraPosition.target.longitude, mMap.getProjection().getVisibleRegion().farLeft.latitude, mMap.getProjection().getVisibleRegion().farLeft.longitude, t);
    }

    public void showLoadingPins() {
        TextView t = (TextView) findViewById(R.id.map_loading);
        t.setText("Loading Pins..");
        t.setVisibility(View.VISIBLE);
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