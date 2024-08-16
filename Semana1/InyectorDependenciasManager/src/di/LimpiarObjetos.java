package di;

public class LimpiarObjetos implements Tarea {
    @Override
    public void realizarAccion(){
        System.out.println("> El empleado robot ha comenzado a limpiar los pisos de los cuartos.");
    }
}
