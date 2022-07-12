package case_study_2.models;

public class House extends Facility{
    private String roomStandard;
    private int Storey;

    public House() {
    }

    public House(String serviceName, double usableArea, double rentalCost, int maxGuest, String rentalType, String serviceID, String roomStandard, int storey) {
        super(serviceName, usableArea, rentalCost, maxGuest, rentalType, serviceID);
        this.roomStandard = roomStandard;
        Storey = storey;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getStorey() {
        return Storey;
    }

    public void setStorey(int storey) {
        Storey = storey;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", Storey=" + Storey +
                '}';
    }

}
