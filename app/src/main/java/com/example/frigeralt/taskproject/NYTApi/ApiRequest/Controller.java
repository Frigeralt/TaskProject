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

public class Controller implements Callback<ArticleData> {
    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/";
    private static final String API_KEY = "3Q3hQJ19CXrTlFwysRLAqCAxkiG5T1au";
    public static final int SELECTION = 30;

    private ArticleData response;
    private Context context;

    public Controller(Context context) {
        this.context = context;
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

    public ArticleData getResponse() {
        return response;
    }

    @Override
    public void onResponse(Call<ArticleData> call, Response<ArticleData> response) {
        if (response.isSuccessful()) {
            this.response = response.body();

        } else {
            Toast.makeText(context, "Http request error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<ArticleData> call, Throwable t) {
        Log.i("Failed call", t.getLocalizedMessage());
    }
}
