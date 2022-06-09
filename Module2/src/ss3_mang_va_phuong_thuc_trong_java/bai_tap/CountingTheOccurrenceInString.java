package ss3_mang_va_phuong_thuc;

import java.util.Scanner;

public class CountingTheOccurrenceInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = "We don't talk anymore";
        //
        String[] array;
        array = string1.split("");
        for (String s : array) {
            System.out.println(s);
        }
        System.out.println("nhap ky tu muon tim kiem");
        String letter = scanner.nextLine();
        int count = 0 ;
        for (int i = 0; i < array.length ; i++) {
            if (array[i].equals(letter) ){
                count ++;
            }
        }
        System.out.println("ky tu: " + letter + " xuat hien " + count + " lan");
    }
}
