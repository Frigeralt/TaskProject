package com.example.frigeralt.taskproject.NYTApi.ApiRequest;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/";
    private static final String API_KEY ="3Q3hQJ19CXrTlFwysRLAqCAxkiG5T1au";


    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface gerritAPI = retrofit.create(ApiInterface.class);

        /**
         * TODO get and parse api respond
         */


    }
}
