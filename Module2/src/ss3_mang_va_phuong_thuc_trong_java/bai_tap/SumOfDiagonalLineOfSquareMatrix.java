package ss3_mang_va_phuong_thuc;
import java.util.Scanner;
public class SumOfDiagonalLineOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhap size cua ma tran vuong");
        int size = scanner.nextInt();

        int [][] matrix = new int[size][size];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                matrix[i][j] = (int) (Math.random()*99);
            }
        }
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
         int sum = 0;
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size ; j++) {
                if (i ==j){
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println("tong cac so cua duong cheo la: " + sum);

    }

}
