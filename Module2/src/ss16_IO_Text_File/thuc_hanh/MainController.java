package ss16_IO_Text_File.thuc_hanh;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        System.out.println("nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);
    }
}
