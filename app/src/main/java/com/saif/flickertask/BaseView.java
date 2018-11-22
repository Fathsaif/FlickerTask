package com.saif.flickertask;

public interface BaseView<T extends BasePresenter> extends ParentView {
    void setPresenter(T presenter);

}