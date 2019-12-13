package com.example.retrofit204092019;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiResponse {

    @GET("demo1.json")
    Call<Demo1> getDemo1();
    @GET("demo2.json")
    Call<Demo2> getDemo2();
}
