package thread;

import equipement.Chauffage;
import equipement.Lumiere;
import equipement.Volet;
import model.Equipement;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimulateurEquipement implements Runnable {
    private Equipement equipement;
    private int delaiMs;

    private static AtomicBoolean chauffageTermine = new AtomicBoolean(false);
    private static AtomicBoolean voletTermine     = new AtomicBoolean(false);
    private static AtomicBoolean lumiereTermine   = new AtomicBoolean(false);

    public SimulateurEquipement(Equipement equipement, int delaiMs) {
        this.equipement = equipement;
        this.delaiMs = delaiMs;
    }

    @Override
    public void run() {

        if (equipement instanceof Chauffage) {
            if (chauffageTermine.get()) return;
            Chauffage chauffage = (Chauffage) equipement;
            System.out.println("[Thread] Démarrage simulation : " + chauffage.getNom());
            while (!chauffage.estATemperature()) {
                chauffage.monterTemp();
                System.out.println("[" + chauffage.getNom() + "] Température : "
                        + chauffage.getTempActuelle() + "°C");
                try { Thread.sleep(delaiMs); }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            chauffageTermine.set(true);
            System.out.println("[" + chauffage.getNom() + "] Température cible atteinte");

        } else if (equipement instanceof Volet) {
            if (voletTermine.get()) return;
            Volet volet = (Volet) equipement;
            System.out.println("[Thread] Démarrage simulation : " + volet.getNom());
            while (volet.getOuverture() < 100) {
                volet.ouvrir();
                System.out.println("[" + volet.getNom() + "] Ouverture : "
                        + volet.getOuverture() + "%");
                try { Thread.sleep(delaiMs); }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            voletTermine.set(true);
            System.out.println("[" + volet.getNom() + "] Ouvert à 100%");

        } else if (equipement instanceof Lumiere) {
            if (lumiereTermine.get()) return;
            Lumiere lumiere = (Lumiere) equipement;
            System.out.println("[Thread] Démarrage simulation : " + lumiere.getNom());
            while (!lumiere.estAllumee()) {
                lumiere.allumer();
                System.out.println("[" + lumiere.getNom() + "] Intensité : "
                        + lumiere.getIntensite() + "%");
                try { Thread.sleep(delaiMs); }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            lumiereTermine.set(true);
            System.out.println("[" + lumiere.getNom() + "] Lumière allumée à 100%");
        }
    }
}