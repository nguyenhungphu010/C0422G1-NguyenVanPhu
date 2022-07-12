package case_study_4.controller;


import case_study_4.common.CheckException;
import case_study_4.service.implement.EmployeeServieImpl;
import case_study_4.service.implement.StudentServiceImpl;

import java.util.Scanner;

public class CodeGymController {
    static Scanner scanner = new Scanner(System.in);
    private static EmployeeServieImpl employeeServie = new EmployeeServieImpl();
    private static StudentServiceImpl studentService = new StudentServiceImpl();

    public static void displayMainMenu() {
        while (true) {
            System.out.println("Welcome to CodeGym Manager function: ");
            System.out.println("please choose the function:");
            System.out.println("1.Adding new Person" +
                    "\n2.Delete Person" +
                    "\n3.Display Person " +
                    "\n4.Exit");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    addingPersonMenu();
                    break;
                case 2:
                    deletePersonMenu();
                    break;
                case 3:
                    displayPersonMenu();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choose again");
            }
        }
    }

    public static void addingPersonMenu() {
        while (true) {
            System.out.println("please choose Adding Person function:");
            System.out.println("1.Adding new Employee" +
                    "\n2.Adding new Student" +
                    "\n3.Return to main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    employeeServie.add();
                    employeeServie.display();
                    break;
                case 2:
                    studentService.add();
                    studentService.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choose again");
            }
        }
    }

    public static void displayPersonMenu() {
        while (true) {
            System.out.println("please choose Display Person function:");
            System.out.println("1.Display Employee" +
                    "\n2.Display Student" +
                    "\n3.Return to main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    employeeServie.display();
                    break;
                case 2:
                    studentService.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choose again");
            }
        }
    }

    public static void deletePersonMenu() {
        while (true) {
            System.out.println("please choose Delete Person function:");
            System.out.println("1.Delete Employee" +
                    "\n2.Delete Student" +
                    "\n3.Return to main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    employeeServie.delete();
                    employeeServie.display();
                    break;
                case 2:
                    studentService.delete();
                    studentService.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choose again");
            }
        }
    }
}
