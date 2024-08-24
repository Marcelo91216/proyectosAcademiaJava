package pkg;

public class Company {

    String name;
    String location;

    public Company(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("[Company: %s, Location: %s]", this.name, this.location);
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

}
