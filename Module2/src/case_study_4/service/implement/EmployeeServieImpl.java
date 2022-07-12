package case_study_4.service.implement;

import case_study_4.common.CheckException;
import case_study_4.common.DateRegex;
import case_study_4.common.FileService;
import case_study_4.common.RegexService;
import case_study_4.model.Employee;
import case_study_4.service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServieImpl implements IEmployeeService {
    private static final String FILE_PATH_EMPLOYEE = "Module2/src/case_study_4/common/data/employee_record.csv";
    static List<Employee> employeeList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        // Read File
        employeeList = FileService.readEmployee(FILE_PATH_EMPLOYEE);
        System.out.println("Input the Employee ID: ");
        String employeeID = RegexService.checkRegexStringEmployeeID();
        System.out.println("Input the Employee name: ");
        String newName = RegexService.checkRegexStringName();
        System.out.println("Input the Employee Day of Birth: ");
        boolean flag = true;
        String birthDay = null;
        while (flag) {
            birthDay = scanner.nextLine();
            if (DateRegex.CheckDateOfBirth(birthDay)){
                flag = false;
            }
            else {
                System.out.println("Input again please! ");
            }
        }
        System.out.println("Input the Employee address: ");
        String address = scanner.nextLine();
        System.out.println("Input the Employee phoneNumber: ");
        String phone = RegexService.checkRegexStringPhoneNumber();
        System.out.println("Input the Employee salary: ");
        double salary = CheckException.checkParseDouble();
        System.out.println("Input the Employee Department: ");
        String department = scanner.nextLine();
        System.out.println("Input the Employee position: ");
        String position = scanner.nextLine();
        employeeList.add(new Employee(employeeID, newName, birthDay, address, phone, salary, department, position));
        FileService.writeEmployee(FILE_PATH_EMPLOYEE, employeeList);
        // Write File

    }

    @Override
    public void delete() {
        employeeList = FileService.readEmployee(FILE_PATH_EMPLOYEE);
        System.out.println("Input the Employee ID: ");
        String IdInfor = scanner.nextLine();
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().contains(IdInfor)) {
                flag = true;
                index = i;
            } else
                flag = false;
        }
        if (flag) {
            System.out.println("Are you sure to delete this Employee: ");
            System.out.println("1. Yes " +
                    "\n2. No");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    employeeList.remove(index);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Enter again:");
            }
            FileService.writeEmployee(FILE_PATH_EMPLOYEE, employeeList);
        } else {
            System.out.println("Please input the ID again:");
        }
    }

    @Override
    public void display() {
        // read File;
        employeeList = FileService.readEmployee(FILE_PATH_EMPLOYEE);
        for (Employee e : employeeList
        ) {
            System.out.println(e);
        }
    }
}
