package case_study_2.service.implement;

import case_study_2.common.*;
import case_study_2.models.person.Employee;
import case_study_2.service.EmployeeService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();
    private static final String FILE_PATH_EMPLOYEE = "Module2/src/case_study_2/common/data/employee.csv";
    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static String date1 = "26/12/1998";
    static String date2 = "05/10/1985";
    static String date3 = "30/09/1975";
    static String date4 = "23/08/1991";
    static String date5 = "16/07/2000";

    static {

        employeeList.add(new Employee("Nguyen Van A", date1, "Male",
                "201662082", "0905041936", "hungbinhnguyen1@gmail.com",
                "E001", "College", "Reception", 1000d));
        employeeList.add(new Employee("Nguyen Van B", date2, "Male",
                "201662083", "0905041937", "hungbinhnguyen2@gmail.com",
                "E002", "Graduated", "Waiter", 900d));
        employeeList.add(new Employee("Nguyen Thi A", date3, "Female",
                "201662084", "0905041938", "hungbinhnguyen2@gmail.com",
                "E003", "University", "Supervisor", 1200d));
        employeeList.add(new Employee("Nguyen Van D", date4, "Male",
                "201662034", "0905041934", "hungbinhnguyen6@gmail.com",
                "E004", "Master", "Director", 3000d));
        employeeList.add(new Employee("Nguyen Van A", date5, "Male",
                "201662085", "0905041948", "hungbinhnguyen7@gmail.com",
                "E006", "University", "Expert", 2500d));
    }
    @Override
    public void add() {
        employeeList = FileService.readEmployee(FILE_PATH_EMPLOYEE);
        System.out.println("Input the Employee name: ");
        String NewName = RegexService.checkRegexStringName();
        // add new Employee Date of Birth
        System.out.println("Input the Employee Day of Birth: ");
        boolean flag = true;
        String birthday = null;
        while (flag) {
            birthday = scanner.nextLine();
            if (DateOfBirthRegex.CheckDateOfBirth(birthday)) {
                flag = false;
            } else {
                System.out.println("Input again please! ");
            }
        }
        // Add new Sex of New Employee
        String newSex = PersonUtility.PersonSex();
        // add new employee ID Number.
        System.out.println("Input the Employee IDNumber: ");
        String newIDNumb = RegexService.checkRegexStringID(); 
        // add new employee new Phone number
        System.out.println("Input the Employee PhoneNumber: ");
        String newPhoneNumber = RegexService.checkRegexStringPhoneNumber();
        // add new employee new email;
        System.out.println("Input the Employee Email: ");
        String newEmail = RegexService.checkRegexStringEmail();
        // add new employee's new Employee ID
        System.out.println("Input the Employee ID: ");
        String newEID =RegexService.checkRegexStringEID();
        // Add new Employee Education
        String newEducation = PersonUtility.EmployeeEducation();
        // Add new Level to Employee.
        String newLevel = PersonUtility.EmployeeLevel();
        // add new Salary.
        System.out.println("Input the Employee Salary: ");
        Double newSalary = Double.parseDouble(scanner.nextLine());
        employeeList.add(new Employee(NewName, birthday, newSex, newIDNumb, newPhoneNumber, newEmail, newEID, newEducation,
                newLevel, newSalary));

        FileService.writeEmployee(FILE_PATH_EMPLOYEE,employeeList);

    }
    @Override
    public void display() {
        employeeList = FileService.readEmployee(FILE_PATH_EMPLOYEE);
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }
    @Override
    public void edit() {
        System.out.println("Input the Employee ID to edit: ");
        boolean flag = false;
        int index = 0;
        String employmentID = RegexService.checkRegexStringEID();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).geteID().contains(employmentID)) {
                flag = true;
                index = i;
            }
        }
        if (flag) {
            System.out.println("Input the new Employee name: ");
            String newName = RegexService.checkRegexStringName(); 
            employeeList.get(index).setName(newName);
            // Edit date of Birth
            System.out.println("Input the Employee Day of Birth: ");
            String birthday = scanner.nextLine();
            DateOfBirthRegex.CheckDateOfBirth(birthday);
            employeeList.get(index).setDayOfBirth(birthday);
            // Edit Employee Sex
            String newSex = PersonUtility.PersonSex();
            employeeList.get(index).setSex(newSex);
            //ID number
            System.out.println("Input the Employee IDNumber: ");
            String newIDNumb = RegexService.checkRegexStringID(); 
            employeeList.get(index).setIDNumber(newIDNumb);
            // Phone Number
            System.out.println("Input the Employee PhoneNumber: ");
            String newPhoneNumber = RegexService.checkRegexStringPhoneNumber(); 
            employeeList.get(index).setPhoneNumber(newPhoneNumber);
            // email
            System.out.println("Input the Employee Email: ");
            String newEmail = RegexService.checkRegexStringEmail(); 
            employeeList.get(index).setEmail(newEmail);
            // Employment ID
            System.out.println("Input the Employment ID: ");
            String newEID = RegexService.checkRegexStringEID();
            employeeList.get(index).seteID(newEID);
            // Employee Education
            String newEducation = PersonUtility.EmployeeEducation();
            employeeList.get(index).setEducation(newEducation);
            // Employee Level
            String newLevel = PersonUtility.EmployeeLevel();
            employeeList.get(index).setLevel(newLevel);
            // Employee Salary
            System.out.println("Input the Employee Salary: ");
            Double newSalary = CheckException.checkParseDouble();
            employeeList.get(index).setSalary(newSalary);
            FileService.writeEmployee(FILE_PATH_EMPLOYEE,employeeList);
        } else
            System.out.println("Input the wrong Employee ID");
    }
}
