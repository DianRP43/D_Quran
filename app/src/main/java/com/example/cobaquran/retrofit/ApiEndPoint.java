package com.example.cobaquran.retrofit;

import com.example.cobaquran.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("data.json?print=pretty")
        Call<List<MainModel.Result>> getData();
}

