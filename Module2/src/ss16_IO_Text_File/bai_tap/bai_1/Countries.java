package ss16_IO_Text_File.bai_tap.bai_1;

public class Countries {
    private int id;
    private String code;
    private String name;

    public Countries() {
    }

    public Countries(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInforToCSV (){
        String result ;
        result = id + " " + code + " " + name;
        return result;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
