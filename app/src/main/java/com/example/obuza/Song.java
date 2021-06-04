package com.example.obuza;

public class Song {
    String name;
    String songLink;
    boolean isFaforite;
    boolean isAlbum;
    String album;


    public Song(String name, String album) {
        this.name = name;
        this.album = album;
    }

    public String getName() {
        return name;
    }
}
