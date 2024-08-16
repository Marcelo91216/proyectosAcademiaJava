package singletonconfigmanager;

import clases.*;
import java.util.Scanner;

public class Main {

    static char o = 1;

    public static void main(String[] args) {
        ConfigManager configmanager = ConfigManager.getConfig();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al administrador de configuraciones ConfigManager!!!");
        do {
            System.out.println("________\nAcciones que puede realizar\n0 -> salir o terminar, 2 -> checar configuración actual, 3 -> apagar/encender conexión, 4 -> cambiar nombre de la base de datos, 5 -> cambiar el lenguaje de la base de datos, 6 -> cambiar el numero de puerto serie");
            System.out.println("El servicio esta "+(configmanager.isConectionOn()?"activo":"inactivo"));
            if (!scanner.hasNextByte()) {
                System.out.println("!!Introduzca un número válido!!");
                scanner.next();
                continue;
            }
            o = (char) scanner.nextByte();

            switch (o) {
                case 2: {
                    System.out.println(configmanager.getDBConfig());
                    break;
                }
                case 3: {
                    configmanager.setConection();
                    break;
                }
                case 4: {
                    System.out.print("Nombre de la base de datos: ");
                    String name;
                    name = scanner.next();
                    configmanager.setName(name);
                    break;
                }
                case 5: {
                    System.out.print("Lenguaje para la base de datos: ");
                    String lang;
                    lang = scanner.next();
                    configmanager.setLang(lang);
                    break;
                }
                case 6: {
                    System.out.print("Puerto para la base de datos: ");
                    String port;
                    port = scanner.next();
                    configmanager.setPort(port);
                    break;
                }
            }
        } while (o != 0);
        System.out.println("Bye bye!!");
    }
}
