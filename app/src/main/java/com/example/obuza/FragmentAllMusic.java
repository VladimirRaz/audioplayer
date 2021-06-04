package com.example.obuza;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.obuza.databinding.FragmentAllMusicBinding;

import java.util.ArrayList;
import java.util.List;




public class FragmentAllMusic extends Fragment {
    List<Song> list = new ArrayList<Song>();
    public FragmentAllMusic() {
        super(R.layout.fragment_all_music);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentAllMusicBinding binding = FragmentAllMusicBinding.inflate(getLayoutInflater());
        MyModel viewModel = new ViewModelProvider(requireActivity()).get(MyModel.class);
        binding.setViewModel(viewModel);

        SongAdapter adapter = new SongAdapter(viewModel, getViewLifecycleOwner());
        binding.allSongsRecyclerView.setAdapter(adapter);


        return binding.getRoot();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        list.add(new Song("Люди не верили"));
//        RecyclerView allSongs = view.findViewById(R.id.allSongsRecyclerView);
//        SongAdapter adapter = new SongAdapter(list);
//        allSongs.setAdapter(adapter);
//    }


}
