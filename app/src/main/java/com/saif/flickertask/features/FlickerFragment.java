package com.saif.flickertask.features;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saif.flickertask.BaseFragment;
import com.saif.flickertask.adapters.FlickerAdapter;
import com.saif.flickertask.R;
import com.saif.flickertask.constants.BundleConstants;
import com.saif.flickertask.models.Photo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlickerFragment extends BaseFragment implements FlickerContract.FlickerView, SwipeRefreshLayout.OnRefreshListener {


    private FlickerContract.Presenter mpresenter;
    @BindView(R.id.txt_no_data)
    TextView txtNoData;
    @BindView(R.id.rv_flickers)
    RecyclerView rvFlickers;
    @BindView(R.id.swipe_layout_refresh_done)
    SwipeRefreshLayout swipeLayoutRefreshDone;
    FlickerAdapter flickerAdapter;


    public FlickerFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        swipeLayoutRefreshDone.setOnRefreshListener(this);
        mpresenter=new FlickerPresenter();
        mpresenter.registerView(this);
        mpresenter.getData();

        return view;
    }


    @Override
    public void showData(ArrayList<Photo> photos) {
        swipeLayoutRefreshDone.setRefreshing(false);
        flickerAdapter = new FlickerAdapter(getActivity(),photos);
        rvFlickers.setAdapter(flickerAdapter);

    }

    @Override
    public void showNoData() {
        txtNoData.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRefresh() {
        swipeLayoutRefreshDone.setRefreshing(false);
    }

    @Override
    public void setPresenter(FlickerContract.Presenter presenter) {
        this.mpresenter = presenter;
    }


    @Override
    public void onRefresh() {
        mpresenter.getData();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(BundleConstants.CACHED, "cached");
        setRetainInstance(true);
    }
}
