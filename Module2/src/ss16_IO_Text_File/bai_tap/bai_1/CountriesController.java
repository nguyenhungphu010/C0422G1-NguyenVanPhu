package ss16_IO_Text_File.bai_tap.bai_1;

import ss16_IO_Text_File.thuc_hanh.ReadAndWriteFile;

import java.util.List;

public class CountriesController {
    final static String FINAL_COUNTRIES_PATH = "Module2/src/ss16_IO_Text_File/bai_tap/bai_1/Countries.CSV";

    public static  void display (){
        List<Countries> countriesList = ReadAndWriteCSV.readCountriesFileCSV(FINAL_COUNTRIES_PATH);
        for (int i = 0; i <countriesList.size() ; i++) {
            System.out.println(countriesList.get(i));
        }
    }

}
