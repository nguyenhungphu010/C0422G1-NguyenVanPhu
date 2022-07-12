package case_study_2.common;

public class FacilityUtility {
    public static String rentalType() {
        do {
            System.out.println("Enter the rental type " +
                    "\n1.Daily rental" +
                    "\n2.Weekly rental" +
                    "\n3.Monthly rental");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    return "Daily rental";
                case 2:
                    return "Weekly rental";
                case 3:
                    return "Monthly rental";
                default:
                    System.out.println("Enter the choice again: ");
            }
        } while (true);
    }

    public static String roomStandard() {
        do {
            System.out.println("Enter the room standard " +
                    "\n1.Single" +
                    "\n2.Double" +
                    "\n3.Queen");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    return "Single Room";
                case 2:
                    return "Double Room";
                case 3:
                    return "Queen Room";
                default:
                    System.out.println("Enter the choice again: ");
            }
        } while (true);
    }

    public static boolean isFreeService() {

        do {
            System.out.println("Do you wanna Free service" + " Cleaning room" + " when you go out: " +
                    "\n1.Yes" +
                    "\n2.No");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Enter the choice again: ");
            }
        } while (true);
    }
}
