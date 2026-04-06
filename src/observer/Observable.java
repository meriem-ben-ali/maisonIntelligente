package observer;

public interface Observable {
    void abonner(Observateur o);
    void desabonner(Observateur o);
    void notifier(String evt);
}
