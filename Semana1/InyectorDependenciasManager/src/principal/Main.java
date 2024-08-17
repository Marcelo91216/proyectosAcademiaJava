package principal;

import java.util.Scanner;
import di.*;

public class Main {

    static Scanner scan;
    static int o;
    static EmpleadoRobot er;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        o = 1;
        er = new EmpleadoRobot("Empleado Robot", new HacerNada());
        userIn();
        System.out.println("Fin del servicio, Bye bye!");
    }

    // Recibe entradas del usuario, y lo situa en un ciclo sin fin, hasta que el usuario indique terminar
    public static void userIn() {
        do {
            System.out.println("Eliga una de las opciones\n0 -> salir | 2 -> ver tarea asignada | 3 -> realizar tarea | 4 -> hacer nada\n5 -> limpiar inventario | 6 -> ordenar objetos");
            if (!scan.hasNextByte()) {
                System.out.println("Escriba un dato valido por favor.");
                scan.next();
                continue;
            }
            o = scan.nextByte();

            switch (o) {
                case 2: {
                    System.out.println(er);
                    break;
                }
                case 3: {
                    er.ejecutarTarea();
                    break;
                }
                case 4: {
                    er = Inyector.inyectarTarea(new HacerNada(), er);
                    System.out.println("$ La tarea ha sido inyectada.");
                    break;
                }
                case 5: {
                    er = Inyector.inyectarTarea(new LimpiarObjetos(), er);
                    System.out.println("$ La tarea ha sido inyectada.");
                    break;
                }
                case 6: {
                    er = Inyector.inyectarTarea(new OrdenarObjetos(), er);
                    System.out.println("$ La tarea ha sido inyectada.");
                    break;
                }
            }

        } while (o != 0);
    }
}
