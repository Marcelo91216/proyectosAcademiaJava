package principal;

import java.util.Random;

public class BodySlam implements Move {

    // Hace daño de 85 al enemigo, además con el efecto secundario
    // de poder paralizar al enemigo con una probabilidad del 50%
    @Override
    public void attack(Pokemon src, Pokemon dst) {
        Random random = new Random();
        int power = 85;
        int damage = (int)(2 + ( ( power * ( src.actualstat.att / dst.actualstat.def ) * ( 2 + ( ( 2 * src.getLvl() ) / 5 ) ) ) / 50 ) * ( ( 100 - random.nextInt(16) ) / 100.0 ));
        damage *= src.getState()==State.BURN?0.5:1;
        dst.reduceHp(damage);        
        if(random.nextInt(10)<5){
            dst.setState(State.PARA);
        }        
    }

    @Override
    public void print() {
        System.out.println(" a utilizado golpe cuerpo!");
    }

    @Override
    public String getName() {
        return "Golpe cuerpo";
    }
    
}
