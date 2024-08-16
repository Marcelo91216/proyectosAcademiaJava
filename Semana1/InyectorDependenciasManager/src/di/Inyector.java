package di;

public class Inyector {
    public static EmpleadoRobot inyectarTarea(Tarea t, EmpleadoRobot er){
        return new EmpleadoRobot(er.getName(), t);
    }
}
