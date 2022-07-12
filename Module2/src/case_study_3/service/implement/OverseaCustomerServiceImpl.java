package case_study_3.service.implement;

import case_study_3.common.CheckException;
import case_study_3.common.FileService;
import case_study_3.common.RegexService;
import case_study_3.model.OverseaCustomer;
import case_study_3.model.VNCustomer;
import case_study_3.service.ICustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OverseaCustomerServiceImpl  implements ICustomerService {
    private static final String FILE_PATH_OVER_CUSTOMER = "Module2/src/case_study_3/common/data/OverseaCustomer.csv";
    static List<OverseaCustomer> OverseaCustomerList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);
    static {
        OverseaCustomerList.add(new OverseaCustomer("Joohn","KHNN-00001", 1002,"USA"));
    }

    @Override
    public void add() {
        OverseaCustomerList = FileService.readOverseaCustomer(FILE_PATH_OVER_CUSTOMER);
        System.out.println("Input the Oversea Customer name: ");
        String newName = RegexService.checkRegexStringName();
        System.out.println("Input the Oversea Customer ID: ");
        String newOverseaCustomerID = RegexService.checkRegexOverseaID();
        System.out.println("Input the Oversea Customer consumption: ");
        Double newOverseaConsumption = CheckException.checkParseDouble();
        System.out.println("Input the Oversea Customer Nationality: ");
        String newOverseaCustomerNation = scanner.nextLine();
        OverseaCustomerList.add(new OverseaCustomer(newName,newOverseaCustomerID,newOverseaConsumption,newOverseaCustomerNation));
        FileService.writeOverseaCustomer(FILE_PATH_OVER_CUSTOMER,OverseaCustomerList);
    }

    @Override
    public void display() {
        OverseaCustomerList = FileService.readOverseaCustomer(FILE_PATH_OVER_CUSTOMER);
        for (OverseaCustomer o: OverseaCustomerList) {
            System.out.println(o);
        }

    }

    @Override
    public void search() {
        System.out.println("input the Oversea customer name to search");
        String nameINfor = scanner.nextLine();
        boolean flag = false;
        int index = 0 ;
        for (int i = 0; i < OverseaCustomerList.size(); i++) {
            if (OverseaCustomerList.get(i).getName().contains(nameINfor)) {
                flag = true;
                index = i ;
            }else
                flag = false;
        }
        if (flag) {
            System.out.println(OverseaCustomerList.get(index));
        }
        else {
            System.out.println("Please input the name again:");}
    }
}
