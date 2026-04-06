package builder;

public class Director {
    private MaisonBuilder builder;

    public Director(MaisonBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(MaisonBuilder builder) {
        this.builder = builder;
    }

    public void construireMaison() {
        builder.ajouterSalon();
        builder.ajouterChambre();
        builder.ajouterCuisine();
    }
}
