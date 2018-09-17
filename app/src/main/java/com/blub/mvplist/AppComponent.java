package com.blub.mvplist;

import android.app.Application;

import com.blub.mvplist.Animals.dao.AnimalDaoRetrofitImpl;

import javax.inject.Named;
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

        @BindsInstance
        @Named("base_url")
        Builder baseUrl(String baseUrl);

        Builder netModule(NetModule netModule);

        AppComponent build();
    }
}
