package case_study_2.models;

public class Room extends Facility{
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
    public String toString() {
        return "Room{" +
                super.toString() +
                "freeService=" + freeService +
                '}';
    }

}
