package case_study_4.model;

public class Student extends Person{
    private final static String COMMA = ",";
    private int point;
    private String className;
    private String dayEnroll;

    public Student(String id, String name, String dayOfBirth, String address, String phoneNumber, int point, String className, String dayEnroll) {
        super(id, name, dayOfBirth, address, phoneNumber);
        this.point = point;
        this.className = className;
        this.dayEnroll = dayEnroll;
    }

    public Student() {
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDayEnroll() {
        return dayEnroll;
    }

    public void setDayEnroll(String dayEnroll) {
        this.dayEnroll = dayEnroll;
    }

    @Override
    public String convertLine() {
        return super.convertLine() + COMMA + this.point + COMMA + this.className + COMMA+ this.dayEnroll;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "point=" + point +
                ", className='" + className + '\'' +
                ", dayEnroll='" + dayEnroll + '\'' +
                '}';
    }
}
