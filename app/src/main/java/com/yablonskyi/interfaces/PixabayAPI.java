package com.yablonskyi.interfaces;

import com.yablonskyi.model.PhotoList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface PixabayAPI {
    @Headers("Content-Type: application/json")
    @GET("?key=10244829-d76a55838507315ac17f6ff2c&pretty=true")
    Call<PhotoList> getData();
}
