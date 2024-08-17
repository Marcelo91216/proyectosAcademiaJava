package principal;

import java.util.Random;

public class Pokemon extends Species {

    private Stats dv;
    public Stats actualstat;
    private int actualHp;
    private Move[] moveset;
    private State state;
    private int lvl;

    public Pokemon(Stats bs, String name, Stats dv, int lvl) {
        super(bs, name);
        this.dv = dv;
        this.lvl = lvl;
        this.actualstat = new Stats((int)(5 + ((((this.baseStats.att + this.dv.att) * 2.0) * this.lvl) / 100.0)), (int)(5 + ((((this.baseStats.att + this.dv.att) * 2.0) * this.lvl) / 100.0)), (int)(10 + this.lvl + ((this.lvl * ((this.baseStats.hp + this.dv.hp) * 2.0)) / 100.0)), (int)(5 + ((((this.baseStats.att + this.dv.att) * 2.0) * this.lvl) / 100.0)));
//        this.actualstat.att = 5 + ((((this.baseStats.att + this.dv.att) * 2) * this.lvl) / 100);
//        this.actualstat.def = 5 + ((((this.baseStats.def + this.dv.def) * 2) * this.lvl) / 100);
//        this.actualstat.spd = 5 + ((((this.baseStats.spd + this.dv.spd) * 2) * this.lvl) / 100);
//        this.actualstat.hp = 10 + this.lvl + ((this.lvl * ((this.baseStats.hp + this.dv.hp) * 2)) / 100);
        this.actualHp = this.actualstat.hp;
        this.state = State.NULL;
    }
    
    @Override
    public String toString(){
        return "~ ~ ~ ~ ~ ~\n> "+this.name+" nivel: "+this.lvl+"\nPuntos de salud: "+this.actualHp+"/"+this.actualstat.hp+(this.state!=State.NULL?"\nSufre de "+this.state:"")+"\n"+this.actualstat+"\n~ ~ ~ ~ ~ ~";
    }

    public int getLvl() {
        return this.lvl;
    }

    public int getHp() {
        return this.actualHp;
    }

    public void assignMoves(Move[] newMoves) {
        this.moveset = newMoves;
    }

    public void reduceHp(int reduce) {
        this.actualHp -= reduce;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }
    
    public void randomMove(Pokemon enemy){
        Random rand = new Random();
        this.moveset[rand.nextInt(this.moveset.length)].attack(this, enemy);
        System.out.print("El enemigo "+this.name);
        this.moveset[rand.nextInt(this.moveset.length)].print();
    }
    
    public String getName(){
        return this.name;
    }
    
    public Move[] getMoveset(){
        return this.moveset;
    }
    
    public void isSufferingPoison(){
        if(this.state == State.POISON){
            this.reduceHp((1/16)*this.actualstat.hp);
            System.out.println(this.name+" esta sufriendo por el veneno!");
        }
    }
}
