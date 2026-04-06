package builder;

import model.Maison;
import model.Piece;

public class MaisonStandardBuilder implements MaisonBuilder {
    private Maison maison;

    public MaisonStandardBuilder() {
        this.maison = new Maison("Maison Standard");
    }

    @Override
    public void ajouterSalon() {
        maison.ajouterPiece(new Piece("Salon"));
        System.out.println("[Builder] Salon ajouté");
    }

    @Override
    public void ajouterChambre() {
        maison.ajouterPiece(new Piece("Chambre"));
        System.out.println("[Builder] Chambre ajoutée");
    }

    @Override
    public void ajouterCuisine() {
        maison.ajouterPiece(new Piece("Cuisine"));
        System.out.println("[Builder] Cuisine ajoutée");
    }

    @Override
    public Maison getMaison() { return maison; }
}
