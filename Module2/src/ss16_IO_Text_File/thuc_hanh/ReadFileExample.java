package ss16_IO_Text_File.thuc_hanh;

import java.io.*;

public class ReadFileExample {
    public void readFileText(String filePath) {
        try {
            // đọc file theo hướng dẫn.
            File file = new File(filePath);
            // kiểm tr file ko tồn tại ném ra ngoại lệ.
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            // đọc từng dòng của file và tiến hành cộng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
            // hiện ra màn hình tổng số nguyên trong file;
            System.out.println("Tổng= " + sum);

        }  catch (FileNotFoundException e) {
            // TH fike không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi
            System.err.println(" File không tồn tại hoặc nội dung có lỗi");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

    }
}
