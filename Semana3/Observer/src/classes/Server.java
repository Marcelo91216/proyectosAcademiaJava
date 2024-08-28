package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server implements Subject {
    private int cpuUse;
    private int ramUse;
    private int storageUse;
    private int socketsOpened;
    private List<Limiter> limiters;

    public Server() {
        cpuUse=0;
        ramUse=0;
        socketsOpened=0;
        storageUse=0;
        limiters = new ArrayList<>();
    }

    public int getCpuUse() {
        return cpuUse;
    }

    public int getRamUse() {
        return ramUse;
    }

    public int getStorageUse() {
        return storageUse;
    }

    public int getSocketsOpened() {
        return socketsOpened;
    }
    
    @Override
    public void update() {
        limiters.stream().forEach(Limiter::update);
    }

    @Override
    public void attach(Limiter l) {
        limiters.add(l);
    }

    @Override
    public void detach(Limiter l) {
        limiters.remove(l);
    }
    
    public void useServer(){
        Random rand = new Random();
        cpuUse += rand.nextInt(2)+1;
        ramUse += rand.nextInt(3);
        storageUse += rand.nextInt(50)+50;
        socketsOpened += rand.nextInt(20)+10;
        update();
    }

    @Override
    public void reset() {
        cpuUse=0;
        ramUse=0;
        storageUse=0;
        socketsOpened=0;
    }

    @Override
    public String toString() {
        return "> Server{" + "cpuUse=" + cpuUse + ", ramUse=" + ramUse + "\n, storageUse=" + storageUse + ", socketsOpened=" + socketsOpened + '}';
    }
    
    
}
