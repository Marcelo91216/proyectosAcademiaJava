package clases;

public class DatabaseConfig {

    public String name;
    public String lang;
    public String port;

    public DatabaseConfig() {
        this.name = "Database";
        this.lang = "MySQL";
        this.port = "8080";
    }

    public DatabaseConfig(String name, String lang, String port) {
        this.name = name;
        this.lang = lang;
        this.port = port;
    }

    public void configureDatabase(DatabaseConfig newConfig) {
        this.name = newConfig.name;
        this.lang = newConfig.lang;
        this.port = newConfig.port;
    }
    
    @Override
    public String toString(){
        return "> Showing database config info...\nname: "+this.name+"\nlanguage: "+this.lang+"\non port: "+this.port;
    }
}
