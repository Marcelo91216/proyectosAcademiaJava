package clases;

public class DatabaseConfig {

    private String name;
    private String lang;
    private String port;

    public DatabaseConfig() {
        this.name = "Database";
        this.lang = "MySQL";
        this.port = "8080";
    }

    // se establece el nombre
    public void setName(String name) {
        System.out.println("> Nombre de la base de datos cambiado...");
        this.name = name;
    }

    // se establece el lenguaje de programacion
    public void setLang(String lang) {
        System.out.println("> Lenguaje de programacion para la base de datos cambiado...");
        this.lang = lang;
    }

    // se establece el puerto de conexion
    public void setPort(String port) {
        System.out.println("> Puerto para la base de datos cambiado...");
        this.port = port;
    }

    @Override
    public String toString() {
        return "> Showing database config info...\nname: " + this.name + "\nlanguage: " + this.lang + "\non port: " + this.port;
    }
}
