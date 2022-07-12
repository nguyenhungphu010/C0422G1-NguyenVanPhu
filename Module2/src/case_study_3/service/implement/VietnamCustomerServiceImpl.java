package case_study_3.service.implement;


import case_study_3.common.CheckException;
import case_study_3.common.FileService;
import case_study_3.common.RegexService;
import case_study_3.model.VNCustomer;
import case_study_3.service.ICustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class VietnamCustomerServiceImpl implements ICustomerService {
    private static final String FILE_PATH_VNCUSTOMER = "Module2/src/case_study_3/common/data/VNcCustomer.csv";
    static List<VNCustomer> VNcustomerList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    static {
        VNcustomerList.add(new VNCustomer("Chanh", "KHVN-00001", 1222, "business"));
    }

    public VietnamCustomerServiceImpl() {
        //
    }

    @Override
    public void add() {
        VNcustomerList = FileService.readVNCustomer(FILE_PATH_VNCUSTOMER);
        System.out.println("Input the VN Customer name: ");
        String newName = RegexService.checkRegexStringName();
        System.out.println("Input the VN Customer ID: ");
        String newVNCustomerID = RegexService.checkRegexVNID();
        System.out.println("Input the VN Customer consumption: ");
        Double newVNConsumption = CheckException.checkParseDouble();
        System.out.println("Input the VN Customer type: ");
        String newVNCustomerType = vnCustomerType();
        VNcustomerList.add(new VNCustomer(newName, newVNCustomerID, newVNConsumption, newVNCustomerType));
        FileService.writeVNCustomer(FILE_PATH_VNCUSTOMER, VNcustomerList);

    }

    public String vnCustomerType() {
        do {
            System.out.println("Enter the choice");
            System.out.println("1.Family" +
                    "\n2.Business" +
                    "\n3.Manufacturing ");
            int choice = CheckException.checkParseInteger();
            switch (choice) {
                case 1:
                    return "Family";
                case 2:
                    return "Business";
                case 3:
                    return "Manufacturing";
                default:
                    System.out.println("Enter again");
                    break;
            }
        } while (true);

    }

    @Override
    public void display() {
        VNcustomerList = FileService.readVNCustomer(FILE_PATH_VNCUSTOMER);
        for (VNCustomer vn : VNcustomerList
        ) {
            System.out.println(vn);
        }
    }

    @Override
    public void search() {
        System.out.println("input the VN customer name to search");
        String nameINfor = scanner.nextLine();
        boolean flag = false;
        int index = 0;
        for (int i = 0; i < VNcustomerList.size(); i++) {
            if (VNcustomerList.get(i).getName().contains(nameINfor)) {
                flag = true;
                index = i;

            } else
                flag = false;
        }
        if (flag) {
            System.out.println(VNcustomerList.get(index));
        } else {
            System.out.println("Please input the name again:");
        }
    }
}
