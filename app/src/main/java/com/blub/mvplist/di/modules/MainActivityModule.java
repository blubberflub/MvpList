package com.blub.mvplist.di.modules;

import com.blub.mvplist.AnimalPresenter;
import com.blub.mvplist.dao.AnimalDao;
import com.blub.mvplist.dao.AnimalDaoRetrofitImpl;
import com.blub.mvplist.view.MainActivity;

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
