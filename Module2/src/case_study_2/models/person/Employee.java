package case_study_2.models.person;

public class Employee extends Person {
    private final static String COMMA = ",";
    private String eID;
    private String education;
    private String level;
    private Double salary;


    public Employee() {
        //
    }

    public Employee(String name, String dayOfBirth, String sex, String IDNumber, String phoneNumber, String email, String eID, String education, String level, Double salary) {
        super(name, dayOfBirth, sex, IDNumber, phoneNumber, email);
        this.eID = eID;
        this.education = education;
        this.level = level;
        this.salary = salary;
    }

    public String geteID() {
        return eID;
    }

    public void seteID(String eID) {
        this.eID = eID;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String convertLine() {
        return super.convertLine() + COMMA + this.eID + COMMA + this.education + COMMA + this.level + COMMA + this.salary;

    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "eID='" + eID + '\'' +
                ", education='" + education + '\'' +
                ", level='" + level + '\'' +
                ", salary=" + salary +
                '}';
    }
}
