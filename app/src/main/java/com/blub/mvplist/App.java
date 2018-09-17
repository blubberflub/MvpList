package com.blub.mvplist;

import android.app.Application;

import com.blub.mvplist.di.components.AppComponent;
import com.blub.mvplist.di.components.DaggerAppComponent;
import com.blub.mvplist.di.modules.NetModule;

public class App extends Application {

    private static AppComponent mAppComponent;

    private static final String MOCK_URL = "https://73d67115-309d-4ee6-9e25-f40b6c691e2b.mock.pstmn.io";

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .application(this)
                .netModule(new NetModule(MOCK_URL))
                .build();

        mAppComponent.inject(this);
    }

    public static AppComponent getmAppComponent() {
        return mAppComponent;
    }
}
