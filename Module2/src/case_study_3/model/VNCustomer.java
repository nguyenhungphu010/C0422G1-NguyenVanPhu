package case_study_3.model;

public class VNCustomer extends Customer {
    private final static String COMMA = ",";
    private  String customerRank;


    public VNCustomer() {
    }


    public VNCustomer(String customerRank) {
        this.customerRank = customerRank;
    }

    public VNCustomer(String name, String customerID, double consumption, String customerRank) {
        super(name, customerID, consumption);
        this.customerRank = customerRank;
    }

    public String getCustomerRank() {
        return customerRank;
    }

    public void setCustomerRank(String customerRank) {
        this.customerRank = customerRank;
    }



    @Override
    public String convertLine() {
        return super.convertLine() +COMMA+ this.customerRank + COMMA + this.customerRank;
    }

    @Override
    public String toString() {
        return "VNCustomer{" +
                super.toString() +
                "customerRank='" + customerRank + '\'' +
                '}';
    }
}
