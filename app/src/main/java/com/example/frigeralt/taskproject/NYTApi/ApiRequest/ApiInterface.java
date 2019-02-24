package com.example.frigeralt.taskproject.NYTApi.ApiRequest;

import com.example.frigeralt.taskproject.NYTApi.APIData.ArticleData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("emailed/{selection}.json")
    Call<ArticleData> loadEmailed(@Path("selection") int selection, @Query("api-key") String apiKey);

    @GET("viewed/{selection}.json")
    Call<ArticleData> loadViewed(@Path("selection") int selection, @Query("api-key") String apiKey);

    @GET("shared/{selection}/facebook.json")
    Call<ArticleData> loadShared(@Path("selection") int selection, @Query("api-key") String apiKey);

}
