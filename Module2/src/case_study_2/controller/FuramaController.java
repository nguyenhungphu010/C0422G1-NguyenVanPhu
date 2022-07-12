package case_study_2.controller;

import case_study_2.common.CheckException;
import case_study_2.service.implement.CustomerServiceImpl;
import case_study_2.service.implement.EmployeeServiceImpl;
import case_study_2.service.implement.FacilityServiceImpl;


import java.util.Scanner;

public class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    static EmployeeServiceImpl employeeService = null;
    static CustomerServiceImpl customerService = null;
    static FacilityServiceImpl facilityService = null;

    public static void displayMainMenu() {
        while (true) {
            System.out.println("Welcome to Furama Resort Manager function: ");
            System.out.println("please choose the function:");
            System.out.println("1.Employee Management" +
                    "\n2.Customer Management" +
                    "\n3.Facility Management " +
                    "\n4.Booking Management" +
                    "\n5.Promotion Management" +
                    "\n6.Exit");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    DisplayEmployeeManager();
                    break;
                case 2:
                    DisplayCustomerManager();
                    break;
                case 3:
                    DisplayFacilityManager();
                    break;
                case 4:
                    DisplayBookingManager();
                    break;
                case 5:
                    DisplayPromotionManager();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choose again");
            }
        }
    }

    public static void DisplayEmployeeManager() {
        employeeService = new EmployeeServiceImpl();
        while (true) {
            System.out.println("Welcome to Furama Resort Employee Manager function: ");
            System.out.println("Please choose the function:");
            System.out.println("1.Display List Employee " +
                    "\n2.Add new employee" +
                    "\n3.Edit employee " +
                    "\n4.Return main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    employeeService.display();
                    break;
                case 2:
                    employeeService.add();
                    employeeService.display();
                    break;
                case 3:
                    employeeService.edit();
                    employeeService.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Choose again");
                    break;
            }
        }
    }

    public static void DisplayCustomerManager() {
        customerService = new CustomerServiceImpl();
        // linked list trả về dáng string.
        while (true) {
            System.out.println("Welcome to Furama Resort Customer Manager function: ");
            System.out.println("Please choose the function:");
            System.out.println("1.Display List Customer " +
                    "\n2.Add new customer" +
                    "\n3.Edit customer " +
                    "\n4.Return main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    customerService.display();
                    break;
                case 3:
                    customerService.edit();
                    customerService.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Choose again");
                    break;

            }
        }

    }

    public static void DisplayFacilityManager() {
        facilityService = new FacilityServiceImpl();
        while (true) {
            System.out.println("Welcome to Furama Resort Facility Manager function: ");
            System.out.println("Please choose the function:");
            System.out.println("1.Display List Facility " +
                    "\n2.Add new facility " +
                    "\n3.Display facility maintenance List" +
                    "\n4.Return main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    facilityService.displayNumberUsedOfService();
                    break;
                case 2:
                    addNewFacility();
                    facilityService.displayNumberUsedOfService();
                    break;
                case 3:
                    facilityService.displayMaintenance();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter the choice again: ");
            }
        }

    }
    public static void addNewFacility(){
        facilityService = new FacilityServiceImpl();
        while (true) {
            System.out.println("Facility service menu" + "\n" +
                    "1. Add new House" + "\n" +
                    "2. Add new Room" + "\n" +
                    "3. Add new Villa" + "\n" +
                    "4. Return main menu");
            System.out.println("Enter your choice");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    facilityService.addNewHouseService();
                    facilityService.displayNumberUsedOfService();
                    break;
                case 2:
                    facilityService.addNewRoomService();
                    facilityService.displayNumberUsedOfService();
                    break;
                case 3:
                    facilityService.addNewVillaService();
                    facilityService.displayNumberUsedOfService();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter your choice again:");
                    break;
            }
        }
    }

    public static void DisplayBookingManager() {
        while (true) {
            System.out.println("Welcome to Furama Resort Booking Manager function: ");
            System.out.println("Please choose the function:");
            System.out.println("1.Adding new booking" +
                    "\n2.Display list booking" +
                    "\n3.\tCreate new contracts" +
                    "\n4.Display list contracts" +
                    "\n5.Edit contracts" +
                    "\n6.Return main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
            }
        }

    }

    public static void DisplayPromotionManager() {
        while (true) {
            System.out.println("Welcome to Furama Resort Promotion Manager function: ");
            System.out.println("Please choose the function:");
            System.out.println("1.Display list customers use service" +
                    "\n2.Display list customers get voucher" +
                    "\n3.Return main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
            }
        }
    }
}
