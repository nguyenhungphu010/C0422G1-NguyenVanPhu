package case_study_4.model;

public abstract class Person {
    private final static String COMMA = ",";
    private String Id;
    private String name;
    private String dayOfBirth;
    private String address;
    private String phoneNumber;

    public Person(String id, String name, String dayOfBirth, String address, String phoneNumber) {
        Id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String convertLine(){
        String line = this.Id+ COMMA +  this.name + COMMA  + this.dayOfBirth + COMMA + this.address + COMMA + this.phoneNumber;
        return line;
    }
    @Override
    public String toString() {
        return "Person{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
