package di;

public class Inyector {
    // Se encarga de inyectar una tarea que recibe y el empleado a quien inyectarsela
    public static EmpleadoRobot inyectarTarea(Tarea t, EmpleadoRobot er){
        return new EmpleadoRobot(er.getName(), t);
    }
}
