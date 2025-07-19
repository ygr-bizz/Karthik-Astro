package com.cuspal.interlinks;

import android.content.Context;

public class device_util {
    public static int checkIsTablet(Context mContext) {
        return mContext.getResources().getConfiguration().screenLayout & 15;
    }
}
