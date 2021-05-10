package com.subhadeep.AndroidApp.model;

import com.subhadeep.AndroidApp.model.settings_data.SettingsData;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.datastore.core.DataStore;
import androidx.datastore.rxjava3.RxDataStore;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class SettingsRepository {

    private DataStore<SettingsData> settingsDataStore;

    @Inject
    public SettingsRepository (DataStore<SettingsData> settingsDataStore) {
        this.settingsDataStore = settingsDataStore;
    }

    public Single<SettingsData> setSettingsData (SettingsData newSettingsData) {
        return RxDataStore.updateDataAsync(settingsDataStore, settingsData -> Single.just(newSettingsData));
    }

    public Single<SettingsData> resetSettingsData() {
        SettingsData newSettingsData = SettingsData.getDefaultSettings();
        // Overwrite previous values with default ones
        return RxDataStore.updateDataAsync(settingsDataStore, settingsData -> Single.just(newSettingsData));
    }

    public Flowable<SettingsData> getPaymentInfo() {
        return RxDataStore.data(settingsDataStore);
    }

}
