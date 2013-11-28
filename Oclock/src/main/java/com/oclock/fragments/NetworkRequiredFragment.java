package com.oclock.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.oclock.MapActivisty;
import com.oclock.R;

public class NetworkRequiredFragment extends DialogFragment {
	MapActivisty activity;
    protected NetworkRequiredFragment networkRequiredFragment;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity =  (MapActivisty) activity;
	}
    public void showNetworkRequiredDialog() {
        if (networkRequiredFragment == null)
            networkRequiredFragment = new NetworkRequiredFragment();

        //networkRequiredFragment.show(getSupportFragmentManager(), "dialog");
    }
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.network_required, null);

		Button bookclubNetworkSettingsButton = (Button) view
				.findViewById(R.id.NetworkSettingsButton);
		bookclubNetworkSettingsButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				activity.visitNetworkSettings();
				dismiss();
			}
		});

		return view;
	}
}
