package com.blub.mvplist.Animals;

import com.blub.mvplist.Animals.view.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder mainActivity(MainActivity mainActivity);

        MainActivityComponent build();
    }
}
