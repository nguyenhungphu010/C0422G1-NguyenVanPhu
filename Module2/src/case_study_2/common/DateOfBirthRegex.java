package case_study_2.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DateOfBirthException {
    private static Scanner scanner = new Scanner(System.in);
    private static final String BIRTHDAY_FORMAT = "dd/MM/yyyy";
    public static void CheckDateOfBirth () {
        System.out.println("Input the date of Birth: ");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(BIRTHDAY_FORMAT);
        try{ String birthDay = scanner.nextLine();
            LocalDate date = dateFormat.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("input the wrong day of Birth Format");
        }


    }
    public static int getAges(){
        System.out.println("input the new age: ");
        int age = Integer.parseInt(scanner.nextLine());

        return age;
    }


}
