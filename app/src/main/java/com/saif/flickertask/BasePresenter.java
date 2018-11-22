package com.saif.flickertask;

public interface BasePresenter<T extends BaseView> {

    void registerView(T view);

    void unregisterView();

    void start();

}