package com.example.retrofit204092019;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {

    private static Retrofit retrofit = null;
    private RetrofitInit(){

    }
    public static ApiResponse getInStance(){
        if(retrofit == null){
            retrofit = initRetrofit();
        }
        return retrofit.create(ApiResponse.class);
    }

    private static Retrofit initRetrofit() {

        // Công cụ convert dữ liệu json sang java objedt
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        // OkhttpClient : setup connection
        OkHttpClient okHttpClient =new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
       // Khởi tạo Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://khoapham.vn/KhoaPhamTraining/json/tien/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}
