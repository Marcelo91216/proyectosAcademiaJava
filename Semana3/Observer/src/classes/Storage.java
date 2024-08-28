package classes;

import java.util.Objects;

public class Storage implements Limiter {
    private final int limit = 512;
    private Subject subject;

    @Override
    public void update() {
        if (subject instanceof Server) {
            Server server = (Server) subject;
            if (server.getStorageUse()>= limit) {
                subject.reset();
            } else if (server.getStorageUse()>= limit * .80) {
                alert();
            }
        }
    }

    @Override
    public void alert() {
        System.out.println("Your use of Storage Memory is near to the limit!!!");

    }

    public Storage(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public Storage() {
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
        final Storage other = (Storage) obj;
        if (this.limit != other.limit) {
            return false;
        }
        return Objects.equals(this.subject, other.subject);
    }

}
