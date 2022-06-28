package ss16_IO_Text_File.bai_tap.bai_2;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void CopyContentToTarget() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of source file: ");
        String pathSource = scanner.nextLine();
        System.out.println("Enter the path of target file: ");
        String pathTarget = scanner.nextLine();
        boolean append = false;
        System.out.println("Do you wanna copy from sourse file to Target file ? "
                + "\n 1. copy "
                + "\n 2. not copy"
                + "\n 3. exit ");

        System.out.println();
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                append = true;
                break;
            case 2:
                append = false;
                break;
            case 3:
                System.exit(1);
                break;
            default:
                System.out.println("Enter the correct choice number");
        }
        //
        try {
            File fileTarget = new File("D:\\C0422G1-NguyenVanPhu\\Module2\\src\\ss16_IO_Text_File\\bai_tap\\bai_2\\target.CSV");
            FileWriter fileWriterTarget = null;
            BufferedWriter bufferedWriterTarget = null;
            fileWriterTarget = new FileWriter(fileTarget, append);
            bufferedWriterTarget = new BufferedWriter(fileWriterTarget);

            File fileSource = new File("D:\\C0422G1-NguyenVanPhu\\Module2\\src\\ss16_IO_Text_File\\bai_tap\\bai_2\\source.CSV");
//
            BufferedReader brSource = new BufferedReader(new FileReader(fileSource));
            String line ="";
            while ((line=brSource.readLine()) != null) {
                bufferedWriterTarget.write(line);
                bufferedWriterTarget.newLine();
            }
            bufferedWriterTarget.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
    }

}
