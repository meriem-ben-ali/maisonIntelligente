package strategy;

import model.Maison;

public class GestionnaireRoutine {
    private RoutineStrategy strategy;

    public void setStrategy(RoutineStrategy strategy) {
        this.strategy = strategy;
    }

    // synchronized = un seul thread peut exécuter cette méthode à la fois
    public synchronized void executerRoutine(Maison maison) {
        System.out.println("\n=== Exécution : " + strategy.getNom() + " ===");
        strategy.executer(maison);
    }
}