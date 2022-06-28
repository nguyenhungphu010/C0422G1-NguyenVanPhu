package ss17_file_serialization.thuc_hanh.bai_2_doc_ghi_danh_sach_file_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        studentList.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        studentList.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        studentList.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        studentList.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        String path = "Module2/src/ss17_file_serialization/thuc_hanh/studen.txt";
        writeToFile(path, studentList);
        List<Student> studentsDatafromFile = readDataFromFile(path);
        for (Student s: studentsDatafromFile
             ) {
            System.out.println(s);
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> studentList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
        return studentList;
    }

}
