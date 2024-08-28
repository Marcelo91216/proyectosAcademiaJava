package classes;

import java.util.Objects;

public class CPU implements Limiter {

    private final int limit = 16;
    private Subject subject;

    @Override
    public void update() {
        if (subject instanceof Server) {
            Server server = (Server) subject;
            if (server.getCpuUse() >= limit) {
                subject.reset();
            } else if (server.getCpuUse() >= limit * .80) {
                alert();
            }
        }
    }

    @Override
    public void alert() {
        System.out.println("Your use of CPU is near to the limit!!!");

    }

    public CPU(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public CPU() {
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
        final CPU other = (CPU) obj;
        if (this.limit != other.limit) {
            return false;
        }
        return Objects.equals(this.subject, other.subject);
    }

}
