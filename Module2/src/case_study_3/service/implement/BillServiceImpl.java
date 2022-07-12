package case_study_3.service.implement;

import case_study_3.common.BillDateRegex;
import case_study_3.common.CheckException;
import case_study_3.common.FileService;
import case_study_3.common.RegexService;
import case_study_3.model.ElectricalBill;
import case_study_3.model.OverseaCustomer;
import case_study_3.model.VNCustomer;
import case_study_3.service.IBillService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillServiceImpl implements IBillService {
    private static final String FILE_PATH_BILL = "Module2/src/case_study_3/common/data/bill.csv";
    private static VNCustomer vnCustomer = new VNCustomer();
    private static OverseaCustomer overseaCustomer = new OverseaCustomer();
    public static ElectricalBill electricalBill = new ElectricalBill();
    private static List<ElectricalBill> electricalBills = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static String date1 = "26/12/2021";

    private static double VNConsumption = vnCustomer.getConsumption();
    private static double overseaConsumption = overseaCustomer.getConsumption();

    private static double price = electricalBill.getPrice();
    //

    public double CalculateVNTotal(double price,double consumption){
       double totalVN = consumption * price;
       return totalVN;
    }
    public double CalculateOverseaTotal(double price, double consumption){
        double totalOversea = consumption * price;
        return totalOversea;
    }
    double totalOversea = overseaConsumption * price;
static {
    electricalBills.add(new ElectricalBill("MHD-001",date1,10,1111));
}

    @Override
    public void add() {

        while (true) {
            System.out.println("please choose the Customer to add bill:");
            System.out.println("1.Adding new Vietnamese Customer's bill" +
                    "\n2.Adding new Oversea Customer's bill" +
                    "\n3.Return to main menu");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    addVNBill();
                    break;
                case 2:
                    addOverseaBill();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("choose again");
            }
        }

    }

    public void addVNBill() {
        electricalBills = FileService.readBill(FILE_PATH_BILL);
        System.out.println("Input the new bill ID: ");
        String newBillID = RegexService.checkRegexStringBillID();
        System.out.println("Input the new release Date: ");
        String newReleaseDate = null;
        boolean fla = true;
        while(fla) {
            newReleaseDate = scanner.nextLine();
            if(BillDateRegex.CheckReleasedDate(newReleaseDate)) {
                fla = false;
            }else
                System.out.println("Enter again: ");
        }
        System.out.println("Input the new consumption: ");
        Double newVNConsumption= CheckException.checkParseDouble();
        System.out.println("Input the new price: ");
        Double newPrice= CheckException.checkParseDouble();
        // total
        Double newTotal = newPrice * newVNConsumption;
        electricalBills.add(new ElectricalBill(newBillID,newReleaseDate,price,newTotal));
        FileService.writeVNBill(FILE_PATH_BILL,electricalBills);
    }

    public void addOverseaBill() {
        electricalBills = FileService.readBill(FILE_PATH_BILL);
        System.out.println("Input the new bill ID: ");
        String newBillID = RegexService.checkRegexStringBillID();
        System.out.println("Input the new release Date: ");
        String newReleaseDate = null;
        boolean fla2= true;
        while(fla2) {
            newReleaseDate = scanner.nextLine();
            if(BillDateRegex.CheckReleasedDate(newReleaseDate)) {
                fla2 = false;
            }else
                System.out.println("Enter again: ");
        }
        System.out.println("Input the new consumption: ");
        Double newOverseaConsumption= CheckException.checkParseDouble();
        System.out.println("Input the new price: ");
        Double newPrice= CheckException.checkParseDouble();
        // total
        Double newTotal = newPrice * newOverseaConsumption;
        electricalBills.add(new ElectricalBill(newBillID,newReleaseDate,price,newTotal));
        FileService.writeOverseaBill(FILE_PATH_BILL,electricalBills);
    }

    @Override
    public void edit() {
        System.out.println("input the VN customer name to search");
        String billIdInfor = scanner.nextLine();
        boolean flag = false;
        int index = 0 ;
        for (int i = 0; i < electricalBills.size(); i++) {
            if (electricalBills.get(i).getBillID().contains(billIdInfor)) {
                flag = true;
                index = i ;

            }else
                flag = false;
        }
        if (flag) {
            System.out.println("Input the new VN Customer name: ");
            String newBillID = RegexService.checkRegexStringBillID();
            electricalBills.get(index).setBillID(newBillID);
            // id
            System.out.println("Input the new date: ");
            String newReleaseDate = null;
            boolean fla2= true;
            while(fla2) {
                newReleaseDate = scanner.nextLine();
                if(BillDateRegex.CheckReleasedDate(newReleaseDate)) {
                    fla2 = false;
                }else
                    System.out.println("Enter again: ");
            }
            electricalBills.get(index).setReleaseDate(newReleaseDate);
            // new price
            System.out.println("Input the new consumption: ");
            Double newPrice = CheckException.checkParseDouble();
            electricalBills.get(index).setPrice(newPrice);
            // consumption
            System.out.println("Input the new consumption: ");
            Double newVNConsumption = CheckException.checkParseDouble();
            // total;
            System.out.println("Input the new VN Customer name: ");
            Double newTotal =  newPrice*newVNConsumption;
            electricalBills.get(index).setTotal(newTotal);
            FileService.writeVNBill(FILE_PATH_BILL,electricalBills);
        }
        else {
            System.out.println("Please input the name again:");}
    }



    @Override
    public void display() {
        electricalBills = FileService.readBill(FILE_PATH_BILL);
        for (ElectricalBill e: electricalBills
             ) {
            System.out.println(e);
        }
    }


}
//    @Override
//    public void add() {
//        electricalBills = FileService.readEmployee(FILE_PATH_EMPLOYEE);
//        System.out.println("Input the Employee name: ");
//        String NewName = RegexService.checkRegexStringName();
//        // add new Employee Date of Birth
//        System.out.println("Input the Employee Day of Birth: ");
//        boolean flag = true;
//        String birthday = null;
//        while (flag) {
//            birthday = scanner.nextLine();
//            if (DateOfBirthRegex.CheckDateOfBirth(birthday)) {
//                flag = false;
//            } else {
//                System.out.println("Input again please! ");
//            }
//        }
//        // Add new Sex of New Employee
//        String newSex = PersonUtility.PersonSex();
//        // add new employee ID Number.
//        System.out.println("Input the Employee IDNumber: ");
//        String newIDNumb = RegexService.checkRegexStringID();
//        // add new employee new Phone number
//        System.out.println("Input the Employee PhoneNumber: ");
//        String newPhoneNumber = RegexService.checkRegexStringPhoneNumber();
//        // add new employee new email;
//        System.out.println("Input the Employee Email: ");
//        String newEmail = RegexService.checkRegexStringEmail();
//        // add new employee's new Employee ID
//        System.out.println("Input the Employee ID: ");
//        String newEID =RegexService.checkRegexStringEID();
//        // Add new Employee Education
//        String newEducation = PersonUtility.EmployeeEducation();
//        // Add new Level to Employee.
//        String newLevel = PersonUtility.EmployeeLevel();
//        // add new Salary.
//        System.out.println("Input the Employee Salary: ");
//        Double newSalary = Double.parseDouble(scanner.nextLine());
//        electricalBills.add(new Employee(NewName, birthday, newSex, newIDNumb, newPhoneNumber, newEmail, newEID, newEducation,
//                newLevel, newSalary));
//
//        FileService.writeEmployee(FILE_PATH_EMPLOYEE, electricalBills);
//
//    }
//    @Override
//    public void display() {
//        electricalBills = FileService.readEmployee(FILE_PATH_EMPLOYEE);
//        for (Employee e : electricalBills) {
//            System.out.println(e);
//        }
//    }
//    @Override
//    public void edit() {
//        System.out.println("Input the Employee ID to edit: ");
//        boolean flag = false;
//        int index = 0;
//        String employmentID = RegexService.checkRegexStringEID();
//        for (int i = 0; i < electricalBills.size(); i++) {
//            if (electricalBills.get(i).geteID().contains(employmentID)) {
//                flag = true;
//                index = i;
//            }
//        }
//        if (flag) {
//            System.out.println("Input the new Employee name: ");
//            String newName = RegexService.checkRegexStringName();
//            electricalBills.get(index).setName(newName);
//            // Edit date of Birth
//            System.out.println("Input the Employee Day of Birth: ");
//            String birthday = scanner.nextLine();
//            DateOfBirthRegex.CheckDateOfBirth(birthday);
//            electricalBills.get(index).setDayOfBirth(birthday);
//            // Edit Employee Sex
//            String newSex = PersonUtility.PersonSex();
//            electricalBills.get(index).setSex(newSex);
//            //ID number
//            System.out.println("Input the Employee IDNumber: ");
//            String newIDNumb = RegexService.checkRegexStringID();
//            electricalBills.get(index).setIDNumber(newIDNumb);
//            // Phone Number
//            System.out.println("Input the Employee PhoneNumber: ");
//            String newPhoneNumber = RegexService.checkRegexStringPhoneNumber();
//            electricalBills.get(index).setPhoneNumber(newPhoneNumber);
//            // email
//            System.out.println("Input the Employee Email: ");
//            String newEmail = RegexService.checkRegexStringEmail();
//            electricalBills.get(index).setEmail(newEmail);
//            // Employment ID
//            System.out.println("Input the Employment ID: ");
//            String newEID = RegexService.checkRegexStringEID();
//            electricalBills.get(index).seteID(newEID);
//            // Employee Education
//            String newEducation = PersonUtility.EmployeeEducation();
//            electricalBills.get(index).setEducation(newEducation);
//            // Employee Level
//            String newLevel = PersonUtility.EmployeeLevel();
//            electricalBills.get(index).setLevel(newLevel);
//            // Employee Salary
//            System.out.println("Input the Employee Salary: ");
//            Double newSalary = CheckException.checkParseDouble();
//            electricalBills.get(index).setSalary(newSalary);
//            FileService.writeEmployee(FILE_PATH_EMPLOYEE, electricalBills);
//        } else
//            System.out.println("Input the wrong Employee ID");
//    }

