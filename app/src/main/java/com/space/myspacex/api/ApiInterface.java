package com.space.myspacex.api;

import com.space.myspacex.model.MasterJson;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("latest")
    Call<MasterJson> getDetails();
}