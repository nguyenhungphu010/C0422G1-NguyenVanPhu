package case_study_4.service.implement;


import case_study_4.common.CheckException;
import case_study_4.common.DateRegex;
import case_study_4.common.FileService;
import case_study_4.common.RegexService;
import case_study_4.model.Student;
import case_study_4.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements IStudentService {
    private static final String FILE_PATH_STUDENT = "Module2/src/case_study_4/common/data/student_record.csv";
    static List<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    @Override
    public void add() {
        // read File;
        studentList = FileService.readStudent(FILE_PATH_STUDENT);
        System.out.println("Input the Student ID: ");
        String studentID = RegexService.checkRegexStringStudentID();
        System.out.println("Input the Student name: ");
        String newName = RegexService.checkRegexStringName();
        System.out.println("Input the Student Day of Birth: ");
        String birthDay = null;
        boolean flag = true;
        while (flag) {
            birthDay = scanner.nextLine();
            if (DateRegex.CheckDateOfBirth(birthDay)){
                flag = false;
            }
            else {
                System.out.println("Input again please! ");
            }
        }
        System.out.println("Input the Student address: ");
        String address = scanner.nextLine();
        System.out.println("Input the Student phonenumber: ");
        String phone = RegexService.checkRegexStringPhoneNumber();
        System.out.println("Input the Student point: ");
        int point = CheckException.checkParseInteger();
        System.out.println("Input the Student class: ");
        String className = scanner.nextLine();
        System.out.println("Input the Student Day of enrolling: ");
        String dayRolling = null;
        boolean flag1 = true;
        while (flag1) {
            dayRolling = scanner.nextLine();
            if (DateRegex.CheckDateEnroll(dayRolling)){
                flag1 = false;
            }
            else {
                System.out.println("Input again please! ");
            }
        }
        studentList.add(new Student(studentID,newName,birthDay,address,phone,point,className,dayRolling));
        FileService.writeStudent(FILE_PATH_STUDENT,studentList);
        // write file
    }

    @Override
    public void delete() {
        studentList = FileService.readStudent(FILE_PATH_STUDENT);
        System.out.println("Input the Student ID: ");
        String IdInfor = scanner.nextLine();
        boolean flag = false;
        int index = 0 ;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().contains(IdInfor)) {
                flag = true;
                index = i ;
            }else
                flag = false;
        }
        if (flag) {
            System.out.println("Are you sure to delete this Student: ");
            System.out.println("1. Yes " +
                    "\n2. No");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    studentList.remove(index);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Enter again");
            }

            FileService.writeStudent(FILE_PATH_STUDENT,studentList);
        }else {
            System.out.println("Please input the name again:");}

    }

    @Override
    public void display() {
        // read file
        studentList = FileService.readStudent(FILE_PATH_STUDENT);
        for (Student s: studentList
             ) {
            System.out.println(s);
        }
    }
}
