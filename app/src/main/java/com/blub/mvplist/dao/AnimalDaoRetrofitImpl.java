package com.blub.mvplist.dao;

import com.blub.mvplist.App;
import com.blub.mvplist.model.AnimalDto;
import com.blub.mvplist.retro.RetrofitRequests;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AnimalDaoRetrofitImpl implements AnimalDao {

    @Inject
    RetrofitRequests retrofitRequests;

    public void fetchAnimals(AnimalCallback callback) {
        App.getmAppComponent().inject(this);

        retrofitRequests.getAnimals().enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                List<AnimalDto> animalList = response.body().getmAnimalList();
                callback.onResponse(animalList);
            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}
