package ss17_file_serialization.bai_tap.quan_ly_san_pham;

import java.util.Scanner;

public class ProductController {
    public static Scanner scanner = new Scanner(System.in);
    public static  ProductService productService = new ProductService();

    // hiển thị trên file;
    public static  void mainDisplay  (){
        while (true) {
            System.out.println("welcome to the product manager");
            System.out.println("choose the function");
            System.out.println("1. Adding more product.\n" +
                    "2. Searching the product  by id .\n" +
                    "3. Displaying the product.\n" +
                    "4. Exit.\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addingProduct();
                    break;
                case 2:
                    searchingProduct();
                    break;
                case 3:
                    displayProduct ();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("please input the right number");
            }
        }
    }
    // thêm sản phẩm vào file;
    public static void addingProduct (){
        productService.add();
        productService.display();
    }

    // tìm kiếm sản phẩm trong file
    public static void searchingProduct(){
        productService.search();
    }
    public static void displayProduct(){
        productService.display();
    }


    // các bước thực hiện
    //1. ghi danh sách sản phẩm vào file
    //2. đọc danh sách các sản phẩm trong file (display);
    //3. edit hoặc thêm các sản phẩm đã có sẵn trong file
    // 3.1 write lại các sản phẩm. append = true;
    //4. tìm kiếm các sản phầm dã có sẵn trong file
}
