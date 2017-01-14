package com.bhunesh.musixl;

/**
 * Created by Bhunesh on 14-01-2017.
 */

public class Song {
    public String title;
    public String artist;
    public int albumArt;
    private long id;

    public Song(long id, String title, String artist, int albumArt) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.albumArt = albumArt;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getAlbumArt() {
        return albumArt;
    }
}
