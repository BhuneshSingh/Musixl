package com.bhunesh.musixl;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

/**
 * Created by Bhunesh on 14-01-2017.
 */

public class songAdapter extends RecyclerView.Adapter<View_Holder> {

    Context context;
    private ArrayList<Song> songs;


    public songAdapter(ArrayList<Song> songs, Context context) {
        this.songs = songs;
        this.context = context;
    }


    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.songlayout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {

        holder.title.setText(songs.get(position).title);
        holder.artist.setText(songs.get(position).artist);
        holder.albumArt.setImageBitmap(BitmapFactory.decodeFile(String.valueOf(songs.get(position).albumArt)));
        animate(holder);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.bounce_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }
}

