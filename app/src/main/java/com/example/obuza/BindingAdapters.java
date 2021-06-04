package com.example.obuza;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {
//    public static
    @BindingAdapter({"app:ms"})
    public static void contertToTime(TextView view, Integer ms) {
        int sec = ms / 1000;
        int ss = sec % 60;
        int min = sec / 60;
        view.setText(String.format("%02d:%02d", min, ss));

    }
}
