package com.example.obuza;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

//import com.example.obuza.databinding.FragmentMusicControllerBinding;
import com.example.obuza.databinding.FragmentMusicContollerBinding;
//import com.example.obuza.databinding.FragmentThreeBinding;

//import static com.example.obuza.FragmentOne.mediaPlayer;
//import static com.example.obuza.FragmentTwo.fragmentOne;
//import static com.example.obuza.FragmentTwo.handler;

interface OnProgressChange extends SeekBar.OnSeekBarChangeListener {
    @Override
    default void onStartTrackingTouch(SeekBar seekBar){
    };

    @Override
    default void onStopTrackingTouch(SeekBar seekBar){
    };
}


public class MusicController extends Fragment {
    static TextView nameSong;
    static TextView timeSong;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMusicContollerBinding binding = FragmentMusicContollerBinding.inflate(getLayoutInflater());
        MyModel viewModel = new ViewModelProvider(requireActivity()).get(MyModel.class);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
//        nameSong = binding.nameSong;
//        timeSong = binding.timeSong;
        binding.seekBar.setOnSeekBarChangeListener(new OnProgressChange() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                if (fromUser) {
                    viewModel.setSongPosition(i);


                }
            }
        });

        return binding.getRoot();

    }

}