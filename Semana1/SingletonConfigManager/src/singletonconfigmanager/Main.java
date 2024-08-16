package singletonconfigmanager;

import clases.*;

public class Main {

    public static void main(String[] args) {
        ConfigManager configmanager = ConfigManager.getConfig();
        System.out.println(configmanager.getDBConfig());
        configmanager.setConection(true);
        System.out.println(configmanager.getDBConfig());
    }
}
