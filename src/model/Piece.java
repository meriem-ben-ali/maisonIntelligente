package model;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private String nom;
    private List<Equipement> equipements;

    public Piece(String nom) {
        this.nom = nom;
        this.equipements = new ArrayList<>();
    }

    public void ajouterEquipement(Equipement e) {
        equipements.add(e);
    }

    public List<Equipement> getEquipements() { return equipements; }
    public String getNom() { return nom; }
}
