package di;

public class OrdenarObjetos implements Tarea {
    // Plantilla para realizar las diferentes tareas
    @Override
    public void realizarAccion(){
        System.out.println("> El empleado robot comenzará a ordenar los objetos del almacen.");
    }
}
