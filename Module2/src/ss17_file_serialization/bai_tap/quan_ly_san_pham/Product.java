package ss17_file_serialization.bai_tap.quan_ly_san_pham;

public class Product {
    private int id;
    private String name;
    private String maker;
    private int price;
    private String status;

    public Product() {
    }

    public Product(int id, String name, String maker, int price, String status) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
