package com.oclock.api;

import android.content.Context;

import com.oclock.BuildConfig;
import com.oclock.OApplication;
import com.oclock.R;
import com.oclock.exceptions.ApiException;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by yanga on 2013/11/03.
 */

public class Remote {
    private Context context;
    private BandService bandService;

    public Remote(OApplication context) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setServer(context.getString(R.string.band_api))
                .setErrorHandler(new ErrorHandler() {
                    @Override
                    public Throwable handleError(RetrofitError e) {

                        return new ApiException(e);
                    }
                }).build();
        bandService = restAdapter.create(BandService.class);
    }

    public BandService getBandService() {
        return bandService;
    }
}
