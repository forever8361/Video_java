package com.wwssxx.kaiyan.widget;

import android.content.Context;
import android.widget.Toast;

public class NewToast extends Toast {

    public NewToast(Context context) {
        super(context);
    }

    public static void show(Context context, int resId) {
        show(context, context.getString(resId));
    }

    public static void show(Context context, CharSequence text) {
        Toast result = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        result.show();
    }
}
