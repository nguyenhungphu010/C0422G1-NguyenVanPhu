package case_study_3.model;

public abstract class Customer {
    private final static String PATTERN = "dd-MM-yyyy";
    private final static String COMMA = ",";
    private String name;
    private String customerID;
    private double consumption;

    public Customer() {
    }

    public Customer(String name, String customerID, double consumption) {
        this.name = name;
        this.customerID = customerID;
        this.consumption = consumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public String convertLine(){
        String line = this.name + COMMA  + this.customerID + COMMA + this.consumption;
        return line;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", customerID='" + customerID + '\'' +
                '}';
    }
}
