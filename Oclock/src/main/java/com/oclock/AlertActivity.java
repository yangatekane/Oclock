package com.oclock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by yanga on 2013/06/20.
 */
public class AlertActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_activity);
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
                startActivity(new Intent(AlertActivity.this,HomeActivity.class));
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
}