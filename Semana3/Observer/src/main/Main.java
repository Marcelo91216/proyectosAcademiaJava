package main;

import classes.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Server server = new Server();
        new CPU(server);
        new RAM(server);
        new Storage(server);
        new Sockets(server);

        System.out.println("# The server will launch some\nrandom actions on the server,\nso that we could demostrate\nthe limiters functionalities.\n");
        for (int i = 0; i < rand.nextInt(10) + 10; i++) {
            System.out.println("#"+(i+1)+" Case"+server);
            server.useServer();
        }
    }

}
