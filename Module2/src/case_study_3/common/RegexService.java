package case_study_3.common;


import java.util.Scanner;

public class RegexService {
    // regex for Customer
    private static final String REGEX_VNCUS_ID = "^KHVN\\-[0-9]{5}$";
    private static final String REGEX_OCUS_ID = "^KHNN\\-[0-9]{5}$";
    private static final String REGEX_BILL_ID = "^MHD\\-[0-9]{3}$";

    // regex for Facility Class
    private static final String REGEX_SERVICE_ID_VILLA = "^SVVL\\-[0-9]{4}$";
    private static final String REGEX_SERVICE_ID_HOUSE = "^SVHO\\-[0-9]{4}$";
    private static final String REGEX_SERVICE_ID_ROOM = "^SVRO\\-[0-9]{4}$";
    private static final String REGEX_SERVICE_NAME = "^[A-Z][a-z]{0,}$";
    private static final String REGEX_ROOM_STANDARD_VILLA = "^[SDTQ][a-z]$";
    private static final String REGEX_ROOM_RENTAL_TYPE = "^[DWM][a-z]{0,}$";

    // Regex for Facility Service
    private static final String REGEX_FLOOR = "^[1-9][0-9]*$";
    private static final String REGEX_MAX_PEOPLE = "^[1-9]|1[0-9]|2[0-9]$";
    private static final String REGEX_AREA = "^((([3-9][0-9])|([1-9][0-9][0-9]+))\\.[0-9]{1,})$";
    private final static String REGEX_RENTAL_COST = "^([1-9]+)\\.[0-9]{1,}$";


    // Regex for Person class.
    private static final String REGEX_NAME = "^([A-Z][a-z]\\s)([A-Z][a-z])+$";
    private static final String REGEX_NAME_VIET = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõ" +
            "ùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢ" +
            "ỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$";
    private static final String REGEX_PHONE = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String REGEX_ID = "[0-9]{9}";
    private static final String REGEX_E_ID = "^E[0-9]{3}$";
    private static final String REGEX_C_ID = "^C[0-9]{3}$";




    public static String checkRegexStringName() {
        String value = new Scanner(System.in).nextLine();
        while (!value.matches(REGEX_NAME_VIET)) {
            System.out.print("Enter again: ");
            value = new Scanner(System.in).nextLine();
        }
        return value;
    }

    public static String checkRegexVNID() {
        String value = new Scanner(System.in).nextLine();
        while (!value.matches(REGEX_VNCUS_ID)) {
            System.out.print("Enter again: ");
            value = new Scanner(System.in).nextLine();
        }
        return value;
    }
    public static String checkRegexOverseaID() {
        String value = new Scanner(System.in).nextLine();
        while (!value.matches(REGEX_OCUS_ID)) {
            System.out.print("Enter again: ");
            value = new Scanner(System.in).nextLine();
        }
        return value;
    }

    public static String checkRegexStringBillID() {
        String value = new Scanner(System.in).nextLine();
        while (!value.matches(REGEX_BILL_ID)) {
            System.out.print("Enter again: ");
            value = new Scanner(System.in).nextLine();
        }
        return value;
    }

//    public static String checkRegexStringCID() {
//        String value = new Scanner(System.in).nextLine();
//        while (!value.matches(REGEX_C_ID)) {
//            System.out.print("Enter again: ");
//            value = new Scanner(System.in).nextLine();
//        }
//        return value;
//    }
//
//    public static String checkRegexStringEmail() {
//        String value = new Scanner(System.in).nextLine();
//        while (!value.matches(REGEX_EMAIL)) {
//            System.out.print("Enter again: ");
//            value = new Scanner(System.in).nextLine();
//        }
//        return value;
//    }
//
//    public static String checkRegexStringPhoneNumber() {
//        String value = new Scanner(System.in).nextLine();
//        while (!value.matches(REGEX_PHONE)) {
//            System.out.print("Enter again: ");
//            value = new Scanner(System.in).nextLine();
//        }
//        return value;
//    }

    public static void main(String[] args) {
//        String name = checkRegexStringName();
        String phone = checkRegexStringBillID();
    }

    public static boolean checkServiceName(String serviceName) {
        return (serviceName.matches(REGEX_SERVICE_NAME));
    }

    public static boolean checkArea(String area) {
        return (area.matches(REGEX_AREA));
    }

    public static boolean checkRentalCost(String cost) {
        return (cost.matches(REGEX_RENTAL_COST));
    }

    public static boolean checkRegexIntegerMaxPeople(String max) {
        return (max.matches(REGEX_MAX_PEOPLE));
    }

    public static boolean checkRoomIDService(String roomIDService) {
        return (roomIDService.matches(REGEX_SERVICE_ID_ROOM));
    }
    public static boolean checkHouseIDService(String roomIDService) {
        return (roomIDService.matches(REGEX_SERVICE_ID_HOUSE));
    }
    public static boolean checkVillaIDService(String roomIDService) {
        return (roomIDService.matches(REGEX_SERVICE_ID_VILLA));
    }
    public static boolean checkRegexIntegerFloor(String storey) {
        return (storey.matches(REGEX_FLOOR));
    }
}
