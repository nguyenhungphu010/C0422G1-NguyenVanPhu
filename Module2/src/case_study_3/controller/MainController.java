package case_study_3.controller;


import case_study_3.common.CheckException;
import case_study_3.service.implement.BillServiceImpl;
import case_study_3.service.implement.OverseaCustomerServiceImpl;
import case_study_3.service.implement.VietnamCustomerServiceImpl;

import java.util.Scanner;

public class MainController {
    private static  VietnamCustomerServiceImpl vietnamCustomerService = new VietnamCustomerServiceImpl();
   private static OverseaCustomerServiceImpl overseaCustomerService = new OverseaCustomerServiceImpl();
   private static BillServiceImpl billService = new BillServiceImpl();
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
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    addingCustomerMenu();
                    break;
                case 2:
                    displayCustomerMenu();
                    break;
                case 3:
                    searchingCustomerMenu();
                    break;
                case 4:
                    billService.add();
                    billService.display();
                    break;
                case 5:
                    billService.edit();
                    billService.display();
                    break;
                case 6:
                    billService.display();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("choose again");
            }
        }
    }
    public static void displayCustomerMenu() {
        while (true) {
            System.out.println("please choose the Customer function:");
            System.out.println("1.Display new Vietnam Customer" +
                    "\n2.Display new Oversea Customer" +
                    "\n3.Return to main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    vietnamCustomerService.display();
                    break;
                case 2:
                    overseaCustomerService.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choose again");
            }
        }
    }
    public static void addingCustomerMenu() {
        while (true) {
            System.out.println("please choose the Customer function:");
            System.out.println("1.Adding new Vietnam Customer" +
                    "\n2.Adding new Oversea Customer" +
                    "\n3.Return to main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    vietnamCustomerService.add();
                    vietnamCustomerService.display();
                    break;
                case 2:
                    overseaCustomerService.add();
                    overseaCustomerService.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choose again");
            }
        }
    }
    public static void searchingCustomerMenu() {
        while (true) {
            System.out.println("please choose the Customer function:");
            System.out.println("1.Searching new Vietnam Customer" +
                    "\n2.Searching new Oversea Customer" +
                    "\n3.Return to main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    vietnamCustomerService.search();
                    break;
                case 2:
                    overseaCustomerService.search();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choose again");
            }
        }
    }

}
