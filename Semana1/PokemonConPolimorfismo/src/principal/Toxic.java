package principal;

public class Toxic implements Move {

    // No hace nada de daño directo, pero tendrá un 100% de probabilidades de envenenar al enemigo
    @Override
    public void attack(Pokemon src, Pokemon dst) {
        dst.setState(State.POISON);
    }

    @Override
    public void print() {
        System.out.println(" a envenenado al enemigo!");
    }

    @Override
    public String getName() {
        return "Toxico";
    }
    
}
