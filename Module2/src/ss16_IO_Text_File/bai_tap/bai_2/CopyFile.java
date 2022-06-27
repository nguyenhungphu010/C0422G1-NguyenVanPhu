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

        System.out.println(" 1");
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
        File fileTarget = new File(pathTarget);
        FileWriter fileWriterTarget = null;
        BufferedWriter bufferedWriterTarget = null;
        try {
            File fileSource = new File(pathSource);
            if (!fileSource.exists()) {
                throw new FileNotFoundException();
            }
            // read the source file
            BufferedReader brSource = new BufferedReader(new FileReader(fileSource));


            //write down the target file

            fileWriterTarget = new FileWriter(fileTarget, append);
            bufferedWriterTarget = new BufferedWriter(fileWriterTarget);
            while (brSource.readLine() != null) {
                bufferedWriterTarget.write(brSource.readLine());
                bufferedWriterTarget.newLine();
            }
            bufferedWriterTarget.close();

        } catch (Exception e) {
            System.err.println(" source file does not exist");
        }
        ;
    }

}
