package pkg;

public class Service extends Active {

    private String startDate;
    private String finalDate;
    private int incidents;

    public Service(String startDate, String finalDate, String name, Company company, String desc, int incidents) {
        super(name, company, desc);
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.incidents = incidents;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nStarts on %s, ends on %s", this.startDate, this.finalDate);
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}
