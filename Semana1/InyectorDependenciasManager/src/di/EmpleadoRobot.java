package di;

public class EmpleadoRobot {
    private Tarea tarea;
    private String nombre;

    // Constructor que recibe un nombre nuevo y una tarea inicial    
    public EmpleadoRobot(String nombre, Tarea tarea){
        this.nombre = nombre;
        this.tarea = tarea;
    }
    
    // Realiza su tarea asignada
    public void ejecutarTarea(){
        this.tarea.realizarAccion();
    }
    
    // Recibe el nombre del empleado robot
    public String getName(){
        return this.nombre;
    }
    
    // Modifica el nombre del empleado robot
    public void setName(String name){
        this.nombre = nombre;
    }
    
    // Sobre escribe la funcion de la clase Object para retornar un String especifico
    @Override
    public String toString(){
        return "Empleado Robot: "+this.nombre+"\nTarea asignada: "+this.tarea.getClass().getSimpleName();
    }
}
