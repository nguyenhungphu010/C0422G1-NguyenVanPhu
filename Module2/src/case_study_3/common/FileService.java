package case_study_2.common;

import case_study_2.models.booking.Booking;
import case_study_2.models.booking.Contract;
import case_study_2.models.facility.House;
import case_study_2.models.facility.Room;
import case_study_2.models.facility.Villa;
import case_study_2.models.person.Customer;
import case_study_2.models.person.Employee;

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

    public static void writeEmployee(String pathFile, List<Employee> employeeList) {
        List<String> list = new ArrayList<>();
        for (Employee e : employeeList
        ) {
            // đổi dữ liệu thành dạng String ArrayList để ghi vào file
            list.add(e.convertLine());
        }
        writeToFile(pathFile, list);
    }

    public static void writeCustomer(String pathFile, List<Customer> customerList) {
        List<String> list = new ArrayList<>();
        for (Customer c : customerList) {
            list.add(c.convertLine());
        }
        writeToFile(pathFile, list);
    }

    public static void writeRoom(String pathFile, List<Room> roomList) {
        List<String> list = new ArrayList<>();
        for (Room r : roomList
        ) {
            list.add(r.convertLine());
        }
        writeToFile(pathFile, list);
    }

    public static void writeHouse(String pathFile, List<House> houseList) {
        List<String> list = new ArrayList<>();
        for (House r : houseList
        ) {
            list.add(r.convertLine());
        }
        writeToFile(pathFile, list);
    }

    public static void writeVilla(String pathFile, List<Villa> villaList) {
        List<String> list = new ArrayList<>();
        for (Villa r : villaList
        ) {
            list.add(r.convertLine());
        }
        writeToFile(pathFile, list);
    }

    public static void writeBooking(String pathFile, Set<Booking> bookingList) {
        List<String> list = new ArrayList<>();
        for (Booking r : bookingList
        ) {
//            list.add();
        }
        writeToFile(pathFile, list);
    }

    public static void writeContract(String pathFile, List<Contract> contractList) {
        List<String> list = new ArrayList<>();
        for (Contract r : contractList
        ) {
//            list.add();
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
                }else {
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
    public static List<Employee> readEmployee (String pathFile) {
        List<String> list = readFile(pathFile);
        List<Employee> employeeList = new ArrayList<>();
        String [] lines = null;
        for ( String s: list) {
            lines = s.split(COMMA);
            employeeList.add(new Employee(lines[0],lines[1],lines[2],lines[3],lines[4],lines[5],lines[6],lines[7],lines[8],Double.parseDouble(lines[9])));
        }
        return employeeList;
    }
    public static List<Customer> readCustomer (String pathFile) {
        List<String> list = readFile(pathFile);
        List<Customer> customerList = new ArrayList<>();
        String [] lines = null;
        for ( String s: list
        ) {
            lines = s.split(COMMA);
            customerList.add(new Customer(lines[0],lines[1],lines[2],lines[3],lines[4],lines[5],lines[6],lines[7],lines[8]));
        }
        return customerList;
    }
    public static List<Room> readRoom (String pathFile) {
        List<String> list = readFile(pathFile);
        List<Room> roomList = new ArrayList<>();
        String [] lines = null;
        for ( String s: list
        ) {
            lines = s.split(COMMA);
            roomList.add(new Room(lines[0],Double.parseDouble(lines[1]),Double.parseDouble(lines[2]),Integer.parseInt(lines[3]),lines[4],lines[5],Boolean.parseBoolean(lines[6])));
        }
        return roomList;
    }
    public static List<House> readHouse (String pathFile) {
        List<String> list = readFile(pathFile);
        List<House> houseList = new ArrayList<>();
        String [] lines = null;
        for ( String s: list
        ) {
            lines = s.split(COMMA);
            houseList.add(new House(lines[0],Double.parseDouble(lines[1]),Double.parseDouble(lines[2]),Integer.parseInt(lines[3]),lines[4],lines[5],lines[6],Integer.parseInt(lines[7])));
        }
        return houseList;
    }
    public static List<Villa> readVilla(String pathFile) {
        List<String> list = readFile(pathFile);
        List<Villa> villaList = new ArrayList<>();
        String [] lines = null;
        for ( String s: list
        ) {
            lines = s.split(COMMA);
            villaList.add(new Villa(lines[0],Double.parseDouble(lines[1]),Double.parseDouble(lines[2]),Integer.parseInt(lines[3]),lines[4],lines[5],lines[6],Double.parseDouble(lines[7]),Integer.parseInt(lines[8])));
        }
        return villaList;
    }
//    public static List<Contract> readContract(String pathFile) {
//        List<String> list = readFile(pathFile);
//        List<Contract> contractList = new ArrayList<>();
//        String [] lines = null;
//        for ( String s: list
//        ) {
//            lines = s.split(COMMA);
//            contractList.add(new Contract(lines[0],lines[1],lines[2],lines[3],lines[4],lines[5],lines[6],lines[7],lines[8],Double.parseDouble(lines[9])));
//        }
//        return contractList;
//    }
//    public static Set<Booking> readBooking(String pathFile) {
//        List<String> list = readFile(pathFile);
//        Set<Booking> bookingList = new ArrayList<>();
//        String [] lines = null;
//        for ( String s: list
//        ) {
//            lines = s.split(COMMA);
//            bookingList.add(new Booking(lines[0],lines[1],lines[2],lines[3],lines[4],lines[5],lines[6],lines[7],lines[8],Double.parseDouble(lines[9])));
//        }
//        return bookingList;
//    }


//    public static List<Employee> readListEmployeeFromFile (String pathFile){
//        List<Employee> employeeList = new ArrayList<>();
//        String[] lines = null;
//        try {
//            FileReader fileReader = new FileReader(pathFile);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            while (true) {
//                String line = bufferedReader.readLine();
//                if (line == null){
//                    break;
//                }
//                lines = line.split(COMMA);
//            }
//            employeeList.add(new Employee(lines[0], lines[1],lines[2],lines[3],lines[4],))
//        }
//
//    }

}
