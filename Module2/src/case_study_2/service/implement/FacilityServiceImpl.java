package case_study_2.service.implement;

import case_study_2.common.CheckException;
import case_study_2.common.FacilityUtility;
import case_study_2.common.FileService;
import case_study_2.common.RegexService;
import case_study_2.models.facility.Facility;
import case_study_2.models.facility.House;
import case_study_2.models.facility.Room;
import case_study_2.models.facility.Villa;
import case_study_2.service.IFacilityService;

import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    private static final String FILE_PATH_ROOM = "Module2/src/case_study_2/common/data/room.csv";
    private static final String FILE_PATH_HOUSE = "Module2/src/case_study_2/common/data/house.csv";
    private static final String FILE_PATH_VILLA = "Module2/src/case_study_2/common/data/villa.csv";
    static Scanner scanner = new Scanner(System.in);
    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    static List<Facility> facilityList = new ArrayList<>();
    static List<Villa> villaList = new ArrayList<>();
    static List<House> houseList = new ArrayList<>();
    static List<Room> roomList = new ArrayList<>();
    // tạo maintenance facilities;
    static List<Facility> maintenanceFacilities = new ArrayList<>();

    static {
        Room room = new Room("Room", 45D, 20D, 2, "Daily Rental", "RR -001", false);
        House house = new House("House", 80d, 100D, 6, "dailyRental", "RH-002", "3 bedrooms", 2);
        Villa villa = new Villa("Villa", 500D, 1000D, 10, "Weekly Rental", "RV-003", "Double Room", 100, 2);

        roomList.add(room);
        houseList.add(house);
        villaList.add(villa);

        // them các đối tượng vào facility List;
        facilityList.add(house);
        facilityList.add(room);
        facilityList.add(villa);

        // write to file
        FileService.writeRoom(FILE_PATH_ROOM,roomList);
        FileService.writeVilla(FILE_PATH_VILLA,villaList);
        FileService.writeHouse(FILE_PATH_HOUSE,houseList);

        // thêm các đối tượng vào Facility Map;
        facilityMap.put(house, 1);
        facilityMap.put(room, 1);
        facilityMap.put(villa, 1);

    }

    @Override
    public void add(Facility facility) {
        Set<Facility> facilitiesKey = facilityMap.keySet();
        if (facilityMap.isEmpty()) {
            facilityMap.put(facility, 1);
        } else {
            boolean flag = true;
            for (Facility key : facilitiesKey
            ) {
                if (facility.equals(key)) {
                    maintenanceCheck(key);
                    facilityMap.put(key, facilityMap.get(key) + 1);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                facilityMap.put(facility, 1);
            }
        }
    }

    @Override
    public void addNewRoomService() {
        // write data to file room.csv
        roomList = FileService.readRoom(FILE_PATH_ROOM);
        // Add the service name;
        System.out.println("Enter the service name: ");
        String serviceName = scanner.nextLine();
        while (!RegexService.checkServiceName(serviceName)) {
            System.out.println("Enter the service name again: ");
            serviceName = scanner.nextLine();
        }
        // add the usable Area;
        System.out.println("Enter the usable area: ");
        double area = 0;
        area = CheckException.checkParseDouble();
        while (!RegexService.checkArea(String.valueOf(area))) {
            System.out.println("Enter the usable Area again: ");
            area = CheckException.checkParseDouble();
        }
        // Add the rental cost
        System.out.println("Enter the rental cost: ");
        double cost = 0;
        cost = CheckException.checkParseDouble();
        while (!RegexService.checkRentalCost(String.valueOf(cost))) {
            System.out.println("Enter the rental cost again: ");
            cost = CheckException.checkParseDouble();
        }
        // Add the quantity of quest.
        System.out.println("Enter the quantity of quest: ");
        int guestCount = 0;
        guestCount = CheckException.checkParseInteger();
        while (!RegexService.checkRegexIntegerMaxPeople(String.valueOf(guestCount))) {
            System.out.println("Enter the quantity of quest again: ");
            guestCount = CheckException.checkParseInteger();
        }
        // add the rental type
        String rentalType = FacilityUtility.rentalType();

        // add the Room ID service;
        System.out.println("Enter the Room ID Service: ");
        String roomID = scanner.nextLine();
        while (!RegexService.checkRoomIDService(roomID)) {
            System.out.println("Enter the Room ID Service again: ");
            roomID = scanner.nextLine();
        }

        // add the free Service
        boolean freeService = FacilityUtility.isFreeService();

        Room room = new Room(serviceName, area, cost, guestCount, rentalType, roomID, freeService);
        roomList.add(room);
        // write room to Room CSV file.
        FileService.writeRoom(FILE_PATH_ROOM,roomList);
        this.add(room);
    }

    @Override
    public void addNewVillaService() {

        // add data to Villa.csv;
        villaList = FileService.readVilla(FILE_PATH_VILLA);
        System.out.println("Enter the service name: ");
        String serviceName = scanner.nextLine();
        while (!RegexService.checkServiceName(serviceName)) {
            System.out.println("Enter the service name again: ");
            serviceName = scanner.nextLine();
        }
        // add the usable Area;
        System.out.println("Enter the usable area: ");
        double area = 0;
        area = CheckException.checkParseDouble();
        while (!RegexService.checkArea(String.valueOf(area))) {
            System.out.println("Enter the usable Area again: ");
            area = CheckException.checkParseDouble();
        }
        // Add the rental cost
        System.out.println("Enter the rental cost: ");
        double cost = 0;
        cost = CheckException.checkParseDouble();
        while (!RegexService.checkRentalCost(String.valueOf(cost))) {
            System.out.println("Enter the rental cost again: ");
            cost = CheckException.checkParseDouble();
        }
        // Add the quantity of quest.
        System.out.println("Enter the quantity of quest: ");
        int guestCount = 0;
        guestCount = CheckException.checkParseInteger();
        while (!RegexService.checkRegexIntegerMaxPeople(String.valueOf(guestCount))) {
            System.out.println("Enter the quantity of quest again: ");
            guestCount = CheckException.checkParseInteger();
        }
        // add the rental type
        String rentalType = FacilityUtility.rentalType();

        // add the villa ID service;
        System.out.println("Enter the Villa ID Service: ");
        String villaID = scanner.nextLine();
        while (!RegexService.checkVillaIDService(villaID)) {
            System.out.println("Enter the Villa ID Service again: ");
            villaID = scanner.nextLine();
        }
        // add the villa Standard
        String roomStandard = FacilityUtility.roomStandard();

        // add the pool Area;
        System.out.println("Enter the pool Area: ");
        double poolArea = 0;
        poolArea = CheckException.checkParseDouble();
        while (!RegexService.checkArea(String.valueOf(poolArea))){
            System.out.println("Enter the pool Area again: ");
            poolArea = CheckException.checkParseInteger();
        }

        // add the storey of House
        System.out.println("Enter the storey of the Villa: ");
        int storey = 0;
        storey = CheckException.checkParseInteger();
        while (!RegexService.checkRegexIntegerFloor(String.valueOf(storey))) {
            System.out.println("Enter the storey again: ");
            storey = CheckException.checkParseInteger();
        }
        Villa villa = new Villa(serviceName,area,cost,guestCount,rentalType,villaID,roomStandard,poolArea,storey);
        villaList.add(villa);
        // write the villa to villa.CSV
        FileService.writeVilla(FILE_PATH_VILLA,villaList);
        this.add(villa);
    }

    @Override
    public void addNewHouseService() {
        // write data to the House.CSV
        houseList = FileService.readHouse(FILE_PATH_HOUSE);
        // Add the service name;
        System.out.println("Enter the service name: ");
        String serviceName = scanner.nextLine();
        while (!RegexService.checkServiceName(serviceName)) {
            System.out.println("Enter the House service name again: ");
            serviceName = scanner.nextLine();
        }
        // add the usable Area;
        System.out.println("Enter the usable area: ");
        double area = 0;
        area = CheckException.checkParseDouble();
        while (!RegexService.checkArea(String.valueOf(area))) {
            System.out.println("Enter the usable Area again: ");
            area = CheckException.checkParseDouble();
        }
        // Add the rental cost
        System.out.println("Enter the rental cost: ");
        double cost = 0;
        cost = CheckException.checkParseDouble();
        while (!RegexService.checkRentalCost(String.valueOf(cost))) {
            System.out.println("Enter the rental cost again: ");
            cost = CheckException.checkParseDouble();
        }
        // Add the quantity of quest.
        System.out.println("Enter the quantity of quest: ");
        int guestCount = 0;
        guestCount = CheckException.checkParseInteger();
        while (!RegexService.checkRegexIntegerMaxPeople(String.valueOf(guestCount))) {
            System.out.println("Enter the quantity of quest again: ");
            guestCount = CheckException.checkParseInteger();
        }
        // add the rental type
        String rentalType = FacilityUtility.rentalType();

        // add the Room ID service;
        System.out.println("Enter the House ID Service: ");
        String houseID = scanner.nextLine();
        while (!RegexService.checkHouseIDService(houseID)) {
            System.out.println("Enter the House ID Service again: ");
            houseID = scanner.nextLine();
        }
        // add the house Standard
        String roomStandard = FacilityUtility.roomStandard();

        // add the storey of House
        System.out.println("Enter the storey of the House: ");
        int storey = 0;
        storey = CheckException.checkParseInteger();
        while (!RegexService.checkRegexIntegerFloor(String.valueOf(storey))) {
            System.out.println("Enter the storey again: ");
            storey = CheckException.checkParseInteger();
        }
        House house = new House(serviceName, area, cost, guestCount, rentalType, houseID, roomStandard, storey);
        // write the house to the file.
        houseList.add(house);
        FileService.writeHouse(FILE_PATH_ROOM,houseList);
        this.add(house);
    }

    @Override
    public void maintenanceCheck(Facility facility) {
        if(facilityMap.get(facility)>=5){
            System.err.println("Facility is under Maintenance!");
            maintenanceFacilities.add(facility);
            facilityMap.put(facility,0);
        }
    }

    @Override
    public void displayMaintenance() {
        if(!maintenanceFacilities.isEmpty()){
            for (Facility f: maintenanceFacilities) {
                System.out.println(f);
            }
        }else {
            System.err.println("No Facility is under Maintenance");
        }
    }

    @Override
    public void displayNumberUsedOfService() {
        for(Map.Entry<Facility,Integer> entry : facilityMap.entrySet()) {
            System.out.println("Service: " + entry.getKey().getServiceName());
            System.out.println("Number of used: " + entry.getValue() );
        }

    }
    public static List<Facility> getFacility(){
        return facilityList;
    }
}
