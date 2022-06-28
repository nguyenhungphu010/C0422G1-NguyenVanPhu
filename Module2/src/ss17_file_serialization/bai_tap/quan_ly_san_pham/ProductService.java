package ss17_file_serialization.bai_tap.quan_ly_san_pham;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService<Product> {

    private static List<Product> productList = new ArrayList<>();
    private static String PATH_FILE = "D:\\C0422G1-NguyenVanPhu\\Module2\\src\\ss17_file_serialization\\bai_tap\\quan_ly_san_pham\\products.txt";
    public  static  Scanner scanner = new Scanner(System.in);

    static {
        productList.add(new Product(1, "CBR1000RR", "Honda", 10000, "new"));
        productList.add(new Product(2, "R1", "Yamaha", 11000, "new"));
        productList.add(new Product(3, "S1000", "BMW", 12000, "Old"));
        productList.add(new Product(4, "GLC300", "Mercedes", 120000, "new"));
        productList.add(new Product(5, "Panigle", "Ducati", 12000, "new"));
    }

    // đọc và ghi đôi tượng vaò file
    public static void writeObjectListProductToFile(List<Product> productList, String pathFile) {
        File file = new File(pathFile);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // doc doi tượng trong File;
    public static List<Product> readObjectInFile(String pathFile) {
        List<Product> products = new ArrayList<>();
        File file = new File(pathFile);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            if (file.length() > 0) {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                products = (List<Product>) objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file.length() > 0) {
                    fileInputStream.close();
                    objectInputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return products;

    }

    @Override
    public void add() {
        System.out.print("input the id: ");
        int id = Integer.parseInt(scanner.nextLine()) ;
        System.out.print("input the name: ");
        String name = scanner.nextLine();
        System.out.print("input the Maker: ");
        String maker = scanner.nextLine();
        System.out.print("input the price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("input the status: ");
        String status = scanner.nextLine();
        Product product = new Product(id,name,maker,price,status);
        productList.add(product);
        writeObjectListProductToFile(productList, PATH_FILE);
    }

    @Override
    public void display() {
        writeObjectListProductToFile(productList, PATH_FILE);
        readObjectInFile(PATH_FILE);
        for (Product s: productList
        ) {
            System.out.println(s);
        }
    }

    @Override
    public void search() {
        System.out.println("Enter the id: ");
        int idInfor = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        for (Product s: productList
             ) {
            int id = s.getId();
            if (id == idInfor){
                System.out.println(s);
                flag = false;
            }
        }
        if (flag) {
            System.out.println("wrong id");
        }

    }
}
