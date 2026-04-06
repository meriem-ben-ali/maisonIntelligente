package builder;

import model.Maison;
import model.Piece;

public class MaisonVacancesBuilder implements MaisonBuilder {
    private Maison maison;

    public MaisonVacancesBuilder() {
        this.maison = new Maison("Maison Vacances");
    }

    @Override
    public void ajouterSalon() {
        maison.ajouterPiece(new Piece("Salon Vacances"));
        System.out.println("[Builder Vacances] Salon ajouté");
    }

    @Override
    public void ajouterChambre() {
        maison.ajouterPiece(new Piece("Chambre Vacances"));
        System.out.println("[Builder Vacances] Chambre ajoutée");
    }

    @Override
    public void ajouterCuisine() {
        maison.ajouterPiece(new Piece("Cuisine Vacances"));
        System.out.println("[Builder Vacances] Cuisine ajoutée");
    }

    @Override
    public Maison getMaison() { return maison; }
}
