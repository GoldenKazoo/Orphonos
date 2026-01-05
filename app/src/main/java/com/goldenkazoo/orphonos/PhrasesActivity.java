package com.goldenkazoo.orphonos;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenkazoo.orphonos.adapters.PhraseAdapter;
import com.goldenkazoo.orphonos.models.Phrase;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView tvCategory;
    private ArrayList<Phrase> phrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        tvCategory = findViewById(R.id.tvCategory);
        recyclerView = findViewById(R.id.recyclerPhrases);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String categorie = getIntent().getStringExtra("categorie");
        tvCategory.setText(categorie);

        phrases = new ArrayList<>();

        if ("Salutations".equals(categorie))
        {
            phrases.add(new Phrase("Bonjour", R.raw.bonjour));
            phrases.add(new Phrase("Bonsoir", R.raw.bonsoir));
        }
        else if ("Remerciements".equals(categorie))
        {
            phrases.add(new Phrase("Merci", R.raw.merci));
            phrases.add(new Phrase("Merci beaucoup", R.raw.merci_beaucoup));
        }
        else if ("Urgence".equals(categorie))
        {
            phrases.add(new Phrase("Au secours !", R.raw.au_secours));
            phrases.add(new Phrase("Appelez un médecin", R.raw.appelez_medecin));
        }
        else if ("Questions".equals(categorie))
        {
            phrases.add(new Phrase("Comment ça va ?", R.raw.comment_ca_va));
        }

        PhraseAdapter adapter = new PhraseAdapter(phrases, this);
        recyclerView.setAdapter(adapter);
    }
}
