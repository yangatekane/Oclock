package com.oclock.api;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by yanga on 2013/11/03.
 */
public interface BandService {
    @GET("/band")
    List<com.oclock.dto.Band> getBands();
}
