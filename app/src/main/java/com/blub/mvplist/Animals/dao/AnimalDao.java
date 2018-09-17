package com.blub.mvplist.Animals.dao;

import com.blub.mvplist.Animals.model.AnimalDto;

import java.util.List;

public interface AnimalDao {

    void fetchAnimals(AnimalCallback callback);

    interface AnimalCallback {
        void onResponse(List<AnimalDto> animalList);

        void onFailure(String message);
    }
}

