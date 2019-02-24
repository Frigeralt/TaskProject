package com.example.frigeralt.taskproject.NYTApi.ApiRequest;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.frigeralt.taskproject.NYTApi.APIData.ArticleData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Singleton controller to work with api
 */

public class Controller implements Callback<ArticleData> {
    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/";
    private static final String API_KEY = "3Q3hQJ19CXrTlFwysRLAqCAxkiG5T1au";
    public static final int SELECTION = 30;

    private ArticleData serverResponse;

    private static Controller instance;

    public static synchronized Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    private Controller() {
    }


    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface gerritAPI = retrofit.create(ApiInterface.class);
        Call<ArticleData> call = gerritAPI.loadEmailed(SELECTION, API_KEY);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<ArticleData> call, Response<ArticleData> response) {
        if (response.isSuccessful()) {
            serverResponse = response.body();
        } else {
            Log.i("FAILDER RESPONSE", response.message());
        }
    }

    @Override
    public void onFailure(Call<ArticleData> call, Throwable t) {
        Log.i("Failed call", t.getLocalizedMessage());
    }
}
