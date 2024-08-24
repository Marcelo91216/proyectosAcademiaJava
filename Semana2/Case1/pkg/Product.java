package pkg;

public class Product extends Active {

    private int count;

    public Product(int count, String name, Company company, String desc) {
        super(name, company, desc);
        this.count = count;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + this.count + " units";
    }

    public int getCount() {
        return count;
    }

    public void add() {
        this.count++;
    }

    public void substract() {
        this.count--;
    }
}
