package clases;

public class ConfigManager {

    static private ConfigManager instance;
    private DatabaseConfig configDB;
    private boolean conectionUp;
    
    private ConfigManager() {
        this.configDB = new DatabaseConfig();
        this.conectionUp = false;
    }
    
    public static ConfigManager getConfig() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
    
    public void setConection() {
        if (conectionUp) {
            this.conectionUp = false;
            System.out.println("> Turning off service...");
        } else {
            this.conectionUp = true;
            System.out.println("> Turning on service...");
        }
    }
    
    public String getDBConfig() {
        return configDB.toString() + "\nconection " + (this.conectionUp ? "ON" : "OFF") + "\n~ ~ ~ ~ ~ ~ ~ ~";
    }
    
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
