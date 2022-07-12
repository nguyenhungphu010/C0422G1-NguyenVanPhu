package case_study_4.model;

public class Employee extends Person{
    private final static String COMMA = ",";
    private double salary;
    private String department;
    private String position;

    public Employee(String id, String name, String dayOfBirth, String address, String phoneNumber, double salary, String department, String position) {
        super(id, name, dayOfBirth, address, phoneNumber);
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    public Employee() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String convertLine() {
        return super.convertLine() + COMMA + this.salary + COMMA + this.department + COMMA + this.position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "salary=" + salary +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
