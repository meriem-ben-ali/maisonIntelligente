package strategy;

import model.Maison;

public interface RoutineStrategy {
    void executer(Maison maison);
    String getNom();
}
