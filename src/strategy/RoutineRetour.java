package strategy;

import model.Equipement;
import model.Maison;
import model.Piece;

public class RoutineRetour implements RoutineStrategy {
    private String heureArrivee;

    public RoutineRetour(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    @Override
    public void executer(Maison maison) {
        System.out.println("[Routine Retour] Arrivée prévue à " + heureArrivee + " sur : " + maison.getNom());
        for (Piece p : maison.getPieces()) {
            for (Equipement e : p.getEquipements()) {
                e.activer();
                System.out.println("  -> " + e.getNom() + " activé");
            }
        }
    }

    @Override
    public String getNom() { return "Routine Retour"; }
}
