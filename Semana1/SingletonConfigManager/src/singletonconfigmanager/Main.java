package singletonconfigmanager;

import clases.*;
import java.util.Scanner;

public class Main{
    static char o = 1;
    
    public static void main(String[] args) {
        ConfigManager configmanager = ConfigManager.getConfig();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al administrador de configuraciones ConfigManager!!!");
        do{
            System.out.println("Acciones que puede realizar\n0 -> salir o terminar, ");
            if(!scanner.hasNextByte())
                break;
            o = (char)scanner.nextByte();
        }while(o!=0);
        
    }
}
