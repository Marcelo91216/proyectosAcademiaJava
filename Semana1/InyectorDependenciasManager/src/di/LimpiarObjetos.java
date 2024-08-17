package di;

public class LimpiarObjetos implements Tarea {
    // Imprime la accion del empleado, en este caso limpiando
    @Override
    public void realizarAccion(){
        System.out.println("> El empleado robot ha comenzado a limpiar los pisos de los cuartos.");
    }
}
