package com.example.retrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @GET("everything/")
    Call<String> getEveryNews(@QueryMap HashMap<String, Object> queries);
}