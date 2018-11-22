package com.saif.flickertask.features;

import android.util.Log;

import com.saif.flickertask.connection.RestClient;
import com.saif.flickertask.models.Data;
import com.saif.flickertask.models.Photo;
import com.saif.flickertask.utils.NetworkUtil;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class FlickerPresenter implements FlickerContract.Presenter {

    private FlickerContract.FlickerView flickerView;

    @Override
    public void getData() {
        getPhotos();
    }

    private void getPhotos() {
        flickerView.showProgress();
        Observable<Data> observable = RestClient.getClient().getData();
        observable.subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Data, ArrayList<Photo>>() {
                    @Override
                    public ArrayList<Photo> apply(Data data) {
                        return (ArrayList<Photo>) data.getPhotos().getPhoto();
                    }
                }).subscribe(new Observer<ArrayList<Photo>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ArrayList<Photo> photos) {
                flickerView.hideProgress();
                if (photos==null||photos.size()==0)
                    flickerView.showNoData();
                else flickerView.showData(photos);
                //textView.setText(s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("error",e.getMessage());
                flickerView.hideProgress();
                flickerView.hideRefresh();
                if (NetworkUtil.isConnected()){
                    flickerView.showNoConnection();
                }else
                    flickerView.showError();
            }

            @Override
            public void onComplete() {

            }
        });

    }


    @Override
    public void registerView(FlickerContract.FlickerView view) {
        flickerView = view;

    }

    @Override
    public void unregisterView() {

    }

    @Override
    public void start() {

    }
}
