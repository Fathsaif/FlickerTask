package com.saif.flickertask;

import android.support.v4.app.Fragment;
import android.view.View;

import com.saif.flickertask.features.FlickerFragment;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected View getView() {
        return null;
    }

    @Override
    protected Fragment getFragment() {
        return new FlickerFragment();
    }

    @Override
    public int getToolbarTitle() {
        return R.string.app_name;
    }
}
