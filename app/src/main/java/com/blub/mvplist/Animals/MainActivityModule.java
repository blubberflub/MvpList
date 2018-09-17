package com.blub.mvplist.Animals;

import com.blub.mvplist.Animals.dao.AnimalDao;
import com.blub.mvplist.Animals.dao.AnimalDaoRetrofitImpl;
import com.blub.mvplist.Animals.view.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    @Singleton
    AnimalDao provideAnimalDao() {
        return new AnimalDaoRetrofitImpl();
    }

    @Provides
    @Singleton
    AnimalPresenter provideAnimalPresenter(MainActivity mainActivity, AnimalDao animalDao) {
        return new AnimalPresenter(mainActivity, animalDao);
    }
}
