package ss19_string_regex.bai_tap;

import java.util.Scanner;

public class ValidateClassNameTest {
    public static ValidateClassName validateClassName;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the Class Name: ");
        String classname = scanner.nextLine();
        validateClassName = new ValidateClassName();
        boolean valid = validateClassName.validate(classname);
        System.out.println("Class name is"+ classname + " is " + valid);
    }
}
