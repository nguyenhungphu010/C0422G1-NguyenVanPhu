package ss19_string_regex.bai_tap;



public class ValidateClassName {

    private static final String REGEX_CLASS = "^[ACP]([0-9]{4})[GHIKLM]$";
    public ValidateClassName (){

    }
     public boolean validate(String string) {
        return string.matches(REGEX_CLASS);
    }
}


