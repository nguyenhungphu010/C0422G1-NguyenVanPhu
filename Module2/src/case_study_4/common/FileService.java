package case_study_4.common;


import case_study_4.model.Employee;
import case_study_4.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private final static String COMMA = ",";
    private final static String PATTERN = "dd/MM/yyyy";

    // write to file;
    private static void writeToFile(String pathFile, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = null;
            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeEmployee(String pathFile, List<Employee> employeeList) {
        List<String> list = new ArrayList<>();
        for (Employee e : employeeList
        ) {
            // đổi dữ liệu thành dạng String ArrayList để ghi vào file
            list.add(e.convertLine());
        }
        writeToFile(pathFile, list);
    }

    public static void writeStudent(String pathFile, List<Student> studentList) {
        List<String> list = new ArrayList<>();
        for (Student c : studentList) {
            list.add(c.convertLine());
        }
        writeToFile(pathFile, list);
    }


    // read from file:
    public static List<String> readFile(String pathFile) {
        File file = new File(pathFile);
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null && !line.equals("")) {
                    list.add(line);
                } else {
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Employee> readEmployee(String pathFile) {
        List<String> list = readFile(pathFile);
        List<Employee> employeeList = new ArrayList<>();
        String[] lines = null;
        for (String s : list) {
            lines = s.split(COMMA);
            employeeList.add(new Employee(lines[0], lines[1], lines[2], lines[3], lines[4], Double.parseDouble(lines[5]), lines[6], lines[7]));
        }
        return employeeList;
    }

    public static List<Student> readStudent(String pathFile) {
        List<String> list = readFile(pathFile);
        List<Student> studentList = new ArrayList<>();
        String[] lines = null;
        for (String s : list
        ) {
            lines = s.split(COMMA);
            studentList.add(new Student(lines[0], lines[1], lines[2], lines[3], lines[4], Integer.parseInt(lines[5]), lines[6], lines[7]));
        }
        return studentList;
    }

}
