package com.blub.mvplist.Animals;

import com.blub.mvplist.Animals.dao.AnimalDao;
import com.blub.mvplist.Animals.dao.AnimalDaoRetrofitImpl;
import com.blub.mvplist.Animals.view.MainActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    private MainActivity mMainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Provides
    @Singleton
    AnimalDao provideAnimalDao() {
        return new AnimalDaoRetrofitImpl();
    }

    @Provides
    @Singleton
    AnimalPresenter provideAnimalPresenter(AnimalDao animalDao) {
        return new AnimalPresenter(mMainActivity, animalDao);
    }
}
