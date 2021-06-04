package com.example.obuza;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import android.os.Handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.SeekBar;

import com.example.obuza.databinding.FragmentFavoriteBinding;

import com.example.obuza.databinding.FragmentTwoBinding;


public class FragmentFavorite extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFavoriteBinding binding = FragmentFavoriteBinding.inflate(getLayoutInflater());
        MyModel viewModel = new ViewModelProvider(requireActivity()).get(MyModel.class);
        binding.setViewModel(viewModel);

        FavoriteSongAdapter adapter = new FavoriteSongAdapter(viewModel, getViewLifecycleOwner());
        binding.favoriteSongsRecyclerView.setAdapter(adapter);

        return binding.getRoot();
    }


}