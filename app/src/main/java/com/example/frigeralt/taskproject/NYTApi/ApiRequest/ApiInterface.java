package com.example.frigeralt.taskproject.NYTApi.ApiRequest;

import com.example.frigeralt.taskproject.NYTApi.APIData.ApiResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("emailed/{selection}.json")
    Call<List<ApiResult>> loadEmailed(@Query("api-key") String apiKey, @Path("selection") int selection);

    @GET("viewed/{selection}.json")
    Call<List<ApiResult>> loadViewed(@Query("api-key") String apiKey, @Path("selection") int selection);

    @GET("shared/{selection}/facebook.json")
    Call<List<ApiResult>> loadShared(@Query("api-key") String apiKey, @Path("selection") int selection);

}
