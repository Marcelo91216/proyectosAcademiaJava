package principal;

import java.util.Random;

public class Tackle implements Move {

    // Ataque de 35 de daño, no tiene efectos secundarios
    @Override
    public void attack(Pokemon src, Pokemon dst){
        Random random = new Random();
        int power = 35;
        int damage = (int)(2 + ( ( power * ( src.actualstat.att / dst.actualstat.def ) * ( 2 + ( ( 2 * src.getLvl() ) / 5 ) ) ) / 50 ) * ( ( 100 - random.nextInt(16) ) / 100.0 ));
        damage *= src.getState()==State.BURN?0.5:1;
        dst.reduceHp(damage);        
    }

    @Override
    public void print() {
        System.out.println(" a utilizado placaje!");
    }

    @Override
    public String getName() {
        return "Placaje";
    }
}
