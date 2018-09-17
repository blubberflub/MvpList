package com.blub.mvplist.dao;

import com.blub.mvplist.model.AnimalDto;

import java.util.List;

public interface AnimalDao {

    void fetchAnimals(AnimalCallback callback);

    interface AnimalCallback {
        void onResponse(List<AnimalDto> animalList);

        void onFailure(String message);
    }
}

