package di;

public class EmpleadoRobot {
    private Tarea tarea;
    private String nombre;
    
    public EmpleadoRobot(String nombre, Tarea tarea){
        this.nombre = nombre;
        this.tarea = tarea;
    }
    
    public void ejecutarTarea(){
        this.tarea.realizarAccion();
    }
    
    public String getName(){
        return this.nombre;
    }
    
    public void setName(String name){
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return "Empleado Robot: "+this.nombre+"\nTarea asignada: "+this.tarea.getClass().getSimpleName();
    }
}
