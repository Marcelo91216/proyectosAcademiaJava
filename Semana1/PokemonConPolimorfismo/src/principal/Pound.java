package principal;

import java.util.Random;

public class Pound implements Move {

    // Hace daño al enemigo con una potencia de 40
    // No tiene efecto secundario
    @Override
    public void attack(Pokemon src, Pokemon dst){
        Random random = new Random();
        int power = 40;
        int damage = (int)(2 + ( ( power * ( src.actualstat.att / dst.actualstat.def ) * ( 2 + ( ( 2 * src.getLvl() ) / 5 ) ) ) / 50 ) * ( ( 100 - random.nextInt(16) ) / 100.0 ));
        dst.reduceHp(damage);
    }
    
    @Override
    public void print(){
        System.out.println(" a utilizado destructor!");
    }

    @Override
    public String getName() {
        return "Destructor";
    }
}
