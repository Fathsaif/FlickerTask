package com.saif.flickertask.features;

import com.saif.flickertask.BasePresenter;
import com.saif.flickertask.BaseView;
import com.saif.flickertask.models.Photo;

import java.util.ArrayList;

interface FlickerContract  {

    interface FlickerView extends BaseView<Presenter> {

        void showData(ArrayList<Photo> photos);
        void showNoData ();
        void hideRefresh();

    }

    interface Presenter extends BasePresenter<FlickerView> {

        void getData();

    }
}
