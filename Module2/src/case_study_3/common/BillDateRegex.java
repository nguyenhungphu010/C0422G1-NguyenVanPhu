package case_study_3.common;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BillDateRegex {
    private static final String RELEASES_DATE = "dd/MM/yyyy";

    public static boolean CheckReleasedDate(String releasedDate) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(RELEASES_DATE);
        try {
            if (isDate(releasedDate)) {
                LocalDate date = LocalDate.parse(releasedDate, dateFormat);
                LocalDate now = LocalDate.now();
                int currentAge = Period.between(date, now).getDays();
                if (currentAge > 0) {
                    return true;
                } else {
                    throw new DateException("input the wrong date");
                }
            } else {
                throw new DateException("Input the wrong format of released Date");
            }
        } catch ( DateException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }



    public static void main(String[] args) {
        String str = "15/12/2011";

        System.out.println(isDate(str));
    }

    public static boolean isDate(String target) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(RELEASES_DATE);
        //convert String to LocalDate
        try {
            LocalDate localDate = LocalDate.parse(target, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
