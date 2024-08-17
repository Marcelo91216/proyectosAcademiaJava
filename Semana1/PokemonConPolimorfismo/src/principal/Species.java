package principal;

// Representa la especie pokemon a la que pertenece un pokemon
public abstract class Species {

    protected Stats baseStats;
    protected String name;

    public Species(Stats stats, String name) {
        this.baseStats = stats;
        this.name = name;
    }

}
