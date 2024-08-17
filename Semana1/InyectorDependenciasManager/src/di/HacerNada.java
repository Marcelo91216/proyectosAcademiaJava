package di;

public class HacerNada implements Tarea {
    // Accion y clase por defecto del empleado robot
    @Override
    public void realizarAccion(){
        System.out.println("> El empleado robot no hace nada, a espera de ordenes...");
    }
}
