package case_study_2.models;

import java.util.Date;

public class Customer extends Person{
    private String cID;
    private String rank;
    private String address;

    public Customer() {
    }

    public Customer(String name, String dayOfBirth, String sex, String IDNumber, String phoneNumber, String email, String cID, String rank, String address) {
        super(name, dayOfBirth, sex, IDNumber, phoneNumber, email);
        this.cID = cID;
        this.rank = rank;
        this.address = address;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "cID='" + cID + '\'' +
                ", rank='" + rank + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
