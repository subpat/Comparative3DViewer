package com.subhadeep.AndroidApp.view_model;

import com.subhadeep.AndroidApp.model.fragment_data.Camera;
import com.subhadeep.AndroidApp.model.SettingsRepository;
import com.subhadeep.AndroidApp.model.fragment_data.ChangedCameraData;
import com.subhadeep.AndroidApp.model.fragment_data.ResetModelData;
import com.subhadeep.AndroidApp.model.fragment_data.ToggleSyncData;
import com.subhadeep.AndroidApp.model.settings_data.SettingsData;

import javax.inject.Inject;
import javax.inject.Named;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;

@HiltViewModel
public class ViewModel4_View3DModel extends ViewModel {

    private Scheduler observeOnScheduler;
    private Scheduler subscribeOnScheduler;
    private SettingsRepository settingsRepository;
    private CompositeDisposable compositeDisposable;

    private MutableLiveData<SettingsData> settingsDataMutableLiveData;
    private MutableLiveData<ResetModelData> resetModelDataMutableLiveData;
    private MutableLiveData<ToggleSyncData> toggleSyncDataMutableLiveData;
    private MutableLiveData<ChangedCameraData> changedCameraDataMutableLiveData;

    @Inject
    public ViewModel4_View3DModel (SettingsRepository settingsRepository,
                                @Named("OBSERVE_ON_SCHEDULER") Scheduler observeOnScheduler,
                                @Named("SUBSCRIBE_ON_SCHEDULER") Scheduler subscribeOnScheduler) {
        this.settingsRepository = settingsRepository;
        this.observeOnScheduler = observeOnScheduler;
        this.subscribeOnScheduler = subscribeOnScheduler;
        this.compositeDisposable = new CompositeDisposable();
        this.settingsDataMutableLiveData = new MutableLiveData<>();

        this.resetModelDataMutableLiveData = new MutableLiveData<>();
        this.toggleSyncDataMutableLiveData = new MutableLiveData<>();
        this.changedCameraDataMutableLiveData = new MutableLiveData<>();
    }


    public void subscribeToSettingsData () {
        Flowable<SettingsData> settingsDataFlowable = settingsRepository.getPaymentInfo();
        compositeDisposable.add(settingsDataFlowable
                .observeOn(observeOnScheduler)
                .subscribeOn(subscribeOnScheduler)
                .subscribe(new Consumer<SettingsData>() {
                               @Override
                               public void accept(SettingsData settingsData) throws Throwable {
                                   settingsDataMutableLiveData.postValue(settingsData);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Throwable {
                                settingsDataMutableLiveData.postValue(SettingsData.getDefaultSettings());
                            }
                        })
        );
    }

    public LiveData<SettingsData> getSettingsData() {
        return settingsDataMutableLiveData;
    }

    public LiveData<ResetModelData> getResetModelData() { return resetModelDataMutableLiveData; }

    public void setResetModelData(String fragmentName) {
        resetModelDataMutableLiveData.postValue(new ResetModelData(fragmentName));
    }


    public LiveData<ToggleSyncData> getToggleSyncData() { return toggleSyncDataMutableLiveData; }

    public void setToggleSyncData(String fragmentName, boolean bool) {
        toggleSyncDataMutableLiveData.postValue(new ToggleSyncData(fragmentName, bool));
    }

    public LiveData<ChangedCameraData> getChangedCameraData() { return changedCameraDataMutableLiveData; }

    public void setChangedCameraData(String fragmentName, Camera camera) {
        changedCameraDataMutableLiveData.postValue(new ChangedCameraData(fragmentName, camera));
    }

    @Override
    protected void onCleared () {
        compositeDisposable.clear();
        super.onCleared();
    }
}
