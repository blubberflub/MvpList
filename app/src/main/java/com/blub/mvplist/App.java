package com.blub.mvplist;

import android.app.Application;

public class App extends Application {

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .application(this)
                .netModule(new NetModule(UrlConstants.MOCK_URL))
                .build();

        mAppComponent.inject(this);
    }

    public static AppComponent getmAppComponent() {
        return mAppComponent;
    }
}
