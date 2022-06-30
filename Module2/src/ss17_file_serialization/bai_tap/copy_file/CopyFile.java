package ss17_file_serialization.bai_tap.copy_file;

import java.io.*;

public class CopyFile implements Serializable {
    private static String PATH_SOURCE_FILE = "D:\\C0422G1-NguyenVanPhu\\Module2\\src\\ss17_file_serialization\\bai_tap\\copy_file\\sourceFile.txt";
    private static String PATH_DES_FILE = "D:\\C0422G1-NguyenVanPhu\\Module2\\src\\ss17_file_serialization\\bai_tap\\copy_file\\destFile.txt";


    public static void CopyBinaryFile (){
        File sourceFile = new File(PATH_SOURCE_FILE);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;


        File destFile = new File(PATH_DES_FILE);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;


        try {
            if (sourceFile.length() >0){

                fileInputStream = new FileInputStream(sourceFile);
                objectInputStream = new ObjectInputStream(fileInputStream);
                Object sourceData = objectInputStream.readObject();

                fileOutputStream = new FileOutputStream(destFile);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(sourceData);
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (sourceFile.length() >0){
                    fileInputStream.close();
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
