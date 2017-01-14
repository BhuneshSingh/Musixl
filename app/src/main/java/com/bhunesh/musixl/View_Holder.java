package com.bhunesh.musixl;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bhunesh on 14-01-2017.
 */
public class View_Holder extends RecyclerView.ViewHolder {

    CardView cv;
    TextView title;
    TextView artist;
    ImageView albumArt;

    public View_Holder(View itemView) {
        super(itemView);

        cv = (CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.songName);
        artist = (TextView) itemView.findViewById(R.id.artistName);
        albumArt = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
