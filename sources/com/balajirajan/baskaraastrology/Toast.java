package com.cuspal.interlinks;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class Toast {
    public static void Toasty(Context context, String msg, int attrib) {
        android.widget.Toast toast = android.widget.Toast.makeText(context, msg, 0);
        View view = toast.getView();
        ((TextView) view.findViewById(16908299)).setTextColor(-1);
        if (attrib == 0) {
            view.setBackgroundResource(R.color.ERROR);
        }
        if (attrib == 1) {
            view.setBackgroundResource(R.color.SUCCESS);
        }
        if (attrib == 2) {
            view.setBackgroundResource(R.color.INFO);
        }
        if (attrib == 3) {
            view.setBackgroundResource(R.color.WARNING);
        }
        toast.show();
    }
}
