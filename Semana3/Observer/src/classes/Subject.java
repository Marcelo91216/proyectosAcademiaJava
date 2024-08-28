package classes;

public interface Subject {
    void update();
    void attach(Limiter l);
    void detach(Limiter l);
    void reset();
}
