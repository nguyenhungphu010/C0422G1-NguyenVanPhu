package case_study_4.common;


import java.util.Scanner;

public class RegexService {

    // Regex for Person class.
    private static final String REGEX_NAME_VIET = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõ" +
            "ùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢ" +
            "ỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
    private static final String REGEX_PHONE = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    private static final String REGEX_EMPLOYEE_ID = "^NV-[0-9]{3}$";
    private static final String REGEX_STUDENT_ID = "^HV-[0-9]{3}$";


    public static String checkRegexStringName() {
        String value = new Scanner(System.in).nextLine();
        while (!value.matches(REGEX_NAME_VIET)) {
            System.out.print("Enter again: ");
            value = new Scanner(System.in).nextLine();
        }
        return value;
    }


    public static String checkRegexStringEmployeeID() {
        String value = new Scanner(System.in).nextLine();
        while (!value.matches(REGEX_EMPLOYEE_ID)) {
            System.out.print("Enter again: ");
            value = new Scanner(System.in).nextLine();
        }
        return value;
    }

    public static String checkRegexStringStudentID() {
        String value = new Scanner(System.in).nextLine();
        while (!value.matches(REGEX_STUDENT_ID)) {
            System.out.print("Enter again: ");
            value = new Scanner(System.in).nextLine();
        }
        return value;
    }


    public static String checkRegexStringPhoneNumber() {
        String value = new Scanner(System.in).nextLine();
        while (!value.matches(REGEX_PHONE)) {
            System.out.print("Enter again: ");
            value = new Scanner(System.in).nextLine();
        }
        return value;
    }

}
