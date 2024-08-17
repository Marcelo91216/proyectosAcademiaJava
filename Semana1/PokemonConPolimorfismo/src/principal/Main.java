package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scan;
    static Random random;
    static Pokemon yours;
    static Pokemon enemy;
    static byte o;
    
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        random = new Random();
        o = 5;
        assignData();
        battle();
    }

    // Inicia el combate pokemon en el cual el jugador puede decidir entre 4 movimientos
    // Podrá visualizar las estadisticas de su pokemon asignado
    // Ademas de visualizar datos de todos los pokemon como sus puntos de vida
    // o su estado
    public static void battle(){
        System.out.println("La batalla ha empezado!!");
        do{
            // Accion a realizar
            System.out.println("> Es tu turno de pelear!\nOpciones:\nHuir(Terminar programa) -> 0");
            Move[] miMoveset = yours.getMoveset();
            for(int i=0; i<miMoveset.length; i++){
                System.out.println("["+(i+1)+"] "+miMoveset[i].getName());
            }
            
            // Estado de los Pokemon
            System.out.println("Tu pokemon"+yours);
            System.out.println("Pokemon enemigo"+enemy);
            
            if(!scan.hasNextByte()){
                System.out.println("#[!] Escriba un dato valido.\nComo castigo, pierdes tu turno!!");
                scan.next();
                continue;
            }
            o = scan.nextByte();
            if(o>0 && o<=4){
                // Tambien depende de si sufren el efecto de paralisis, que reduce la mitad la velocidad
                // Tu primero
                if((yours.getState()==State.PARA?yours.actualstat.spd*0.5:yours.actualstat.spd)>(enemy.getState()==State.PARA?enemy.actualstat.spd*0.5:enemy.actualstat.spd)){
                    miMoveset[o-1].attack(yours, enemy);
                    System.out.print(yours.getName());
                    miMoveset[o-1].print();
                    enemy.randomMove(yours);
                }
                // El enemigo primero
                else{
                    enemy.randomMove(yours);
                    miMoveset[o-1].attack(yours, enemy);
                    System.out.print(yours.getName());
                    miMoveset[o-1].print();
                }
            }
            enemy.isSufferingPoison();
            yours.isSufferingPoison();
        }while(o!=0 && enemy.getHp()>0 && yours.getHp()>0);
    }
    
    // Asigna los datos base de los Pokemon que ofrece el programa, se pueden
    // agregar más, con estadísticas y datos variados, depende del
    // programador El juego asigna de forma aleatorea esta selección de
    // Pokemon, además de una selección de movimientos variados
    // Ambos asignados tanto para el pokemon del usuario, 
    // como para el pokemon del enemigo
    public static void assignData(){
        List<Pokemon> pkmnCollection = new ArrayList<>();
        pkmnCollection.add(new Pokemon(new Stats(55, 30, 35, 90), "Pikachu", new Stats(new Random().nextInt(16), new Random().nextInt(16), new Random().nextInt(16), new Random().nextInt(16)), random.nextInt(100)+1));
        pkmnCollection.add(new Pokemon(new Stats(55, 30, 35, 90), "Pikachu", new Stats(new Random().nextInt(16), new Random().nextInt(16), new Random().nextInt(16), new Random().nextInt(16)), random.nextInt(100)+1));
        pkmnCollection.add(new Pokemon(new Stats(55, 30, 35, 90), "Pikachu", new Stats(new Random().nextInt(16), new Random().nextInt(16), new Random().nextInt(16), new Random().nextInt(16)), random.nextInt(100)+1));
        pkmnCollection.add(new Pokemon(new Stats(60, 43, 39, 65), "Charmander", new Stats(random.nextInt(16), random.nextInt(16), random.nextInt(16), random.nextInt(16)), random.nextInt(100)+1));
        pkmnCollection.add(new Pokemon(new Stats(49, 49, 45, 45), "Bulbasaur", new Stats(random.nextInt(16), random.nextInt(16), random.nextInt(16), random.nextInt(16)), random.nextInt(100)+1));
        pkmnCollection.add(new Pokemon(new Stats(48, 65, 44, 43), "Squirtle", new Stats(random.nextInt(16), random.nextInt(16), random.nextInt(16), random.nextInt(16)), random.nextInt(100)+1));

        List<Move> allMoves = new ArrayList<>();
        allMoves.add(new Toxic());
        allMoves.add(new Tackle());
        allMoves.add(new Pound());
        allMoves.add(new Acid());
        allMoves.add(new BodySlam());
        
        yours = pkmnCollection.get(random.nextInt(pkmnCollection.size()));
        enemy = pkmnCollection.get(random.nextInt(pkmnCollection.size()));
        
        Move[] newMoveset = new Move[4];
        for(int i=0; i<newMoveset.length; i++)
            newMoveset[i] = allMoves.get(random.nextInt(allMoves.size()));
        yours.assignMoves( newMoveset );
        for(int i=0; i<newMoveset.length; i++)
            newMoveset[i] = allMoves.get(random.nextInt(allMoves.size()));
        enemy.assignMoves( newMoveset );
    }
}
