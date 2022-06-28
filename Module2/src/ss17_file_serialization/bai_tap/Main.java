package ss17_file_serialization.bai_tap;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } finally {
            is.close();
            os.close();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter the source file: ");
        String sourcePath = scanner.nextLine();
        System.out.println(" Enter the destination file: ");
        String desPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File desFile = new File(desPath);
        try {
            copyFileUsingJava7Files(sourceFile, desFile);
            System.out.println("Copy Complete");
        }
        catch (IOException e ) {
            System.out.println(" cant copy the file ");
            System.out.println(e.getMessage());
        }
    }

}
