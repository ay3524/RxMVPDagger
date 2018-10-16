package com.ay3524.rxmvpdagger.data.network;

import com.ay3524.rxmvpdagger.ui.home.pojo.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoints {

    @GET("api/")
    Call<Example> getUserDetails(@Query("key") String apiKey,
                                 @Query("order") String order);
}
