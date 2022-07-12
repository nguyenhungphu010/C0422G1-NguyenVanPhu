package case_study_4.common;

import java.text.SimpleDateFormat;
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
}
