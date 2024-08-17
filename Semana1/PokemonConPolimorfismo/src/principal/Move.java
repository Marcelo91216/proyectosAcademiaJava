package principal;

public interface Move {
    void attack(Pokemon src, Pokemon dst);
    void print();
    String getName();
}
