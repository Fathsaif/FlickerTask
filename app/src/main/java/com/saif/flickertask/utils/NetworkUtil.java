package com.saif.flickertask.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.saif.flickertask.FlickerApplication;


public class NetworkUtil {


    private static ConnectivityManager connectivityManager() {
        return (ConnectivityManager) FlickerApplication.get().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) FlickerApplication.get().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return !(activeNetwork != null &&
                        activeNetwork.isConnectedOrConnecting());

    }

}
