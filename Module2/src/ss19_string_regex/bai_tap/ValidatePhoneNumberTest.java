package ss19_string_regex.bai_tap;

import java.util.Scanner;

public class ValidatePhoneNumberTest {
    public static ValidatePhoneNumber validatePhoneNumber;

    public static void main(String[] args) {
        boolean valid = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter the Phone Number: ");
            String phoneNumber = scanner.nextLine();
            validatePhoneNumber = new ValidatePhoneNumber();
            valid = validatePhoneNumber.validate(phoneNumber);
            System.out.println("The Phone Number: " + phoneNumber + " is " + valid);
        }
        while (!valid);

    }

}
