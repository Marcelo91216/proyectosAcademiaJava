package di;

public class HacerNada implements Tarea {
    @Override
    public void realizarAccion(){
        System.out.println("> El empleado robot no hace nada, a espera de ordenes...");
    }
}
