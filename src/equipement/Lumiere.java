package equipement;
import model.Equipement;

public class Lumiere extends Equipement {
    private int intensite;

    public Lumiere(String nom) {
        super(nom);
        this.intensite = 0;
    }

    public void allumer() { if (intensite < 100) intensite += 20; }
    public int getIntensite() { return intensite; }
    public boolean estAllumee() { return intensite >= 100; }
}