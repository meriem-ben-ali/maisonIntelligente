import builder.Director;
import builder.MaisonStandardBuilder;
import builder.MaisonVacancesBuilder;
import equipement.Chauffage;
import equipement.Lumiere;
import equipement.Volet;
import model.Maison;
import model.Piece;
import observer.CapteurMouvement;
import observer.NotificationService;
import strategy.GestionnaireRoutine;
import strategy.RoutineDepart;
import strategy.RoutineRetour;
import strategy.RoutineVacances;
import thread.SimulateurEquipement;²&

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // BUILDER
        System.out.println("--- PATTERN BUILDER ---");
        MaisonStandardBuilder builderStd = new MaisonStandardBuilder();
        Director director = new Director(builderStd);
        director.construireMaison();
        Maison maison = builderStd.getMaison();
        System.out.println("Maison créée : " + maison.getNom());

        MaisonVacancesBuilder builderVac = new MaisonVacancesBuilder();
        director.setBuilder(builderVac);
        director.construireMaison();
        Maison maisonVacances = builderVac.getMaison();
        System.out.println("Maison créée : " + maisonVacances.getNom());

        // EQUIPEMENTS
        System.out.println("\n--- AJOUT EQUIPEMENTS ---");
        Chauffage chauffage = new Chauffage("Chauffage Salon");
        chauffage.setTempCible(21);
        Volet volet = new Volet("Volet Chambre");
        Lumiere lumiere = new Lumiere("Lumiere Salon");

        Piece salon = maison.getPieces().get(0);
        salon.ajouterEquipement(chauffage);
        salon.ajouterEquipement(volet);
        salon.ajouterEquipement(lumiere);
        System.out.println("Chauffage, Volet et Lumiere ajoutés au Salon");

        // THREADS
        System.out.println("\n--- THREADS - CONCURRENCE ---");
        Thread threadChauffage = new Thread(new SimulateurEquipement(chauffage, 400));
        Thread threadVolet     = new Thread(new SimulateurEquipement(volet, 250));
        Thread threadLumiere   = new Thread(new SimulateurEquipement(lumiere, 300));

        threadChauffage.start();
        threadVolet.start();
        threadLumiere.start();
        System.out.println("[Main] 3 threads lancés, le programme continue sans attendre\n");

        // STRATEGY
        System.out.println("--- PATTERN STRATEGY ---");
        GestionnaireRoutine gestionnaire = new GestionnaireRoutine();

        gestionnaire.setStrategy(new RoutineDepart());
        gestionnaire.executerRoutine(maison);
        Thread.sleep(200);

        gestionnaire.setStrategy(new RoutineRetour("18h00"));
        gestionnaire.executerRoutine(maison);
        Thread.sleep(200);

        gestionnaire.setStrategy(new RoutineVacances());
        gestionnaire.executerRoutine(maisonVacances);
        Thread.sleep(200);

        // OBSERVER
        System.out.println("\n--- PATTERN OBSERVER ---");
        CapteurMouvement capteur = new CapteurMouvement("Salon");
        NotificationService notif = new NotificationService();
        capteur.abonner(notif);
        capteur.detecter();

        // Attendre la fin des threads
        threadChauffage.join();
        threadVolet.join();
        threadLumiere.join();

        System.out.println("\n--- FIN SIMULATION ---");
    }
}