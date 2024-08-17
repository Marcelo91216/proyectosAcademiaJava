package clases;

public class ConfigManager {

    static private ConfigManager instance;
    private DatabaseConfig configDB;
    private boolean conectionUp;
    
    private ConfigManager() {
        this.configDB = new DatabaseConfig();
        this.conectionUp = false;
    }
    
    // Se retorna la instancia del administrador de configuraciones
    public static ConfigManager getConfig() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
    
    // Se enciende/apaga la conexion a la base de datos, depende del estado anterior
    public void setConection() {
        if (conectionUp) {
            this.conectionUp = false;
            System.out.println("> Turning off service...");
        } else {
            this.conectionUp = true;
            System.out.println("> Turning on service...");
        }
    }
    
    // Se retorna una descripcion de la configuracion de la base de datos
    public String getDBConfig() {
        return configDB.toString() + "\nconection " + (this.conectionUp ? "ON" : "OFF") + "\n~ ~ ~ ~ ~ ~ ~ ~";
    }
    
    // Retorna booleano dependiendo de la conexion a la base de datos esta encendida
    public boolean isConectionOn() {
        return this.conectionUp;
    }
    
    public void setName(String name) {
        configDB.setName(name);
    }
    
    public void setLang(String lang) {
        configDB.setLang(lang);
    }
    
    public void setPort(String port) {
        configDB.setPort(port);
    }
}
