package com.saif.flickertask.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ProgressBar;

import com.saif.flickertask.FlickerApplication;
import com.saif.flickertask.R;


public final class DialogUtil {


    private DialogUtil() {
    }


    public static ProgressDialog showProgressDialog(Context context, int message, boolean cancelable) {
        ProgressDialog dialog = new ProgressDialog(context,R.style.AppCompatAlertDialogStyle);
        dialog.setMessage(context.getString(message));
        dialog.setCanceledOnTouchOutside(cancelable);
        dialog.show();
        return dialog;
    }





}
