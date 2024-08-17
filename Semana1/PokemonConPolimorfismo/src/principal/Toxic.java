package principal;

public class Toxic implements Move {

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
