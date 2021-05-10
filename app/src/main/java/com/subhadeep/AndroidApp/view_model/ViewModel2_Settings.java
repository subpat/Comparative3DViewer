package com.subhadeep.AndroidApp.view_model;

import com.subhadeep.AndroidApp.model.SettingsRepository;
import com.subhadeep.AndroidApp.model.settings_data.SettingsData;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Single;

@HiltViewModel
public class ViewModel2_Settings extends ViewModel {

    private SettingsRepository settingsRepository;

    @Inject
    public ViewModel2_Settings (SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public Single<SettingsData> saveSettingsData (SettingsData settingsData) {
        return settingsRepository.setSettingsData(settingsData);
    }

    public Single<SettingsData> resetSettingsData () {
        return settingsRepository.resetSettingsData();
    }

}
