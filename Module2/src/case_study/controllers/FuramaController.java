package case_study.controllers;

import java.util.Scanner;

public class FuramaController {
    public static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {
        while (true) {
            System.out.println("Welcome to Furama Resort Manager function: ");
            System.out.println("please choose the function:");
            System.out.println("1.\tEmployee Management" +
                    "2.\tCustomer Management" +
                    "3.\tFacility Management " +
                    "4.\tBooking Management" +
                    "5.\tPromotion Management" +
                    "6.\tExit");
            int choice = Integer.parseInt(scanner.nextLine());
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

            }
        }
    }

    public static void DisplayEmployeeManager() {
        while (true) {
            System.out.println("Welcome to Furama Resort Employee Manager function: ");
            System.out.println("Please choose the function:");
            System.out.println("1.\t Display List Employee " +
                    "2.\tAdd new employee" +
                    "3.\tEdit employee " +
                    "4.\tReturn main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
            }
        }


    }

    public static void DisplayCustomerManager() {
        while (true) {
            System.out.println("Welcome to Furama Resort Customer Manager function: ");
            System.out.println("Please choose the function:");
            System.out.println("1.\t Display List Customer " +
                    "2.\tAdd new customer" +
                    "3.\tEdit customer " +
                    "4.\tReturn main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
            }
        }

    }

    public static void DisplayFacilityManager() {
        while (true) {
            System.out.println("Welcome to Furama Resort Facility Manager function: ");
            System.out.println("Please choose the function:");
            System.out.println("1.\t Display List Facility " +
                    "2.\tAdd new facility " +
                    "3.\tEdit facility" +
                    "4.\tReturn main menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
            }
        }

    }

    public static void DisplayBookingManager() {
        while (true) {
            System.out.println("Welcome to Furama Resort Booking Manager function: ");
            System.out.println("Please choose the function:");
            System.out.println("1.\t Adding new booking" +
                    "2.\tDisplay list booking" +
                    "3.\tCreate new contracts" +
                    "4.\tDisplay list contracts" +
                    "5.\tEdit contracts" +
                    "6.\tReturn main menu");
            int choice = Integer.parseInt(scanner.nextLine());
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
            System.out.println("1.\tDisplay list customers use service" +
                    "2.\tDisplay list customers get voucher" +
                    "3.\tReturn main menu");
            int choice = Integer.parseInt(scanner.nextLine());
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

