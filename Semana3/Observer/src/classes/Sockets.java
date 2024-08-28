package classes;

import java.util.Objects;

public class Sockets implements Limiter {
    private final int limit = 100;
    private Subject subject;

    @Override
    public void update() {
        if (subject instanceof Server) {
            Server server = (Server) subject;
            if (server.getSocketsOpened()>= limit) {
                subject.reset();
            } else if (server.getSocketsOpened()>= limit * .80) {
                alert();
            }
        }
    }

    @Override
    public void alert() {
        System.out.println("Your use of Storage Memory is near to the limit!!!");

    }

    public Sockets(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public Sockets() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sockets other = (Sockets) obj;
        if (this.limit != other.limit) {
            return false;
        }
        return Objects.equals(this.subject, other.subject);
    }

}
