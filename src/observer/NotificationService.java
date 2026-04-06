package observer;

public class NotificationService implements Observateur {
    @Override
    public void miseAJour(String evt) {
        System.out.println("[NOTIFICATION] Alerte : " + evt);
    }
}
