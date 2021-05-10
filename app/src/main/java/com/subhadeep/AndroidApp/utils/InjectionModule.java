package com.subhadeep.AndroidApp.utils;

import android.content.Context;

import com.subhadeep.AndroidApp.model.settings_data.SettingsData;
import com.subhadeep.AndroidApp.model.settings_data.SettingsDataSerializer;

import javax.inject.Named;
import javax.inject.Singleton;

import androidx.datastore.core.DataStore;
import androidx.datastore.rxjava3.RxDataStoreBuilder;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

@Module
@InstallIn(SingletonComponent.class)
public class InjectionModule {

    private static final String PREFS_FILE = "prefs_datastore";


    @Singleton
    @Provides
    @Named("PREFERENCE_FILENAME")
    public String provideDataStoreFilename() {
        return PREFS_FILE;
    }

    @Singleton
    @Provides
    public SettingsDataSerializer provideSettingsDataSerializer() {
        return new SettingsDataSerializer();
    }

    @Singleton
    @Provides
    public DataStore<SettingsData> providePaymentDataStore(@ApplicationContext Context context,
                                                           @Named("PREFERENCE_FILENAME") String filename,
                                                           SettingsDataSerializer settingsDataSerializer) {
        return new RxDataStoreBuilder<SettingsData>(context, filename, settingsDataSerializer).build();
    }


    @Singleton
    @Provides
    @Named("OBSERVE_ON_SCHEDULER")
    public Scheduler provideObserveOnScheduler() {
        return AndroidSchedulers.mainThread();
    }


    @Singleton
    @Provides
    @Named("SUBSCRIBE_ON_SCHEDULER")
    public Scheduler provideSubscribeOnScheduler() {
        return Schedulers.io();
    }

}
