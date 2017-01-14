package com.bhunesh.musixl;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    public int albumArt;
    private ArrayList<Song> songList;
    private RecyclerView songView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songView = (RecyclerView) findViewById(R.id.songList);
        songList = new ArrayList<Song>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSongList();

        Collections.sort(songList, new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        songAdapter adapter = new songAdapter(songList, getApplication());
        songView.setAdapter(adapter);
        songView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void getSongList() {
        ContentResolver musicResolver = getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);

        if (musicCursor != null && musicCursor.moveToFirst()) {
            //Obtaining the columns
            int titleColumn = musicCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST);
            int albumArtColumn = musicCursor.getColumnIndexOrThrow(MediaStore.Audio.AlbumColumns.ALBUM_ART);

            do {
                long Id = musicCursor.getLong(idColumn);
                String title = musicCursor.getString(titleColumn);
                String artist = musicCursor.getString(artistColumn);
                albumArt = musicCursor.getInt(albumArtColumn);
                songList.add(new Song(Id, title, artist, albumArt));

            } while (musicCursor.moveToNext());

        }
        musicCursor.close();
    }
}
