package case_study_3.model;

public abstract class Person {
    private final static String PATTERN = "dd-MM-yyyy";
    private final static String COMMA = ",";
    private String name;
    private String customerID;

    public Person() {
    }

    public Person(String name, String IDNumber) {
        this.name = name;
        this.customerID = IDNumber;
    }


    public String convertLine(){
        String line = this.name + COMMA  + this.customerID + COMMA ;
        return line;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", customerID='" + customerID + '\'' +
                '}';
    }
}
