package com.blub.mvplist.retro;

import com.blub.mvplist.dao.AnimalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitRequests {

    @GET("/animals")
    Call<AnimalResponse> getAnimals();
}
