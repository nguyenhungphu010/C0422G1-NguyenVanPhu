package case_study_2.service.implement;

import case_study_2.common.DateOfBirthRegex;
import case_study_2.common.FileService;
import case_study_2.common.PersonUtility;
import case_study_2.common.RegexService;
import case_study_2.models.person.Customer;
import case_study_2.service.CustomerService;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static final String FILE_PATH_CUSTOMER = "Module2/src/case_study_2/common/data/OverseaCustomer.csv";
    static List<Customer> customerList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static String date1 = "26/12/1992";
    static String date2 = "05/10/1980";
    static String date3 = "30/09/1977";
    static String date4 = "23/08/1960";
    static String date5 = "16/07/2003";
    static {
        customerList.add(new Customer("John",date1, "Male",
                "2232323", "0945112884", "John.Travolta@yahoo.com",
                "C001", "Platinum", "Washington DC"));
        customerList.add(new Customer("Emma",date2, "Female",
                "2334343", "0945452884", "Emma.Smith@gmail.com",
                "C002", "Gold", "British"));
        customerList.add(new Customer("Bills",date3, "Male",
                "2277323", "0215112884", "Bills.Cloye@yahoo.com",
                "C003", "Silver", "Texas"));
        customerList.add(new Customer("Dakota",date4, "Female",
                "2239023", "0645112884", "Dakota.Johnson@yahoo.com",
                "C004", "Member", "Ohio"));
        customerList.add(new Customer("Chris",date5, "Male",
                "2289323", "0545112884", "Chris.Hemsworth@hotmail.com",
                "C005", "Diamond", "Australia"));

    }

    public CustomerServiceImpl()  {
        //
    }

    @Override
    public void add()  {
        customerList = FileService.readCustomer(FILE_PATH_CUSTOMER);
        System.out.println("Input the Customer name: ");
        String newName = RegexService.checkRegexStringName();
        System.out.println("Input the Customer Day of Birth: ");
        boolean flag = true;
        String birthday = null;
        while (flag) {
            birthday = scanner.nextLine();
            if (DateOfBirthRegex.CheckDateOfBirth(birthday)){
                flag = false;
            }else
            {
                System.out.println("Input again please! ");
            }
        }
        System.out.println("Input the Customer sex: ");
        String newSex = PersonUtility.PersonSex();
        System.out.println("Input the Customer IDNumber: ");
        String newIDNumb = RegexService.checkRegexStringID();
        System.out.println("Input the Customer PhoneNumber: ");
        String newPhoneNumber =  RegexService.checkRegexStringPhoneNumber();
        System.out.println("Input the Customer Email: ");
        String newEmail = RegexService.checkRegexStringEmail();
        System.out.println("Input the Customer ID: ");
        String newCID = RegexService.checkRegexStringCID();
        System.out.println("Input the Customer Rank: ");
        String newRank = PersonUtility.CustomerRank();
        System.out.println("Input the Customer Address: ");
        String newAddress = scanner.nextLine();
        customerList.add(new Customer(newName, birthday,newSex,newIDNumb,newPhoneNumber,newEmail,newCID,newRank, newAddress));
        FileService.writeCustomer(FILE_PATH_CUSTOMER,customerList);
    }

    @Override
    public void display() {
        customerList = FileService.readCustomer(FILE_PATH_CUSTOMER);
        for (Customer c: customerList
             ) {
            System.out.println(c);
        }

    }

    @Override
    public void edit()  {
        System.out.println("Input the Customer ID to edit: ");
        boolean flag = false;
        int index = 0;
        String CustomerID = RegexService.checkRegexStringCID();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getcID().contains(CustomerID)) {
                flag = true;
                index = i;
            }
        }
        if (flag) {
            System.out.println("Input the new Customer name: ");
            String newName = RegexService.checkRegexStringName();
            customerList.get(index).setName(newName);
            // date of Birth
            System.out.println("Input the Employee Day of Birth: ");
            String birthday = scanner.nextLine() ;
            DateOfBirthRegex.CheckDateOfBirth(birthday);
            customerList.get(index).setDayOfBirth(birthday);
            // Customer Sex
            System.out.println("Input the Customer sex: ");
            String newSex = PersonUtility.PersonSex();
            customerList.get(index).setSex(newSex);
            //ID number
            System.out.println("Input the Customer IDNumber: ");
            String newIDNumb = RegexService.checkRegexStringID();
            customerList.get(index).setIDNumber(newIDNumb);
            // Phone Number
            System.out.println("Input the Customer PhoneNumber: ");
            String newPhoneNumber = RegexService.checkRegexStringPhoneNumber();
            customerList.get(index).setPhoneNumber(newPhoneNumber);
            // email
            System.out.println("Input the Customer Email: ");
            String newEmail = RegexService.checkRegexStringEmail();
            customerList.get(index).setEmail(newEmail);
            // Customer ID
            System.out.println("Input the Customer ID: ");
            String newCID = RegexService.checkRegexStringCID();
            customerList.get(index).setcID(newCID);
            // Customer Education
            System.out.println("Input the Customer Rank: ");
            String newRank = PersonUtility.CustomerRank();
            customerList.get(index).setRank(newRank);
            // Customer Level
            System.out.println("Input the Customer address: ");
            String newAddress = scanner.nextLine();
            customerList.get(index).setAddress(newAddress);
            FileService.writeCustomer(FILE_PATH_CUSTOMER,customerList);
        }else
            System.out.println("Input the wrong Customer ID");
    }
}
