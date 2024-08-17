package principal;

import java.util.Random;

public class Acid implements Move {
    @Override
    public void attack(Pokemon src, Pokemon dst){
        Random random = new Random();
        int power = 40;
        int damage = (int)(2 + ( ( power * ( src.actualstat.att / dst.actualstat.def ) * ( 2 + ( ( 2 * src.getLvl() ) / 5 ) ) ) / 50 ) * ( ( 100 - random.nextInt(16) ) / 100.0 ));
        damage *= src.getState()==State.BURN?0.5:1;
        dst.reduceHp(damage);        
        if(random.nextInt(10)<3){
            dst.setState(State.POISON);
        }
    }    

    @Override
    public void print() {
        System.out.println(" a utilizado acido!");
    }

    @Override
    public String getName() {
        return "Acido";
    }
}
