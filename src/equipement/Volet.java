package equipement;

import model.Equipement;

public class Volet extends Equipement {
    private int ouverture;

    public Volet(String nom) {
        super(nom);
        this.ouverture = 0;
    }

    public void ouvrir() { if (ouverture < 100) ouverture += 10; }
    public void fermer() { if (ouverture > 0) ouverture -= 10; }
    public int getOuverture() { return ouverture; }
}
