package case_study_2.models;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int storey;

    public Villa() {
    }

    public Villa(String serviceName, double usableArea, double rentalCost, int maxGuest, String rentalType, String serviceID, String roomStandard, double poolArea, int storey) {
        super(serviceName, usableArea, rentalCost, maxGuest, rentalType, serviceID);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.storey = storey;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", storey=" + storey +
                '}';
    }

}
