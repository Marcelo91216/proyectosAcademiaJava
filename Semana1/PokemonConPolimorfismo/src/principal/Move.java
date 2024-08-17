package principal;

// Inteface o plantilla para todos los movimientos
public interface Move {
    // Realiza un ataque, cuyo efecto puede variar
    void attack(Pokemon src, Pokemon dst);
    // Imprime en pantalla un dialogo relacionado con el movimiento
    void print();
    // Se retorna el nombre del movimiento
    String getName();
}
