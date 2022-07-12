package case_study_2.common;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DateOfBirthRegex {
    private static final String BIRTHDAY_FORMAT = "dd/MM/yyyy";

    public static boolean CheckDateOfBirth(String birthday) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(BIRTHDAY_FORMAT);
        try {
            if (isDate(birthday)) {
                LocalDate date = LocalDate.parse(birthday, dateFormat);
                LocalDate now = LocalDate.now();
                int currentAge = Period.between(date, now).getYears();
                if (currentAge > 18 && currentAge < 100) {
                    return true;
                } else {
                    throw new AgeException("Age Under 18 or Over 100");
                }
            } else {
                throw new AgeException("Input the wrong format of Birthday");
            }
        } catch (AgeException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }



    public static void main(String[] args) {
        String str = "15/14/2011";

        System.out.println(isDate(str));
    }

    public static boolean isDate(String target) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(BIRTHDAY_FORMAT);
        //convert String to LocalDate
        try {
            LocalDate localDate = LocalDate.parse(target, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
