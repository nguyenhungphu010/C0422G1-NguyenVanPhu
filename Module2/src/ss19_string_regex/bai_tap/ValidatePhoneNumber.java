package ss19_string_regex.bai_tap;

public class ValidatePhoneNumber {
    private static final String REGEX_CLASS = "^\\([0-9]{2}\\)\\-\\(0[0-9]{9}\\)$";

    public ValidatePhoneNumber() {

    }

    public boolean validate(String string) {
        return string.matches(REGEX_CLASS);
    }
}
