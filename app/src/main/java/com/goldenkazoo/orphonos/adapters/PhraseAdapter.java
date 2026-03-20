package com.goldenkazoo.orphonos.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenkazoo.orphonos.R;
import com.goldenkazoo.orphonos.models.Phrase;

import java.util.ArrayList;

public class PhraseAdapter extends RecyclerView.Adapter<PhraseAdapter.ViewHolder> {

    private ArrayList<Phrase> phrases;
    private Context context;
    private MediaPlayer mediaPlayer; // INSTANCE PARTAGÉE

    public PhraseAdapter(ArrayList<Phrase> phrases, Context context) {
        this.phrases = phrases;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_phrase, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Phrase phrase = phrases.get(position);
        holder.btnPhrase.setText(phrase.getTexte());

        holder.btnPhrase.setOnClickListener(v -> {

            // Si son est déjà en train de jouer, on l'arrête
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }

            // creer et jouer le nouveau son
            mediaPlayer = MediaPlayer.create(v.getContext(), phrase.getSonId());
            if (mediaPlayer != null) {
                mediaPlayer.start();
                // Libérer la ressource quand le son se termine
                mediaPlayer.setOnCompletionListener(mp -> {
                    mp.release();
                    mediaPlayer = null;
                });
            } else {
                Log.e("PhraseAdapter", "MediaPlayer null pour : " + phrase.getTexte());
            }
        });
    }

    @Override
    public int getItemCount() {
        return phrases.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        Button btnPhrase;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnPhrase = itemView.findViewById(R.id.btnPhrase);
        }
    }

    public void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
