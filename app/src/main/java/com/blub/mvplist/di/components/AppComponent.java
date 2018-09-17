package com.blub.mvplist.di.components;

import android.app.Application;

import com.blub.mvplist.App;
import com.blub.mvplist.dao.AnimalDaoRetrofitImpl;
import com.blub.mvplist.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NetModule.class})
public interface AppComponent {

    void inject(App app);

    void inject(AnimalDaoRetrofitImpl animalDao);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        Builder netModule(NetModule netModule);

        AppComponent build();
    }
}
