package com.blub.mvplist.di.modules;

import com.blub.mvplist.retro.RetrofitRequests;
import com.squareup.moshi.Moshi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class NetModule {
    private String mBaseUrl;

    public NetModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Moshi provideMoshi() {
        return new Moshi.Builder().build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Moshi moshi) {
        return new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(mBaseUrl)
                .build();
    }

    @Provides
    @Singleton
    RetrofitRequests provideRetrofitRequestService(Retrofit retrofit) {
        return retrofit.create(RetrofitRequests.class);
    }
}
