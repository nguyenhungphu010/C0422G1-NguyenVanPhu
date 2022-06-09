package ss3_mang_va_phuong_thuc;

import java.util.Scanner;

public class SumOfRandomCollum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap gia tri hang cua ma tran: ");
        int row = scanner.nextInt();
        System.out.println("nhap gia tri cot cua ma tran: ");
        int collum = scanner.nextInt();

        int[][] matrix = new int[row][collum];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < collum; j++) {
                matrix[i][j] = (int) (Math.random() * 99);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < collum; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("\n");
        }

        System.out.println(" nhap so thu cot muon tinh tong: ");
        int selectedCollum = scanner.nextInt();
        if (selectedCollum > collum || selectedCollum < 0) {
            System.out.println("nhap khong dung ");
        } else {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < collum; j++) {
                    if (j == selectedCollum - 1) {
                        sum += matrix[i][j];
                    }
                }
            }
            System.out.println("sum of selected collum is: " + sum);
        }
    }
}
