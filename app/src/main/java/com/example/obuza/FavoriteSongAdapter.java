package com.example.obuza;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;
import java.util.stream.Collectors;

public class FavoriteSongAdapter extends SongAdapter {
    private MyModel viewModel;

    public FavoriteSongAdapter(MyModel viewModel, LifecycleOwner lifecycleOwner) {
        super(viewModel, lifecycleOwner);
    }

    @Override
    protected List<Song> getList() {
        List<Song> list = super.getList();
        return list.stream().filter((it) -> it.isFaforite).collect(Collectors.toList());
    }
}
