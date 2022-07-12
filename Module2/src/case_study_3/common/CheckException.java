package case_study_3.common;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CheckException {
    private static Scanner sc = new Scanner(System.in);


    public static int checkParseInteger() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Enter again: ");
            }
        }
        return value;
    }


    public static Double checkParseDouble() {
        Double value;
        while (true) {
            try {
                value = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Enter again: ");
            }
        }
        return value;
    }
//    private  static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    public static LocalDate checkBirthDay(String strDate){
//
//        LocalDate localDate = LocalDate.parse(strDate,formatter);
//        System.out.println(localDate);
//        return localDate;
//    }
//
//    public static void main(String[] args) {
//        int a = checkParseInteger();
//    }
}
