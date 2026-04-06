package builder;

import model.Maison;

public interface MaisonBuilder {
    void ajouterSalon();
    void ajouterChambre();
    void ajouterCuisine();
    Maison getMaison();
}
