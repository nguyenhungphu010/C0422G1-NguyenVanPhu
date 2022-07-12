package case_study_3.common;

import case_study_2.models.booking.Booking;
import case_study_2.models.booking.Contract;
import case_study_2.models.facility.House;
import case_study_2.models.facility.Room;
import case_study_2.models.facility.Villa;
import case_study_2.models.person.Customer;
import case_study_2.models.person.Employee;
import case_study_3.model.ElectricalBill;
import case_study_3.model.OverseaCustomer;
import case_study_3.model.VNCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileService {
    private final static String COMMA = ",";
    private final static String PATTERN = "dd/MM/yyyy";

    // write to file;
    private static void writeToFile(String pathFile, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = null;
            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeVNCustomer(String pathFile, List<VNCustomer> vnCustomers) {
        List<String> list = new ArrayList<>();
        for (VNCustomer e : vnCustomers
        ) {
            // đổi dữ liệu thành dạng String ArrayList để ghi vào file
            list.add(e.convertLine());
        }
        writeToFile(pathFile, list);
    }

    public static void writeOverseaCustomer(String pathFile, List<OverseaCustomer> overseaCustomers) {
        List<String> list = new ArrayList<>();
        for (OverseaCustomer c : overseaCustomers) {
            list.add(c.convertLine());
        }
        writeToFile(pathFile, list);
    }

    public static void writeVNBill(String pathFile, List<ElectricalBill> electricalBills) {
        List<String> list = new ArrayList<>();
        for (ElectricalBill r : electricalBills
        ) {
            list.add(r.VNConvertLine());

        }
        writeToFile(pathFile, list);
    }
    public static void writeOverseaBill(String pathFile, List<ElectricalBill> electricalBills) {
        List<String> list = new ArrayList<>();
        for (ElectricalBill r : electricalBills
        ) {
            list.add(r.OverseaConvertLine());
        }
        writeToFile(pathFile, list);
    }


    // read from file:
    public static List<String> readFile(String pathFile) {
        File file = new File(pathFile);
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null && !line.equals("")) {
                    list.add(line);
                } else {
                    break;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<VNCustomer> readVNCustomer(String pathFile) {
        List<String> list = readFile(pathFile);
        List<VNCustomer> VNCustomer = new ArrayList<>();
        String[] lines = null;
        for (String s : list) {
            lines = s.split(COMMA);
            VNCustomer.add(new VNCustomer(lines[0], lines[1], Double.parseDouble(lines[2]), lines[3]));
        }
        return VNCustomer;
    }

    public static List<OverseaCustomer> readOverseaCustomer(String pathFile) {
        List<String> list = readFile(pathFile);
        List<OverseaCustomer> overseaCustomers = new ArrayList<>();
        String[] lines = null;
        for (String s : list
        ) {
            lines = s.split(COMMA);
            overseaCustomers.add(new OverseaCustomer(lines[0], lines[1], Double.parseDouble(lines[2]), lines[3]));
        }
        return overseaCustomers;
    }

    public static List<ElectricalBill> readBill(String pathFile) {
        List<String> list = readFile(pathFile);
        List<ElectricalBill> bills = new ArrayList<>();
        String[] lines = null;
        for (String s : list
        ) {
            lines = s.split(COMMA);
            bills.add(new ElectricalBill(lines[0],lines[1], Double.parseDouble(lines[2]), Double.parseDouble(lines[3])));
        }
        return bills;
    }


}
