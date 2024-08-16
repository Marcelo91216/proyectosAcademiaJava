package clases;

public class ConfigManager {
    static private ConfigManager instance;
    private DatabaseConfig configDB;
    private boolean conectionUp;
    
    private ConfigManager(){
        this.configDB = new DatabaseConfig();
        this.conectionUp = false;
    }
    
    public static ConfigManager getConfig(){
        if(instance==null)
            instance = new ConfigManager();
        return instance;
    }
    
    public void setConection(boolean conectionUp){
        if(conectionUp)
            System.out.println("> Turning on service...");
        else
            System.out.println("> Turning off service...");
        this.conectionUp = conectionUp;
    }
    
    public String getDBConfig(){
        return configDB.toString()+"\nconection "+(this.conectionUp?"ON":"OFF")+"\n~~~~~~~~";
    }
}
