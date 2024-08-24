package pkg;

public abstract class Active {

    protected String name;
    protected String logNum;
    protected Company company;
    protected String desc;

    public Active(String name, Company company, String desc) {
        this.name = name;
        this.logNum = "";
        this.company = company;
        this.desc = desc;
    }

    public Company getCompany() {
        return company;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public String getLogNum() {
        return logNum;
    }

    @Override
    public String toString() {
        return String.format("-°-°-°-\n[%s] ID: %s\nCompany: %s\n%s", this.name, this.logNum, this.company, this.desc);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.name.length();
    }

}
