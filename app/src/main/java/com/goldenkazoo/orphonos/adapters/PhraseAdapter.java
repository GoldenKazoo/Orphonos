package com.goldenkazoo.orphonos.adapters;

import android.content.Context;
import android.media.MediaPlayer;
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
            MediaPlayer mediaPlayer = MediaPlayer.create(context, phrase.getSonId());
            mediaPlayer.start();
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
}
