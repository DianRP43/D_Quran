package com.dian.dquran.retrofit;

import com.dian.dquran.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("data.json?print=pretty")
        Call<List<MainModel.Result>> getData();
}

