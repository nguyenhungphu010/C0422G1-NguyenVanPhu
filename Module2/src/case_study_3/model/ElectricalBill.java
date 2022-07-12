package case_study_3.model;

public class ElectricalBill {
    private static VNCustomer vnCustomer = new VNCustomer();
    private static OverseaCustomer overseaCustomer = new OverseaCustomer();
    private final static String COMMA = ",";

    private String billID;
    private String releaseDate;
    private double price;
    private double total;

    public ElectricalBill() {
    }

    public ElectricalBill(String billID, String releaseDate, double price, double total) {
        this.billID = billID;
        this.releaseDate = releaseDate;
        this.price = price;
        this.total = total;
    }



    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String VNConvertLine() {
        String line = this.billID +COMMA + this.releaseDate +COMMA + this.price + COMMA + this.total ;
        return line;
    }
    public String OverseaConvertLine() {
        String line = this.billID +COMMA + this.releaseDate +COMMA + this.price + COMMA + this.total ;
        return line;
    }


    @Override
    public String toString() {
        return "ElectricalBill{" +
                "vnCustomer=" + vnCustomer.getCustomerID() + "," + vnCustomer.getConsumption() +
                ", overseaCustomer=" + overseaCustomer.getCustomerID() +
                ", billID='" + billID + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
