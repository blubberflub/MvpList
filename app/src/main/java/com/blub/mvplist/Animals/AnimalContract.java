package com.blub.mvplist.Animals;

import com.blub.mvplist.Animals.model.AnimalDto;

import java.util.List;

public interface AnimalContract {

    interface View {
        void showAnimalList(List<AnimalDto> animalList);

        void showError(String message);
    }

    interface Presenter {
        void openedAnimalList();
    }
}
