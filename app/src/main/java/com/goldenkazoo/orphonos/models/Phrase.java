package com.goldenkazoo.orphonos.models;

public class Phrase {
    private String texte;
    private int sonId;

    public Phrase(String texte, int sonId) {
        this.texte = texte;
        this.sonId = sonId;
    }

    public String getTexte() {
        return texte;
    }

    public int getSonId() {
        return sonId;
    }
}
