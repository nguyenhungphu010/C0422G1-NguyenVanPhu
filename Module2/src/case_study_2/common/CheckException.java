package case_study_2.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CheckException {
    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

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
