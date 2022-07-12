package case_study_2.common;

import case_study_2.common.CheckException;

public class PersonUtility {
    public static String PersonSex (){
        do {
            System.out.println("Input the sex choice: " +
                    "\n1. Male" +
                    "\n2. Female");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    return  "Male";
                case 2:
                    return " Female";
                default:
                    System.out.println("Please input again: ");
                    break;
            }
        } while (true);
    }
    public static String EmployeeEducation(){
        do {
            System.out.println("Input the Employee Education: " +
                    "\n1. Under-College" +
                    "\n2. College" +
                    "\n3. University" +
                    "\n4. Master");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    return  "Under-College";
                case 2:
                    return "College";
                case 3:
                    return  "University";
                case 4:
                    return  "Master";
                default:
                    System.out.println("Please input again: ");
                    break;
            }
        } while (true);
    }
    public static String EmployeeLevel(){
        do {
            System.out.println("Input the Employee Level: " +
                    "\n1. Receptionist" +
                    "\n2. Waiter/Waitress" +
                    "\n3. Executive" +
                    "\n4. Supervisor" +
                    "\n5. Manager" +
                    "\n6. Director");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    return  "Receptionist";
                case 2:
                    return  "Waiter/Waitress";
                case 3:
                    return  "Executive";
                case 4:
                    return  "Supervisor";
                case 5:
                    return  "Manager";
                case 6:
                    return  "Director";
                default:
                    System.out.println("Please input again: ");
                    break;
            }
        } while (true);
    }
    public static String CustomerRank(){
        do{
            System.out.println("Input the Customer Type: " +
                    "\n1. Diamond" +
                    "\n2. Platinum" +
                    "\n3. Gold" +
                    "\n4. Silver" +
                    "\n5. Member" );
            int choice = CheckException.checkParseInteger();
            switch (choice){
                case 1:
                    return "Diamond";
                case 2:
                    return "Platinum";
                case 3:
                    return "Gold";
                case 4:
                    return "Silver";
                case 5:
                    return "Member";
                default:
                    System.out.println("Please input again: ");
                    break;
            }
        }while (true);

    }
}
