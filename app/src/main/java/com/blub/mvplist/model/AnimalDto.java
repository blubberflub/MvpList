package com.blub.mvplist.model;

import com.squareup.moshi.Json;

public class AnimalDto {

    @Json(name = "name")
    String mName;
    @Json(name = "sound")
    String mSound;

    public AnimalDto(String name, String sound) {
        mName = name;
        mSound = sound;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getSound() {
        return mSound;
    }

    public void setSound(String sound) {
        this.mSound = sound;
    }
}
