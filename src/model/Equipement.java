package model;

public abstract class Equipement {
    protected String nom;
    protected boolean actif;

    public Equipement(String nom) {
        this.nom = nom;
        this.actif = false;
    }

    public void activer() { this.actif = true; }
    public void desactiver() { this.actif = false; }
    public boolean isActif() { return actif; }
    public String getNom() { return nom; }
}
