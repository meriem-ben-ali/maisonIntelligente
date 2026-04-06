package equipement;

import model.Equipement;

public class Chauffage extends Equipement {
    private int tempActuelle;
    private int tempCible;

    public Chauffage(String nom) {
        super(nom);
        this.tempActuelle = 15;
        this.tempCible = 15;
    }

    public void setTempCible(int t) { this.tempCible = t; }
    public int getTempActuelle() { return tempActuelle; }

    public void monterTemp() {
        if (tempActuelle < tempCible) tempActuelle++;
    }

    public boolean estATemperature() {
        return tempActuelle >= tempCible;
    }
}
