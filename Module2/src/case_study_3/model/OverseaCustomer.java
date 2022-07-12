package case_study_3.model;

public class OverseaCustomer extends Customer {
    private final static String COMMA = ",";
    private String nationality;


    public OverseaCustomer() {
    }

    public OverseaCustomer(String nationality) {
        this.nationality = nationality;
    }

    public OverseaCustomer(String name, String customerID, double consumption, String nationality) {
        super(name, customerID, consumption);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String convertLine() {
        return super.convertLine() +COMMA+ this.nationality;
    }

    @Override
    public String toString() {
        return "OverseaCustomer{" +
                super.toString() +
                "nationality='" + nationality + '\'' +
                '}';
    }
}
