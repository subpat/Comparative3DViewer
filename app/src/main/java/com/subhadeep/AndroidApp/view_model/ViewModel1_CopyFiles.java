package com.subhadeep.AndroidApp.view_model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.subhadeep.AndroidApp.model.CopyFilesService;
import com.subhadeep.AndroidApp.model.copy_files_data.CopyState;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;


public class ViewModel1_CopyFiles extends AndroidViewModel {

    private CompositeDisposable compositeDisposable;
    private MutableLiveData<CopyState> copyStateMutableLiveData;


    public ViewModel1_CopyFiles(@NonNull Application application) {
        super(application);
        compositeDisposable = new CompositeDisposable();
        copyStateMutableLiveData = new MutableLiveData<>();
        copyStateMutableLiveData.postValue(CopyState.COPYING);
        subscribeToCopyService(application);
    }

    private void subscribeToCopyService(Context context) {
        context.startService(new Intent(context, CopyFilesService.class));
        Observable<CopyState> observable = CopyFilesService.getObservableCopyState();
        Observer<CopyState> observer = new Observer<CopyState>() {
            @Override public void onSubscribe(@NonNull Disposable d) { compositeDisposable.add(d); }
            @Override public void onNext(@NonNull CopyState copyState) { copyStateMutableLiveData.postValue(copyState); }
            @Override public void onError(Throwable e) { copyStateMutableLiveData.postValue(CopyState.COMPLETE); }
            @Override public void onComplete() { copyStateMutableLiveData.postValue(CopyState.COMPLETE); }
        };
        observable.subscribe(observer);
    }

    public LiveData<CopyState> getCopyState() {
        return copyStateMutableLiveData;
    }

    @Override
    protected void onCleared () {
        compositeDisposable.clear();
        super.onCleared();
    }

}
