package strategy;

import model.Equipement;
import model.Maison;
import model.Piece;

public class RoutineVacances implements RoutineStrategy {
    @Override
    public void executer(Maison maison) {
        System.out.println("[Routine Vacances] Mode hors-gel + surveillance sur : " + maison.getNom());
        for (Piece p : maison.getPieces()) {
            for (Equipement e : p.getEquipements()) {
                e.desactiver();
                System.out.println("  -> " + e.getNom() + " en veille");
            }
        }
    }

    @Override
    public String getNom() { return "Routine Vacances"; }
}
