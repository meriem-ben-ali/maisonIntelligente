package strategy;

import model.Equipement;
import model.Maison;
import model.Piece;

public class RoutineDepart implements RoutineStrategy {
    @Override
    public void executer(Maison maison) {
        System.out.println("[Routine Départ] sur : " + maison.getNom());
        for (Piece p : maison.getPieces()) {
            for (Equipement e : p.getEquipements()) {
                e.desactiver();
                System.out.println("  -> " + e.getNom() + " désactivé");
            }
        }
    }

    @Override
    public String getNom() { return "Routine Départ"; }
}
