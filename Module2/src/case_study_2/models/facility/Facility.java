package case_study_2.models.facility;

import java.util.Objects;

public abstract class Facility {
    private final static String COMMA= ",";
    private String serviceName;
    private double UsableArea;
    private double rentalCost;
    private int maxGuest;
    private String rentalType;
    private String serviceID;

    public Facility() {
    }

    public Facility(String serviceName, double usableArea, double rentalCost, int maxGuest, String rentalType, String serviceID) {
        this.serviceName = serviceName;
        UsableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maxGuest = maxGuest;
        this.rentalType = rentalType;
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return UsableArea;
    }

    public void setUsableArea(double usableArea) {
        UsableArea = usableArea;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(int maxGuest) {
        this.maxGuest = maxGuest;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Double.compare(facility.UsableArea, UsableArea) == 0 && Double.compare(facility.rentalCost, rentalCost) == 0 && maxGuest == facility.maxGuest && serviceName.equals(facility.serviceName) && rentalType.equals(facility.rentalType) && serviceID.equals(facility.serviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, UsableArea, rentalCost, maxGuest, rentalType, serviceID);
    }

    public  String convertLine(){
        return this.serviceName+ COMMA + this.UsableArea+ COMMA+ this.rentalCost+ COMMA+ this.maxGuest+ COMMA+ this.rentalType+ COMMA+ this.serviceID;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", UsableArea=" + UsableArea +
                ", rentalCost=" + rentalCost +
                ", maxGuest=" + maxGuest +
                ", rentalType='" + rentalType + '\'' +
                ", serviceID='" + serviceID + '\'' +
                '}';
    }
}
