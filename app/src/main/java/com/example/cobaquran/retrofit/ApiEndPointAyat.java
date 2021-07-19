package com.example.cobaquran.retrofit;

import com.example.cobaquran.MainModel;
import com.example.cobaquran.ModelAyat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiEndPointAyat {

    @GET
    Call<List<ModelAyat.ResultAyat>> getData(@Url String url);
}
