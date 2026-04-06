package observer;

import java.util.ArrayList;
import java.util.List;

public class CapteurMouvement implements Observable {
    private List<Observateur> observateurs = new ArrayList<>();
    private String localisation;

    public CapteurMouvement(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public void abonner(Observateur o) { observateurs.add(o); }

    @Override
    public void desabonner(Observateur o) { observateurs.remove(o); }

    @Override
    public void notifier(String evt) {
        for (Observateur o : observateurs) {
            o.miseAJour(evt);
        }
    }

    public void detecter() {
        System.out.println("[Capteur] Mouvement détecté en : " + localisation);
        notifier("Mouvement détecté en " + localisation);
    }
}
