package com.blub.mvplist;

import com.blub.mvplist.model.AnimalDto;

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
