package case_study_3.controller;


import case_study_3.common.BillCheckException;

import java.util.Scanner;

public class BillController {
    static Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu() {
        while (true) {
            System.out.println("Welcome to Electrical Bills Manager function: ");
            System.out.println("please choose the function:");
            System.out.println("1.Adding new Customer" +
                    "\n2.Display Customer" +
                    "\n3.Searching Customer " +
                    "\n4.Adding new Bill" +
                    "\n5.Edit Bill" +
                    "\n6.Display Bill" +
                    "\n7.Exit");
            int choice = BillCheckException.checkParseInteger();
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
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choose again");
            }
        }
    }
}
