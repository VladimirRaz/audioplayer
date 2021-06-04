package com.example.obuza;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.Holder> {
    private MyModel viewModel;
    Animation scaleUp, scaleDown;

    public SongAdapter(MyModel viewModel, LifecycleOwner lifecycleOwner) {
        this.viewModel = viewModel;
        this.viewModel.getList().observe(lifecycleOwner, (newList) -> {
            this.notifyDataSetChanged();
        });
    }

    protected List<Song> getList() {
        return this.viewModel.getList().getValue();
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        scaleUp = AnimationUtils.loadAnimation(parent.getContext(), R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(parent.getContext(), R.anim.scale_down);
        return new Holder(view);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        SongAdapter adapter = this;
        Song song = getList().get(position);
        holder.title.setText(song.name);

        if (song.isFaforite) {
            holder.isFavorite.setImageResource(R.drawable.ic_favorite);
        } else {
            holder.isFavorite.setImageResource(R.drawable.ic_favorite_border);
        }


        holder.play.setOnClickListener((view) -> {
            viewModel.playSong(song);
//            nameSong.setText(song.name);
//            songName.setText(song.name);
        });

        holder.isFavorite.setOnClickListener((view) -> {
            song.isFaforite = !song.isFaforite;
            adapter.notifyDataSetChanged();
        });


        holder.nameAlbum.setText(song.album);


    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView play;
        ImageView isFavorite;
        TextView nameSong;
        TextView nameAlbum;
        public Holder(View v) {
            super(v);

//            addFavorite = v.findViewById(R.id.addFavoriteButton);
            nameAlbum = v.findViewById(R.id.nameAlbum);
            title = v.findViewById(R.id.titleTextView);
            play = v.findViewById(R.id.playButton);
            nameSong = v.findViewById(R.id.nameSong);
            isFavorite = v.findViewById(R.id.isFavorite);
        }
    }
}
