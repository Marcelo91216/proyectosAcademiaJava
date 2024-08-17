package principal;

// Representa las estadisticas del pokemon, su formato puede variar
public class Stats {
    public int att, def, hp, spd;
    public Stats(int att, int def, int hp, int spd){
        this.att = att;
        this.def = def;
        this.hp = hp;
        this.spd = spd;
    }
    
    @Override
    public String toString(){
        return "Estadisticas:\nAtaque: "+this.att+"\tDefensa: "+this.def+"\nVelocidad: "+this.spd;
    }
}
