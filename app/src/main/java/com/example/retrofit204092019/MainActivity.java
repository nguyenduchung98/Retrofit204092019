package com.example.retrofit204092019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bước 1: khởi tạo Retrofit

        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://khoapham.vn/KhoaPhamTraining/json/tien/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Bước 2 : Tạo ra interface call api ava hứng dữ liệu
        ApiResponse apiResponse =retrofit.create(ApiResponse.class);
        //Bước 3: Gọi Api và nhận dữ liệu từ trong call back
        Call<Demo1> callBackDemo1 = apiResponse.getDemo1();

        callBackDemo1.enqueue(new Callback<Demo1>() {
            @Override
            public void onResponse(Call<Demo1> call, Response<Demo1> response) {
               Demo1 demo1 = response.body();
                Log.d("BBB",demo1.getMonhoc());
            }

            @Override
            public void onFailure(Call<Demo1> call, Throwable t) {

            }
        });
    }
}
