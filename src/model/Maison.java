package model;

import java.util.ArrayList;
import java.util.List;

public class Maison {
    private String nom;
    private List<Piece> pieces;

    public Maison(String nom) {
        this.nom = nom;
        this.pieces = new ArrayList<>();
    }

    public void ajouterPiece(Piece p) { pieces.add(p); }
    public List<Piece> getPieces() { return pieces; }
    public String getNom() { return nom; }
}
