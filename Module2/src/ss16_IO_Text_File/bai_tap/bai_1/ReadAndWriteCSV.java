package ss16_IO_Text_File.bai_tap.bai_1;

import com.sun.xml.internal.ws.addressing.WsaTubeHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCSV {
    public static void writeListCountryToCSV (List<Countries> countriesList, String pathFile, boolean append) {
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            // ghi 1 chuỗi vào file;
            for (Countries s:countriesList ) {
                bufferedWriter.write(s.getInforToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        };
    }
    public static List<Countries> readCountriesFileCSV(String pathFile) {
        List<Countries> countriesList = new ArrayList<>();
        File file = new File (pathFile);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        String[] array = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine())!= null) {
                array = line.split(",");
                Countries countries = new Countries(Integer.parseInt(array[0]),array[1],array[2]);
                countriesList.add(countries);
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return countriesList;
    }
}
