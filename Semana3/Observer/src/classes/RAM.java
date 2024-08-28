package classes;

import java.util.Objects;

public class RAM implements Limiter {
    private final int limit = 16;
    private Subject subject;

    @Override
    public void update() {
        if (subject instanceof Server) {
            Server server = (Server) subject;
            if (server.getRamUse()>= limit) {
                subject.reset();
            } else if (server.getRamUse()>= limit * .80) {
                alert();
            }
        }
    }

    @Override
    public void alert() {
        System.out.println("Your use of RAM Memory is near to the limit!!!");

    }

    public RAM(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public RAM() {
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
        final RAM other = (RAM) obj;
        if (this.limit != other.limit) {
            return false;
        }
        return Objects.equals(this.subject, other.subject);
    }

}
