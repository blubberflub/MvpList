package com.blub.mvplist.Animals;

import com.blub.mvplist.Animals.dao.AnimalDao;
import com.blub.mvplist.Animals.model.AnimalDto;

import java.util.List;

public class AnimalPresenter implements AnimalContract.Presenter {
    private AnimalContract.View mAnimalView;
    private AnimalDao mAnimalDao;

    public AnimalPresenter(AnimalContract.View animalView,
                           AnimalDao animalDao) {
        mAnimalView = animalView;
        mAnimalDao = animalDao;
    }

    @Override
    public void openedAnimalList() {
        mAnimalDao.fetchAnimals(animalResponseCallback);
    }

    private AnimalDao.AnimalCallback animalResponseCallback = new AnimalDao.AnimalCallback() {
        @Override
        public void onResponse(List<AnimalDto> animalList) {
            mAnimalView.showAnimalList(animalList);
        }

        @Override
        public void onFailure(String message) {
            mAnimalView.showError(message);
        }
    };
}
