package com.blub.mvplist.dao;

import com.blub.mvplist.model.AnimalDto;
import com.squareup.moshi.Json;

import java.util.List;

public class AnimalResponse {

    @Json(name = "animal_list")
    private List<AnimalDto> mAnimalList;

    public AnimalResponse(List<AnimalDto> mAnimalList) {
        this.mAnimalList = mAnimalList;
    }

    public List<AnimalDto> getmAnimalList() {
        return mAnimalList;
    }
}
