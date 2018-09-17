package com.blub.mvplist.di.components;

import com.blub.mvplist.di.modules.MainActivityModule;
import com.blub.mvplist.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
