package case_study_2.models.facility;

public class Room extends Facility{
    private final static String COMMA= ",";
    private boolean freeService ;

    public Room() {
    }

    public Room(String serviceName, double usableArea, double rentalCost, int maxGuest, String rentalType, String serviceID, boolean freeService) {
        super(serviceName, usableArea, rentalCost, maxGuest, rentalType, serviceID);
        this.freeService = freeService;
    }

    public boolean isFreeService() {
        return freeService;
    }

    public void setFreeService(boolean freeService) {
        this.freeService = freeService;
    }

    @Override
    public String convertLine() {
        return super.convertLine()+COMMA + this.freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "freeService=" + freeService +
                '}';
    }

}
